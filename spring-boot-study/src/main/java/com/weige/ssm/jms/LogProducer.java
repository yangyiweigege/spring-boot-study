package com.weige.ssm.jms;

import javax.jms.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogProducer/* implements CommandLineRunner */{

	private final static Logger logger = Logger.getLogger(LogProducer.class);

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue logQueue;
	

	//@Override
	public void run(String... strings) throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("This is a log message  :  ");
		for (String string : strings) {
			content.append(string+ ",");
		}
		send(content.toString());
		logger.info("Log Message was sent to the Queue named sample.log");
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(logQueue, msg);
	}
}