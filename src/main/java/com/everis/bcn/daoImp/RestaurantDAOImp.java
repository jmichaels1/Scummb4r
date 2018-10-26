package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Restaurant;

public class RestaurantDAOImp extends AppConfig implements Dao<Restaurant> {

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
	public ArrayList<Restaurant> getAll() {
		return (ArrayList<Restaurant>) entityManager
				.createQuery("Select a From Restaurant a", Restaurant.class)
				.getResultList();
	}

}
