package com.everis.bcn.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public interface BookingDAO {
	
	public void addBooking(Booking booking);
	public void updateBooking(Booking booking);
	public Booking getBooking(int id);
	public void deleteBooking(int id);
	public ArrayList<Booking> getBookings();
	
	public void setHm(HibernateManagerDB hm);
	public HibernateManagerDB getHm();

	
}
