package com.earl.spBoot.admin.interceptor;

import com.earl.spBoot.admin.config.yml.PathYml;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String  projectPath = PathYml.getRootPath() + PathYml.getContextPath();
		request.setAttribute("projectPath",projectPath );
		request.setAttribute("version", PathYml.getVersion() );
		request.setAttribute("prefName", PathYml.getPrefName() );
		return super.preHandle(request, response, handler);
	}


}
