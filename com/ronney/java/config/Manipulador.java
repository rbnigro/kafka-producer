package com.ronney.java.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulador {

	private String propServer;
	private String propPort;
	private String propOtherPort;
	private String propEcommerceCompras;
	private String propPagamentoRequestTopicV1;
	
	public Manipulador() {
		Properties properties = getProperties();

		propServer = properties.getProperty("prop.server"); 
		propPort = properties.getProperty("prop.port");
		propOtherPort = properties.getProperty("prop.otherport");
		propEcommerceCompras = properties.getProperty("prop.ecommerce.compras");
		propPagamentoRequestTopicV1 = properties.getProperty("prop.pagamento.request.topic.v1");
	
	}


	private static Properties getProperties() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src\\properties\\dados.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}


	public String getPropEcommerceCompras() {
		return propEcommerceCompras;
	}


	public String getPropServer() {
		return propServer;
	}


	public String getPropPort() {
		return propPort;
	}


	public String getPropOtherPort() {
		return propOtherPort;
	}


	public String getPropPagamentoRequestTopicV1() {
		return propPagamentoRequestTopicV1;
	}
	
}
