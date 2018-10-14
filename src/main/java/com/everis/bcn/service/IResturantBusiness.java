package com.everis.bcn.service;

import java.awt.print.Book;
import java.lang.reflect.Array;
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
	
	public boolean editBokking(Booking booking);
	public boolean cancelBooking(Booking booking);
	public boolean reserve(Restaurant restaurant, Booking booking);
	public void addRestaurant(Restaurant restaurant);
	public ArrayList<Restaurant> getRestaurants();
	public ArrayList<Turn> getTurns();
	public ArrayList<Booking> getBookings();

}
