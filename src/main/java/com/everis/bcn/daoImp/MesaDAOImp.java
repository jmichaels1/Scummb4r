package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
public class MesaDAOImp extends AppConfig implements Dao<Mesa> {

	@Override
	public void save(Mesa mesa) {
		entityManager.getTransaction().begin();
		entityManager.persist(mesa);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Mesa mesa) {
		entityManager.getTransaction().begin();
		entityManager.merge(mesa);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Mesa get(int id) {
		return entityManager.find(Mesa.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Mesa> getAll() {
		return Sets.newHashSet((ArrayList<Mesa>) entityManager
				.createQuery("Select a From Mesa a", Mesa.class)
				.getResultList());
	} 
	
	/******* Métodos Agregados **************/
	

	public Mesa getMesaAvailable(Restaurant restaurant, Turn turn) {
		return (Mesa) entityManager.createQuery("Select a From Booking a where a.restaurant = " + restaurant + " and a.turn = " + turn).getSingleResult();
		
	}

}
