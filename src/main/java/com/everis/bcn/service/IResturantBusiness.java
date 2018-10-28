package com.everis.bcn.service;

import java.util.ArrayList;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author J Michael
 *
 */
public interface IResturantBusiness {
	
	public boolean editBooking(Booking booking);
	public boolean cancelBooking(Booking booking);
	public boolean reserve(Restaurant restaurant, Booking booking);
	public void addRestaurant(Restaurant restaurant);
	public ArrayList<Restaurant> getRestaurants();
	public ArrayList<Turn> getTurns();
	public ArrayList<Booking> getBookings();
	
	/*** aggregate methods ****/
	
	public Restaurant getRestaurant(int restaurantId);
	public Turn getTurn(int turnId);

}
