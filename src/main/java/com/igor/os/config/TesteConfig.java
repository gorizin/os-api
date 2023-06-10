package com.igor.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.os.services.DBService;

@Configuration
@Profile("test")
public class TesteConfig {
	
	@Autowired
	public DBService dbService;

    @Bean
    public void instanciaDB(){
		this.dbService.instanciaDB();
	}
}