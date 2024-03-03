package com.messageria.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
// @EnableKafka
public class KafkaProducerConfig {

	//@Autowired
	//private KafkaProperties kafkaProperties;
	
	//@Bean
	//ProducerFactory<String, String> producerFactory(){
	//	Map<String, Object> properties = kafkaProperties.buildProducerProperties();
	//	return new DefaultKafkaProducerFactory<>(properties);
	//	// Retorna um objeto
	//}
	
	//@Bean
	//KafkaTemplate<String, String> kafkaTemplate() {
	//	return new KafkaTemplate<>(producerFactory());
	//	// Retonra um objeto
	//}
	
	@Bean
	NewTopic pagamentoRequestTopicBuilder() {
		return TopicBuilder
				.name("pagamento.request.topic.v1")
	//			.partitions(1)
	//			.replicas(1)
				.build();
		// Retonra um objeto
	}
}
