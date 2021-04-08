package com.staykeep.jms;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class JMSMessageSender {

	// JmsTemplate
	private JmsTemplate jmsTemplate;

	// Queue
	private Queue destinationQueue;
	
	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	// Auto-wired setter. Nothing calls this.
	@Autowired
	public void setDestinationQueue(Queue destinationQueue) {
		this.destinationQueue = destinationQueue;
	}
	
	public void sendMessage(String msg) {
		// Sends a message to the destination queue
		jmsTemplate.send(destinationQueue, session -> session.createTextMessage(msg));
	}
}