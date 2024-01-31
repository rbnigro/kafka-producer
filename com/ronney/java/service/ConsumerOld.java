package com.ronney.java.service;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.stereotype.Service;

import com.ronney.java.config.Manipulador;

@Service
public class ConsumerOld {
	
	private static String sEcommerceCompras;
	private static String sServer;
	private static String sPort;

	public static void main(String[] args) {
		
		Manipulador manipulador = new Manipulador();
		sEcommerceCompras = manipulador.getPropEcommerceCompras();
		sServer = manipulador.getPropServer();
		sPort = manipulador.getPropPort();
		
		var consumer = new KafkaConsumer<String, String>(properties());
		consumer.subscribe(Collections.singletonList(sEcommerceCompras));

		while (true) {
			var records = consumer.poll(Duration.ofMillis(100));
			for (var record : records) {
				System.out.println("Compra Nova:");
				System.out.println(record.key());
				System.out.println(record.value());
				System.out.println(record.offset());
				System.out.println(record.partition());
				System.out.println("------------------------------");
			}
		}

	}

	private static Properties properties() {
		var properties = new Properties();

		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, sServer + ":" + sPort);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "comsumo-cliente-2");

		return properties;
	}

}
