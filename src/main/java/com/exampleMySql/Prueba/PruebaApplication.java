package com.exampleMySql.Prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;

@SpringBootApplication
public class PruebaApplication {

	public static void main(String[] args) {

		//le decimos al archivo como se llama el archivo de properties
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(PruebaApplication.class, args);
	}

}
