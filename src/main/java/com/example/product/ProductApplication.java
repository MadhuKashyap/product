package com.example.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import lombok.extern.log4j.Log4j2;

@EnableKafka
@SpringBootApplication
@Log4j2
public class ProductApplication {

	public static void main(String[] args) {
		log.info("Starting Product Application...");
		SpringApplication.run(ProductApplication.class, args);
		log.info("Product Application started successfully!");
	}

}
