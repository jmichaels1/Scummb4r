package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.everis.bcn.service.IResturantBusiness;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Configuration
@ComponentScan(basePackageClasses = EntityManagerConfig.class)
public class AppConfig {
	
	@Bean
	public EntityManager getEntity() {
		return Persistence
				.createEntityManagerFactory("persistence")
				.createEntityManager();
	}
}
