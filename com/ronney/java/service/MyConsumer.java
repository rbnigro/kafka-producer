package com.ronney.java.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyConsumer {
	
	@KafkaListener(topics = "kafka-topic", groupId = "group-1")
	public void receiveMEssage(String message) {
		System.out.println("Consumer Message: " + message);
	}
	
}
