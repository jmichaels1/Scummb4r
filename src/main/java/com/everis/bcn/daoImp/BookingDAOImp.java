package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.config.EntityManagerConfig;
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
	
//	@Autowired private EntityManager entityManager;
	
	@PersistenceContext(unitName = "persistence")
	private EntityManager entityManager;
	
	
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
	
	/***
	 * 
	 * @param localizator
	 * @return
	 */
	public Booking get(long localizator) {
		return entityManager
				.createQuery("Select a "
						+ "From Booking a "
						+ "where a.localizador = " + localizator, Booking.class)
				.getResultList().stream().findFirst().orElse(null);
	}
}
