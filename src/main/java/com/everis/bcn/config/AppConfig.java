package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author J Michael
 *
 */
@Configuration
public class AppConfig {
	
	@Bean
	public EntityManager getEntity() {
		return	Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
}


