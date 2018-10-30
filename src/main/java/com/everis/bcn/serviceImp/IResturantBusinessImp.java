package com.everis.bcn.serviceImp;

import java.util.ArrayList;
import java.util.Set;

import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.service.IResturantBusiness;

/**
 * 
 * @author J Michael
 *
 */
public class IResturantBusinessImp implements IResturantBusiness {
	
	private BookingDAOImp bookinDao = new BookingDAOImp();
	private RestaurantDAOImp restanurantDao = new RestaurantDAOImp();
	private TurnDAOImp turnDAO = new TurnDAOImp();
	
	@Override
	public boolean editBooking(Booking booking) {
		//TODO como verificar cambio para return boolean
		return false;
	}

	@Override
	public boolean cancelBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reserve(Restaurant restaurant, Booking booking) {
		
		return false;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restanurantDao.save(restaurant);
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() {
		return restanurantDao.getAll();
	}

	@Override
	public ArrayList<Turn> getTurns() {
		return turnDAO.getAll();
	}

	@Override
	public ArrayList<Booking> getBookings() {
		return bookinDao.getAll();
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		return restanurantDao.get(restaurantId);
	}

	@Override
	public Turn getTurn(int turnId) {
		return turnDAO.get(turnId);
	}
	
}
