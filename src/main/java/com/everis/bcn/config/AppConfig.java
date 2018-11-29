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
@ComponentScan(basePackageClasses = EntityManagerConfig.class)
@Configuration
public class AppConfig {

	@Bean
	public EntityManager getEntity() {
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
}
