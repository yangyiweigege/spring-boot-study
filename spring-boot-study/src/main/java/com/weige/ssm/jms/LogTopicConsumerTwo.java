package com.weige.ssm.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;  
  
@Component  
public class LogTopicConsumerTwo {  
  
	private final static Logger logger = Logger.getLogger(LogTopicConsumerTwo.class);
  
    @JmsListener(destination = QueueName.LOG_TOPIC, containerFactory = "jmsListenerContainerTopic")  
    public void receivedQueue(String msg) {  
    	logger.info("Has received from " + QueueName.LOG_TOPIC + ", msg: " + msg);  
    }  
}  
