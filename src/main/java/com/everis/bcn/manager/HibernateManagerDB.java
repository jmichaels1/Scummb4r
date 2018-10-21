package com.everis.bcn.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;


/**
 * 
 * @author jsalirio
 *
 */

public class HibernateManagerDB {
	
	EntityManagerFactory emFactory;
	EntityManager entityManager;
	
	
	/**
	 * Contructor default
	 */
	public HibernateManagerDB(String persistXmlFileName) {
		configPersistence(persistXmlFileName);
	}

	
	/**** Getters and Setters *****/


	public EntityManagerFactory getEmFactory() {
		return emFactory;
	}


	public void setEmFactory(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}


	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	/***** métodos de clase *****/
	
	/**
	 * configuration Persistence
	 * @param persistXmlFileName
	 */
	private void configPersistence(String persistXmlFileName) {
		emFactory = Persistence.createEntityManagerFactory(persistXmlFileName);
		entityManager = emFactory.createEntityManager();
	}
	
	/**
	 * begin Transaction
	 */
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}
	
	
	/**
	 * commit Transaction
	 */
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
	
	/**
	 * close Transaction
	 */
	public void closeTransaction() {
		entityManager.close();
	}

}
