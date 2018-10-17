package com.everis.bcn.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.bcn.entity.Turn;

public class Test {
	

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = emFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
//		
		Turn t = new Turn();
		t.setDescription("mañana");
		
		entityManager.persist(t);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		System.out.println("Tudoo Bemmm !!!");
		
		
		emFactory.close();

	}

}
