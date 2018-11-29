package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Mesa;
import com.google.common.collect.Sets;


/**
 * 
 * @author J Michael
 *
 */
public class MesaDAOImp implements Dao<Mesa> {
	
//	@Autowired EntityManager entityManager;
	
	@Autowired private AppConfig appConfig;
	
	@Override
	public void save(Mesa mesa) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().persist(mesa);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Mesa mesa) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().merge(mesa);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Mesa get(int id) {
		return appConfig.getEntityManager().find(Mesa.class, id);
	}

	@Override
	public void delete(int id) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().remove(get(id));
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Mesa> getAll() {
		return Sets.newHashSet((ArrayList<Mesa>) appConfig.getEntityManager()
				.createQuery("Select a From Mesa a", Mesa.class)
				.getResultList());
	}
	
	/**
	 * get Mesas from restId
	 * @param restaurantId
	 * @return
	 */
	public Set<Mesa> getMesasIdOfTheRestaurant(int restaurantId) {
		return Sets.newHashSet((ArrayList<Mesa>) appConfig.getEntityManager()
				.createQuery("Select a From Mesa a where a.restaurant.id = " + restaurantId, Mesa.class)
				.getResultList());
	}
}
