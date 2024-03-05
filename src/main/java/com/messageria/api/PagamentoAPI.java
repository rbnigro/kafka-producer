package com.messageria.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.messageria.dto.PagamentoDTO;
import com.messageria.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {

	@Autowired
	private PagamentoService pagamentoService;
	
	@PostMapping("/pagar")
	String pagar(@RequestBody PagamentoDTO pagamentoDTO) {
		return pagamentoService.integrarPagamento(pagamentoDTO);		
	}
	
//	@GetMapping("/publish")
//	ResponseEntity<String> publish(@RequestParam("message") String message) {
//		return 
//	}
}
