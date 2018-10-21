package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.RestaurantDAO;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.manager.HibernateManagerDB;

public class RestaurantDAOImp implements RestaurantDAO {
	
	private HibernateManagerDB hm;

	@Override
	public void addRestaurant(Restaurant restaurant) {
		hm.getEntityManager().persist(restaurant);
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		hm.getEntityManager().merge(restaurant);
	}

	@Override
	public Restaurant getRestaurant(int id) {
		return hm.getEntityManager().find(Restaurant.class, id);
	}

	@Override
	public void deleteRestaurant(int id) {
		hm.getEntityManager().remove(getRestaurant(id));
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() {
		return (ArrayList<Restaurant>) hm.getEntityManager()
				.createQuery("Select a From Restaurant a", Restaurant.class)
				.getResultList();
	}
	
	@Override
	public void setHm(HibernateManagerDB hm) {
		this.hm = hm;
	}
	
	@Override
	public HibernateManagerDB getHm() {
		return hm;
	}

}
