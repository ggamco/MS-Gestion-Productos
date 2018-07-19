package com.cice.gestionproductos.msgestionproductos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsGestionProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionProductosApplication.class, args);
	}
}
