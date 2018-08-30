package com.qa.springDatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleDvdStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDvdStoreApplication.class, args);
	}
}
