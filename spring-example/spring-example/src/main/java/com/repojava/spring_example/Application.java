package com.repojava.spring_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.repojava.spring_example.models.ProductModel;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		var product = ProductModel.builder().name("Cesario").build();
		System.out.println(product.getName());
		SpringApplication.run(Application.class, args);
	}

}
