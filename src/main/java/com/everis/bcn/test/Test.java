package com.everis.bcn.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import com.everis.bcn.entity.Turn;

public class Test {
	

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
//		
		Turn t = new Turn(1, "mañana");
		entityManager.persist(t);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		emFactory.close();

	}

}
