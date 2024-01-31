package com.ronney.java.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronney.java.config.KafkaProducerConfig;
import com.ronney.java.dto.PagamentoDTO;

@Service
public class PagamentoRequestProducer {

	private String sTopicoPagamentoRequest;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public PagamentoRequestProducer() {
		KafkaProducerConfig kafkaProducerConfig = new KafkaProducerConfig();
		sTopicoPagamentoRequest = kafkaProducerConfig.manipulador.getPropPagamentoRequestTopicV1(); 
		System.out.println(sTopicoPagamentoRequest); 
	}
	
	public String sendMessage(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
		String conteudo = "";
		conteudo = objectMapper.writeValueAsString(pagamentoDTO);
		kafkaTemplate.send(sTopicoPagamentoRequest, conteudo);
		return "Pagamento enviado para processamento: " + conteudo;
	}
}
