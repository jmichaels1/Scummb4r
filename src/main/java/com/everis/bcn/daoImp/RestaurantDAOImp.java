package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Restaurant;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
public class RestaurantDAOImp implements Dao<Restaurant> {
	
//	@Autowired private EntityManager entityManager;
	
	@PersistenceContext(unitName = "persistence")
	private EntityManager entityManager;
	
	@Override
	public void save(Restaurant restaurant) {
		entityManager.getTransaction().begin();
		entityManager.persist(restaurant);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Restaurant restaurant) {
		entityManager.getTransaction().begin();
		entityManager.merge(restaurant);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Restaurant get(int id) {
		return entityManager.find(Restaurant.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Restaurant> getAll() {
		System.out.println("entityManager is null : " + entityManager);
		return Sets.newHashSet((ArrayList<Restaurant>) entityManager
				.createQuery("Select a From Restaurant a", Restaurant.class)
				.getResultList());
	}
}
