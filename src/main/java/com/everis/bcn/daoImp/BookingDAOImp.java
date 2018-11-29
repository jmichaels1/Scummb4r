package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;

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
	
//	@Autowired EntityManager entityManager;
	
	@Autowired private AppConfig appConfig;
	
	@Override
	public void save(Booking booking) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().persist(booking);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Booking booking) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().merge(booking);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}
	
	@Override
	public Booking get(int bookingId) {
		return appConfig.getEntityManager().find(Booking.class, bookingId);
	}

	@Override
	public void delete(int id) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().remove(get(id));
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Booking> getAll() {
		return Sets.newHashSet((ArrayList<Booking>) appConfig.getEntityManager()
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
		return Sets.newHashSet((ArrayList<Mesa>) appConfig.getEntityManager()
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
		return appConfig.getEntityManager()
				.createQuery("Select a "
						+ "From Booking a "
						+ "where a.localizador = " + localizator, Booking.class)
				.getResultList().stream().findFirst().orElse(null);
	}
}
