package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.BookDAOImp;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public class BookAndTurnDAOImp implements BookDAOImp {

	HibernateManagerDB hm;

	/**** implements BookingDAO *****/
	

	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBooking(Booking booking) {
		// TODO Auto-generated method stub

	}

	@Override
	public Booking getBooking(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBooking(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Booking> getBookings() {
		// TODO Auto-generated method stub
		return null;
	}

	/**** implements turnDAO *****/

	@Override
	public void addTurn(Turn turn) {
		hm = new HibernateManagerDB("persistence");

		hm.beginTransaction();
		hm.persistObj(turn);
		hm.commitTransaction();
		hm.closeTransaction();
	}

	@Override
	public void updateTurn(Turn turn) {
		

	}

	@Override
	public Turn getTurn(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTurn(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Turn> getTurn() {
		// TODO Auto-generated method stub
		return null;
	}

}
