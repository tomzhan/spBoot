package com.earl.spBoot.admin.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 请求访问记录拦截器
 * Created by earl on 2017/3/24.
 */
public class RequestReportInterceptor extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(RequestReportInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            if (log.isInfoEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("\n------------------------------------------------------------------------");
                sb.append("\nweb report [" + Thread.currentThread().getId() + "]\n");

                HandlerMethod handlerMethod = (HandlerMethod) handler;

                sb.append("Controller  : ").append(handlerMethod.getBean().getClass().getName()).append(".(").append(handlerMethod.getBean().getClass().getSimpleName()).append(".java:1)\n");
                sb.append("Method      : ").append(handlerMethod.getMethod().getName()).append("\n");
                sb.append("Url         : ").append(request.getRequestURI()).append("\n");
                // print all parameters
                Enumeration<String> e = request.getParameterNames();
                if (e.hasMoreElements()) {
                    sb.append("Parameter   : ");
                    while (e.hasMoreElements()) {
                        String name = e.nextElement();
                        String[] values = request.getParameterValues(name);
                        if (values.length == 1) {
                            sb.append(name).append("=").append(values[0]);
                        } else {
                            sb.append(name).append("[]={");
                            for (int i = 0; i < values.length; i++) {
                                if (i > 0)
                                    sb.append(",");
                                sb.append(values[i]);
                            }
                            sb.append("}");
                        }
                        sb.append("  ");
                    }
                    sb.append("\n");
                }
                sb.append("--------------------------------------------------------------------------------\n");
                log.info(sb.toString());
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e.getCause());
        }

        return super.preHandle(request, response, handler);
    }

}

