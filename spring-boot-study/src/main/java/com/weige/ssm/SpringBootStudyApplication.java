package com.weige.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;
/**
 * spring-boot启动入口类
 * @author yangyiwei
 *
 */
@SpringBootApplication // spring-boot 启动类
@MapperScan("com.weige.ssm.dao") // 配置mybatis-dao层扫描
@ComponentScan(basePackages = { "com.weige.ssm" }) // 基本扫包配置
@EnableScheduling // 定时任务配置开启
@EnableAsync // 开启异步任务
//@EnableEurekaClient//服务注册
@EnableJms // 开启JMS消息服务
@ServletComponentScan
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}
}
