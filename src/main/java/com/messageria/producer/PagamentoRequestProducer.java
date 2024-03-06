package com.messageria.producer;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.messageria.dto.PagamentoDTO;

import org.springframework.kafka.support.SendResult;

@Service
public class PagamentoRequestProducer {
	
	@Value("${spring.kafka.producer.pagamento.request.topic.v1}") 
	private String pagamentoRequestTopicV1;

	private static final Logger LOGGER = LoggerFactory.getLogger(PagamentoRequestProducer.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public String sendPagamentoDTO(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
		String conteudo = objectMapper.writeValueAsString(pagamentoDTO);
		LOGGER.info("%s", conteudo);
		kafkaTemplate.send(pagamentoRequestTopicV1, conteudo);
		return "Pagamento enviado para processamento: " + conteudo;
	}
	
	public String sendPublish(String message) {
		CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(pagamentoRequestTopicV1, message);
		completableFuture.whenComplete((result, ex) -> {
			
			LOGGER.info("%s", result.getRecordMetadata().partition());
			
			if (ex == null) {
				System.out.println("Sent Message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to send message=[" + message + "] due to: " + ex.getMessage());
			}
		});
		
		return "Essa foi a mensagem: " + message;
	}

	public String sendPublish2(String message) {
		kafkaTemplate.send(pagamentoRequestTopicV1, message);
		return "Essa foi a mensagem: " + message;
	}

}
