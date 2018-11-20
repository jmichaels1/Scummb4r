package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.google.common.collect.Sets;

@Component
public class RestaurantDAOImp implements Dao<Restaurant> {
	
//	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    EntityManager entityManager = ctx.getBean(EntityManager.class);
	
	@PersistenceContext
	EntityManager entityManager;

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
