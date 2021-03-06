package com.everis.bcn.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;

/**
 * 
 * @author J Michael
 *
 * @param <T>
 */
public interface Dao<T> {
	
	public void save(T t);
	public void update(T t);
	public T get(int id);
	public void delete(int id);
	public Set<T> getAll();
	
}
