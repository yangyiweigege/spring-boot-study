package com.weige.ssm.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;  
  
@Component  
public class LogConsumer {  
  
	private final static Logger logger = Logger.getLogger(LogConsumer.class);
  
    @JmsListener(destination = QueueName.LOG_QUEUE)  
    public void receivedQueue(String msg) {  
    	logger.info("Has received from " + QueueName.LOG_QUEUE + ", msg: " + msg);  
    }  
}  
