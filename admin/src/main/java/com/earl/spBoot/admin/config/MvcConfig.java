package com.earl.spBoot.admin.config;

import com.earl.spBoot.admin.filter.FrameworkFilter;
import com.earl.spBoot.admin.interceptor.RequestInterceptor;
import com.earl.spBoot.admin.interceptor.RequestReportInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * mvc相关配置
 * Created by earl on 2017/3/20.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    //单纯跳转页面的配置，简化controller的跳转页面的代码
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //主页
        registry.addViewController("/").setViewName("/index");

        //demo模块
        registry.addViewController("/demo").setViewName("/demo/list");
        registry.addViewController("/demo/add").setViewName("/demo/add");
    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestReportInterceptor());
        registry.addInterceptor(new RequestInterceptor());
    }

    /**
     * 过滤器配置
     * @return
     */
    @Bean
    public FrameworkFilter frameworkFilter(){
        return new FrameworkFilter();
    }
}
