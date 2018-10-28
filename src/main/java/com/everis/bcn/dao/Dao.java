package com.everis.bcn.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
	public ArrayList<T> getAll();
	
//	public void setHm(HibernateManagerDB hm);
//	public HibernateManagerDB getHm();
	
}
