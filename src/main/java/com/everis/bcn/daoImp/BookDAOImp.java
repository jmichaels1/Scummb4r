package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.entity.Booking;

/**
 * 
 * @author J Michael
 *
 */
public interface BookDAOImp extends TurnDAOImp {
	
	public void addBooking(Booking booking);
	public void updateBooking(Booking booking);
	public Booking getBooking(int id);
	public void deleteBooking(int id);
	public ArrayList<Booking> getBookings();

}
