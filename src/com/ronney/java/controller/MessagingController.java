package com.ronney.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronney.java.producer.MyProducer;

@RestController
@RequestMapping("/kafka")
public class MessagingController {

	@Autowired
	private MyProducer service;

	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		service.sendMessage("Olá, " + name);
		return "OK";
	}
	
}
