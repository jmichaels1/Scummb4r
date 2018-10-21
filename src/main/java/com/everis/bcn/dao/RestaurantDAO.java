package com.everis.bcn.dao;

import java.util.ArrayList;

import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public interface RestaurantDAO {
	
	public void addRestaurant(Restaurant restaurant);
	public void updateRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(int id);
	public void deleteRestaurant(int id);
	public ArrayList<Restaurant> getRestaurants();
	
	public void setHm(HibernateManagerDB hm);
	public HibernateManagerDB getHm();


}
