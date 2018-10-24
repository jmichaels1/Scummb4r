package com.everis.bcn.daoImp;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public class BookDAOImp implements Dao<Booking> {

	HibernateManagerDB hm; // otra clase lo implementa
	

	@Override
	public void save(Booking booking) {
		hm.getEntityManager().persist(booking);
	}

	@Override
	public void update(Booking booking) {
		hm.getEntityManager().merge(booking);
	}

	@Override
	public Booking get(int id) {
		return hm.getEntityManager().find(Booking.class, id);
	}

	@Override
	public void delete(int id) {
		Booking b = get(id);
		hm.getEntityManager().remove(get(id));
	}

	@Override
	public ArrayList<Booking> getAll() {
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
