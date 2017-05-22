package com.earl.spBoot.admin.config;

import com.earl.spBoot.common.constants.ResultResponse;
import com.earl.spBoot.common.exception.SyException;
import com.earl.spBoot.common.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局处理类
 * Created by earl on 2017/3/31.
 */
//此注解针对全局controller配置，以下所有方法将会对全局Controller作用
@ControllerAdvice
public class GolbalAdvice {

    private static Logger log = LoggerFactory.getLogger(GolbalAdvice.class);

    //ajax请求
    private static final String AJAX_REQUEST ="XMLHttpRequest";

    //处理所有Controller抛出的Exception异常
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        log.error(exception.getMessage(), exception);
        String requestType = request.getHeader("X-Requested-With");
        //判断是否为ajax请求
        if(StringUtils.equals(AJAX_REQUEST,requestType)){
            ajaxError(exception);
            return null;
        }else {
            return pageError(exception);
        }
    }

    /**
     * 响应错误信息给ajax请求（若是ajax请求出错）
     * @param exception 所有异常
     * @return 响应的错误信息
     */
    public  @ResponseBody  ResultResponse ajaxError(Exception exception ){
        log.error(exception.getMessage());
        if (exception instanceof SyException) {
            return ResultUtil.getError(((SyException) exception).getResultCode());
        } else {
            return ResultUtil.getError( );
        }
    }

    /**
     * 返回错误信息到页面显示（若是页面url请求出错)
     * @param exception 所有异常
     * @return 错误页面
     */
    public ModelAndView pageError(Exception exception){
        ModelAndView view = new ModelAndView("/common/exception");
        //将错误信息显示在页面上
        view.addObject("msg", exception.getMessage());
        return view;
    }


    //所有controller调用requestMapping方法时，可使用在这里设置的属性
    @ModelAttribute
    public void addParam(Model model) {
        //全局增加一个参数值
//        model.addAttribute("msg","全局绑定属性值");
    }

}
