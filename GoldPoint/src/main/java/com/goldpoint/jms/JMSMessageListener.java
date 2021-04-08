package com.goldpoint.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.goldpoint.AppConfig;

@Component
public class JMSMessageListener {
	
	private static final String DESTINATION = AppConfig.LOTUS_QUEUE;
	
	@JmsListener(destination = DESTINATION)
	public void printMessage(String msg) {
		
		
		
	}
}