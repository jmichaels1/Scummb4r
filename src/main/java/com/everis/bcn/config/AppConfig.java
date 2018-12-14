package com.everis.bcn.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.everis.bcn.model.BookingAssembler;
import com.everis.bcn.model.MessageString;
import com.everis.bcn.model.ModdelMapperConfig;

/**
 * 
 * @author J Michael
 *
 */
@ComponentScan(basePackageClasses = {EntityManagerConfig.class, MessageString.class, BookingAssembler.class, ModdelMapperConfig.class})
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
	
	@Bean
	public BookingAssembler getAssembler() {
		return new BookingAssembler();
	}
	
	@Bean
	public ModdelMapperConfig getAmoddelMaper() {
		return new ModdelMapperConfig();
	}
	
}
