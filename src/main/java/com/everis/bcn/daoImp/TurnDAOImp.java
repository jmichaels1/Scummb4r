package com.everis.bcn.daoImp;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Turn;
import com.google.common.collect.Sets;

/**
 * 
 * @author J Michael
 *
 */
public class TurnDAOImp implements Dao<Turn> {
	
//	@Autowired EntityManager entityManager;
	
	@Autowired private AppConfig appConfig;
	
	@Override
	public void save(Turn turn) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().persist(turn);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Turn turn) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().merge(turn);
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Turn get(int id) {
		return appConfig.getEntityManager().find(Turn.class, id);
	}

	@Override
	public void delete(int id) {
		appConfig.getEntityManager().getTransaction().begin();
		appConfig.getEntityManager().remove(get(id));
		appConfig.getEntityManager().getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Set<Turn> getAll() {
		return Sets.newHashSet((ArrayList<Turn>) appConfig.getEntityManager()
				.createQuery("Select a From Turn a", Turn.class)
				.getResultList());
	}

}
