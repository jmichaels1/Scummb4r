package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.BookingDAO;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public class BookDAOImp implements BookingDAO {

	HibernateManagerDB hm; // otra clase lo implementa

	@Override
	public void addBooking(Booking booking) {
		hm.getEntityManager().persist(booking);
	}

	@Override
	public void updateBooking(Booking booking) {
		hm.getEntityManager().merge(booking);
	}

	@Override
	public Booking getBooking(int id) {
		return hm.getEntityManager().find(Booking.class, id);
	}

	@Override
	public void deleteBooking(int id) {
		hm.getEntityManager().remove(getBooking(id));
	}

	@Override
	public ArrayList<Booking> getBookings() {
		return (ArrayList<Booking>) hm.getEntityManager()
				.createQuery("Select a From Booking a", Booking.class)
				.getResultList();
	}	
	
	@Override
	public void setHm(HibernateManagerDB hm) {
		this.hm = hm;
	}
	
	@Override
	public HibernateManagerDB getHm() {
		return hm;
	}
	
}
