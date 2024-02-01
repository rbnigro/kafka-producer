package com.ronney.java.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

	private KafkaTemplate<String, String> kafkatemplate;
	
	public MyProducer(KafkaTemplate<String, String> kafkatemplate) {
		this.kafkatemplate = kafkatemplate;
	}
	
	public void sendMessage(String message) {
		kafkatemplate.send("kafka-topic", message);
	}
}
