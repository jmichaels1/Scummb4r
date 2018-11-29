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
// @Configuration
// @ComponentScan(basePackageClasses = EntityManagerConfig.class)
@Component
public class AppConfig {

	// @Bean
	// public EntityManager entityManager() {
	// return Persistence
	// .createEntityManagerFactory("persistence")
	// .createEntityManager();
	// }

	private EntityManager entityManager;

	public AppConfig() {
		System.out.println("entra al menos aqui");
//		if (entityManager == null) {
			entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
//		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
