package com.everis.bcn.daoImp;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Booking;

/**
 * 
 * @author J Michael
 *
 */
public class BookDAOImp extends AppConfig implements Dao<Booking> {
	

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
	public Booking get(int id) {
		return entityManager.find(Booking.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		Booking b = get(id);
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public ArrayList<Booking> getAll() {
		return (ArrayList<Booking>) entityManager
				.createQuery("Select a From Booking a", Booking.class)
				.getResultList();
	}	
	
//	@Override
//	public void setHm(HibernateManagerDB hm) {
//		this.hm = hm;
//	}
//	
//	@Override
//	public HibernateManagerDB getHm() {
//		return hm;
//	}
	
}
