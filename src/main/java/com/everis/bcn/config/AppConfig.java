package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.everis.bcn.model.MessageString;

/**
 * 
 * @author J Michael
 *
 */
@ComponentScan(basePackageClasses = {EntityManagerConfig.class, MessageString.class})
@Configuration
public class AppConfig {

	@Bean
	public EntityManager getEntity() {
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}
	
	@Bean
	public MessageString getMessageString() {
		return new MessageString();
	}
	
}
