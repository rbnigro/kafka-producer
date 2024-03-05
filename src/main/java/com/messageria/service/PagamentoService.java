package com.messageria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.messageria.dto.PagamentoDTO;
import com.messageria.producer.PagamentoRequestProducer;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRequestProducer pagamentoRequestProducer;
	
	public String integrarPagamento(PagamentoDTO pagamentoDTO) {
		
		try {
			System.out.println("Service");
			return pagamentoRequestProducer.sendMessage(pagamentoDTO);
		} catch (JsonProcessingException e) {
			return "Erro ao solicitar Pagamento" + e.getMessage();
		} 
	}
}
