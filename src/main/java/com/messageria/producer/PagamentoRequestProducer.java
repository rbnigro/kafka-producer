package com.messageria.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messageria.dto.PagamentoDTO;

@Service
public class PagamentoRequestProducer {
	
	@Value("${spring.kafka.producer.pagamento.request.topic.v1}") 
	private String pagamentoRequestTopicV1;

	private static final Logger LOGGER = LoggerFactory.getLogger(PagamentoRequestProducer.class);
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public PagamentoRequestProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		//KafkaProducerConfig kafkaProducerConfig = new KafkaProducerConfig(); aqui retorna um kafkatemplate
	}
	
	public String sendMessage(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
		String conteudo = "";
		conteudo = objectMapper.writeValueAsString(pagamentoDTO);
		LOGGER.info("%s", conteudo);
		kafkaTemplate.send(pagamentoRequestTopicV1, conteudo);
		return "Pagamento enviado para processamento: " + conteudo;
	}
	
	public void sendMessage(String message) {
		LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send("javaguides", message);
	}
}
