package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Restaurant;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
public class RestaurantDAOImp implements Dao<Restaurant> {
	
//	@Autowired EntityManager entityManager;
	
	@Autowired private AppConfig appConfig;
	
	@Override
	public void save(Restaurant restaurant) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().persist(restaurant);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Restaurant restaurant) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().merge(restaurant);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Restaurant get(int id) {
		return appConfig.getEntityManager().find(Restaurant.class, id);
	}

	@Override
	public void delete(int id) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().remove(get(id));
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Restaurant> getAll() {
		System.out.println("entityManager is null : " + appConfig.getEntityManager());
		return Sets.newHashSet((ArrayList<Restaurant>) appConfig.getEntityManager()
				.createQuery("Select a From Restaurant a", Restaurant.class)
				.getResultList());
	}
}
