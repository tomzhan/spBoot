package com.earl.spBoot.admin;

import com.earl.spBoot.admin.config.yml.PathYml;
import com.earl.spBoot.common.util.DefaultProfileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动主程序
 */
@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties({PathYml.class})  //加载配置文件属性到这些类中
public class AdminApplication {

	private static final Logger log = LoggerFactory.getLogger(AdminApplication.class);

	//启动方法
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(AdminApplication.class);
		DefaultProfileUtils.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		//是否使用ssl
		String protocol = "http";
		if (env.getProperty("server.ssl.key-store") != null) {
			protocol = "https";
		}
		String contextPath = env.getProperty("server.context-path");
		//把contextPath保存起来
		PathYml.setContextPath(contextPath);
		//拼接项目的访问路径，并打印出来
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\t{}://localhost:{}\n\t" +
						"External: \t{}://{}:{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				protocol,
				env.getProperty("server.port")+contextPath,
				protocol,
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port")+contextPath,
				env.getActiveProfiles());
	}

}
