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
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.everis.bcn.dao"),
		@ComponentScan("com.everis.bcn.service") })
public class AppConfig {

	// private EntityManager entityManager;
	//
	// @Bean
	// public EntityManager getEntity() {
	// if (entityManager != null) entityManager =
	// Persistence.createEntityManagerFactory("persistence").createEntityManager();
	// return entityManager;
	// }

	// public AppConfig() {
	// if (entityManager == null) entityManager =
	// Persistence.createEntityManagerFactory("persistence").createEntityManager();
	// }

	@Bean
	public LocalEntityManagerFactoryBean geEntityManagerFactoryBean() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("persistence");
		return factoryBean;
	}

	@Bean
	public JpaTransactionManager geJpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(geEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	@Bean
	public IResturantBusiness negocio() {
		return new IResturantBusinessImp();
	}

}
