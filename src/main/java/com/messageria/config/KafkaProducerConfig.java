package com.messageria.config;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaProducerConfig {

	@Autowired
	private KafkaProperties kafkaProperties;
	
	@Value("${spring.kafka.producer.pagamento.request.topic.v1}") 
	private String pagamentoRequestTopicV1;
	
	@Bean
	ProducerFactory<String, String> producerFactory(){
		Map<String, Object> properties = kafkaProperties.buildProducerProperties();
		return new DefaultKafkaProducerFactory<>(properties);
	}
	
	@Bean
	KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	NewTopic pagamentoRequestTopicBuilder() {
		return TopicBuilder
				.name(pagamentoRequestTopicV1)
				.partitions(1)
				.replicas(1)
				.build();
	}
}
