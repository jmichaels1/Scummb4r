package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.manager.HibernateManagerDB;

public class RestaurantDAOImp implements Dao<Restaurant> {
	
	private HibernateManagerDB hm;

	@Override
	public void save(Restaurant restaurant) {
		hm.getEntityManager().persist(restaurant);
	}

	@Override
	public void update(Restaurant restaurant) {
		hm.getEntityManager().merge(restaurant);
	}

	@Override
	public Restaurant get(int id) {
		return hm.getEntityManager().find(Restaurant.class, id);
	}

	@Override
	public void delete(int id) {
		hm.getEntityManager().remove(get(id));
	}

	@Override
	public ArrayList<Restaurant> getAll() {
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
