package com.ronney.java.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronney.java.dto.PagamentoDTO;
import com.ronney.java.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {

	@Autowired
	private PagamentoService pagamentoService;
	
	@PostMapping
	public String pagar(@RequestBody PagamentoDTO pagamentoDTO) {
		return pagamentoService.integrarPagamento(pagamentoDTO);		
	}
}
