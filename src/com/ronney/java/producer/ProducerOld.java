package com.ronney.java.producer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

import com.ronney.java.config.Manipulador;

@Service
public class ProducerOld {

	private static String sEcommerceCompras;
	private static String sServer;
	private static String sPort;

	public static void main(String[] args) {
		
		Manipulador manipulador = new Manipulador();
		sEcommerceCompras = manipulador.getPropEcommerceCompras();
		sServer = manipulador.getPropServer();
		sPort = manipulador.getPropPort();
		
		var producer = new KafkaProducer<String, String>(properties()); 
		
		Callback callback = (data, error) -> {
	        if (error != null) {
	        	error.printStackTrace();
		            return;
		        }
		        System.out.println("Mensagem Publicada com sucesso");
		        System.out.println("Partição: " + data.partition());
		        System.out.println("Offset: " + data.offset());
		};
		
		for (Integer i = 0; i < 3; i++) {
			var producerRecord = new ProducerRecord<>(sEcommerceCompras, "Cliente: " + i, "Compra: " + i + " Reais");
			try {
				producer.send(producerRecord, callback).get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	private static Properties properties() {
		var properties = new Properties();
		
		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, sServer + ":" + sPort);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		return properties;
	}
}
