package com.igor.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.os.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	public DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	boolean instanciaDB() {

		this.instanciaDB();

		if (ddl.equals("create")) {
			this.dbService.instanciaDB();
		}

		return false;
	}
}