package com.everis.bcn.serviceImp;

import java.util.ArrayList;

import com.everis.bcn.daoImp.BookDAOImp;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;
import com.everis.bcn.service.IResturantBusiness;

/**
 * 
 * @author J Michael
 *
 */
public class IResturantBusinessImp implements IResturantBusiness {
	
	private HibernateManagerDB hm = new HibernateManagerDB("persistence");
	private BookDAOImp bookinDao = new BookDAOImp();
	
	private BookingDto bookdto;
	private CancelDto canceldto;
	
	@Override
	public boolean editBooking(Booking booking) {
		bookinDao.setHm(hm);
		hm.beginTransaction();
		
		return false;
	}

	@Override
	public boolean cancelBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reserve(Restaurant restaurant, Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Turn> getTurns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Booking> getBookings() {
		// TODO Auto-generated method stub
		return null;
	}

}
