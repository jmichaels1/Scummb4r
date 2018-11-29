package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 
 * @author J Michael
 *
 */
//@ComponentScan(basePackageClasses = EntityManagerConfig.class)
@ComponentScan(basePackageClasses = EntityManagerConfig.class)
@Configuration
public class AppConfig {

	@Bean
	public EntityManager entityManagerConfig() {
		return Persistence.createEntityManagerFactory("persistence").createEntityManager();
	}

}
