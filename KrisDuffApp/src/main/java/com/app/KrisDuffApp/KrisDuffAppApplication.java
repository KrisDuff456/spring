package com.app.KrisDuffApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KrisDuffAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KrisDuffAppApplication.class, args);
		
	}
}
