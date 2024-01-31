package com.ronney.java.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

	public Manipulador manipulador;
	
//	@Autowired
//	private KafkaProperties kafkaProperties;
	
	public KafkaProducerConfig() {
		manipulador = new Manipulador();
	}

//	@Bean
//	public ProducerFactory<String, String> producerFactory(){
//		Map<String, Object> properties = kafkaProperties.buildAdminProperties();
//		return new DefaultKafkaProducerFactory<>(properties);
//		// Retorna um objeto
//	}
	
//	@Bean
//	public KafkaTemplate<String, String> kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//		// Retonra um objeto
//	}
	
	@Bean
	public NewTopic pagamentoRequestTopicBuilder() {
		return TopicBuilder
				.name(manipulador.getPropPagamentoRequestTopicV1())
				.partitions(1)
				.replicas(1)
				.build();
		// Retonra um objeto
	}
	
}
