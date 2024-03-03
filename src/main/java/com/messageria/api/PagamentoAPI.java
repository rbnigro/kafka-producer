package com.messageria.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.messageria.dto.PagamentoDTO;
import com.messageria.producer.PagamentoRequestProducer;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoAPI {

	private PagamentoRequestProducer pagamentoRequestProducer;
	
	//@Autowired
	//private PagamentoService pagamentoService;
	
	public PagamentoAPI(PagamentoRequestProducer pagamentoRequestProducer) {
		this.pagamentoRequestProducer = pagamentoRequestProducer;
	}


	@PostMapping("/pagar")
	ResponseEntity<String> pagar(@RequestBody PagamentoDTO pagamentoDTO) {
		try {
			pagamentoRequestProducer.sendMessage(pagamentoDTO);
			return ResponseEntity.ok("Message sent to the topic");
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return (ResponseEntity<String>) ResponseEntity.badRequest();
		}

		// return pagamentoService.integrarPagamento(pagamentoDTO);		
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody PagamentoDTO pagamentoDTO) {
		try {
			pagamentoRequestProducer.sendMessage(pagamentoDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Message send");
	}
	
	@GetMapping("/texto")
	ResponseEntity<String> publish(@RequestParam("message") String message) {
		pagamentoRequestProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}
}
