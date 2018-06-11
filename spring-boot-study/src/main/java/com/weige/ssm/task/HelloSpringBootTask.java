package com.weige.ssm.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 功       能: 配置定时任务
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月29日 下午1:58:59
 * Q    Q: 2873824885
 * </pre>
 */
@Component
public class HelloSpringBootTask {

	/**
	 * <pre>
	 * 功       能: 每隔一分钟 执行hello-spring-boot
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月29日 下午2:01:26
	 * Q    Q: 2873824885
	 * </pre>
	 */
	@Scheduled(fixedRate = 30000)
	//@Scheduled(cron = "0 */1 * * * ?")
	public void saySpringBoot() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		System.out.println("当前时间：" + df.format(new Date()) + ": hello spring boot");
	}
}
