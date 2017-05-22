package com.earl.spBoot.business.config;

import com.earl.spBoot.business.service.DemoUserService;
import com.earl.spBoot.business.service.impl.DemoUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置,service必须在这里注册，才能在controller使用@Autowired注入
 * Created by earl on 2017/3/29.
 */
@Configuration
public class ServiceAutoConfig {

    @Bean
    public DemoUserService demoUserService(){
        return new DemoUserServiceImpl();
    }


}
