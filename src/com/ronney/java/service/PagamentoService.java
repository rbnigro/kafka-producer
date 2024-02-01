package com.ronney.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ronney.java.dto.PagamentoDTO;
import com.ronney.java.producer.PagamentoRequestProducer;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRequestProducer pagamentoRequestProducer;
	
	public String integrarPagamento(PagamentoDTO pagamentoDTO) {
		try {
			return pagamentoRequestProducer.sendMessage(pagamentoDTO);
		} catch (JsonProcessingException e) {
			return "Erro ao solicitar Pagamento" + e.getMessage();
		} 
	}
}
