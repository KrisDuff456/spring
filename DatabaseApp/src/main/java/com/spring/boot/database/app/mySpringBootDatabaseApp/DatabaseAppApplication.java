package com.spring.boot.database.app.mySpringBootDatabaseApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DatabaseAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseAppApplication.class, args);
	}
}
