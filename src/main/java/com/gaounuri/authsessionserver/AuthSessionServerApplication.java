package com.gaounuri.authsessionserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class AuthSessionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthSessionServerApplication.class, args);
	}

}
