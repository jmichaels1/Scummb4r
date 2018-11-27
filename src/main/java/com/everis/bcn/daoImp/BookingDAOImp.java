package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.dao.Dao;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 */
public class BookingDAOImp implements Dao<Booking> {
	
	@Override
	public void save(Booking booking) {
		entityManager.getTransaction().begin();
		entityManager.persist(booking);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Booking booking) {
		entityManager.getTransaction().begin();
		entityManager.merge(booking);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}
	
	//TODO UPDATE FOR GET BOOKING FROM LOCALIZATOR
	@Override
	public Booking get(int bookingId) {
		return entityManager.find(Booking.class, bookingId);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Booking> getAll() {
		return Sets.newHashSet((ArrayList<Booking>) entityManager
				.createQuery("Select a From Booking a", Booking.class)
				.getResultList());
	}	
	
	/***** Métoos Agregados *****/
		
	/**
	 * 
	 * @param restaurantId
	 * @param turnId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheTurn(int restaurantId, int turnId){
		return Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a.mesa "
						+ "From Booking a "
						+ "where a.restaurant.id = " + restaurantId + 
								" and a.turn.id = " + turnId, Mesa.class)
				.getResultList());
	}
	
	/**
	 * valid booking
	 * from cancel dto
	 * @param booking
	 * @return
	 */
	public boolean isValidBooking(Booking booking) {
		System.out.println("booking.getLocalizator : " + booking.getLocalizador());
		Booking booking_aux = entityManager
				.createQuery("Select a "
						+ "From Booking a "
						+ "where a.localizador = " + booking.getLocalizador(), Booking.class)
				.getSingleResult();
		return booking.equals(booking_aux);
	}
}
