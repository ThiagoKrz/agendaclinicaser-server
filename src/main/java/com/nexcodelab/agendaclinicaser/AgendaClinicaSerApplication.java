package com.nexcodelab.agendaclinicaser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgendaClinicaSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaClinicaSerApplication.class, args);
	}

}
