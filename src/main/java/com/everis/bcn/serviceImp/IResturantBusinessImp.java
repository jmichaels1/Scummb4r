package com.everis.bcn.serviceImp;

import java.util.ArrayList;

import com.everis.bcn.daoImp.BookDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
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
	private RestaurantDAOImp restanurantDao = new RestaurantDAOImp();
	private TurnDAOImp turnDAO = new TurnDAOImp();
	
	private BookingDto bookdto;
	private CancelDto canceldto;
	
	@Override
	public boolean editBooking(Booking booking) {
		bookinDao.setHm(hm);
		hm.beginTransaction();
		//TODO como verificar cambio para return boolean
		hm.commitTransaction();
		hm.closeTransaction();
		return false;
	}

	@Override
	public boolean cancelBooking(Booking booking) {
		bookinDao.setHm(hm);
		hm.beginTransaction();
		// TODO Auto-generated method stub
		hm.commitTransaction();
		hm.closeTransaction();
		return false;
	}

	@Override
	public boolean reserve(Restaurant restaurant, Booking booking) {
		bookinDao.setHm(hm);
		hm.beginTransaction();
		// TODO Auto-generated method stub
		hm.commitTransaction();
		hm.closeTransaction();
		return false;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restanurantDao.setHm(hm);
		hm.beginTransaction();
		restanurantDao.save(restaurant);
		hm.commitTransaction();
		hm.closeTransaction();
	}

	@Override
	public ArrayList<Restaurant> getRestaurants() {
		restanurantDao.setHm(hm);
		return restanurantDao.getAll();
	}

	@Override
	public ArrayList<Turn> getTurns() {
		turnDAO.setHm(hm);
		return turnDAO.getAll();
	}

	@Override
	public ArrayList<Booking> getBookings() {
		bookinDao.setHm(hm);
		return bookinDao.getAll();
	}

}
