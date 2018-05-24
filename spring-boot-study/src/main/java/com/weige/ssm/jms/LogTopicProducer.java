package com.weige.ssm.jms;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class LogTopicProducer/* implements CommandLineRunner*/ {
	private final static Logger logger = Logger.getLogger(LogTopicProducer.class);

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private ActiveMQTopic logTopic;

	//@Override
	public void run(String... strings) throws Exception {
		StringBuffer content = new StringBuffer();
		content.append("This is a log message  :  ");
		for (String string : strings) {
			content.append(string + ",");
		}
		send(content.toString());
		logger.info("Log Message was sent to the Topic named sample.log");
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(logTopic, msg);
	}
}
