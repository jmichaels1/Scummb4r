package com.everis.bcn.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Turn;

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
	
	@Override
	public void addTurn(Turn turn);
	
	@Override
	public void updateTurn(Turn turn);
	
	@Override
	public Turn getTurn(int id);
	
	@Override
	public void deleteTurn(int id);
	
	@Override
	public ArrayList<Turn> getTurn();

}
