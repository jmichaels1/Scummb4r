package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author J Michael
 *
 */
//@Configuration
//@ComponentScan("com.everis.bcn")
public class AppConfig {
	
	protected EntityManager entityManager;
	
/*//	@Bean
	public EntityManager getEntity() {
		return	Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}*/

	public AppConfig() {
		entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
	
	
}


