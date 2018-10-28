package com.everis.bcn.daoImp;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.config.AppConfig;
import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author J Michael
 *
 */
public class TurnDAOImp extends AppConfig implements Dao<Turn> {
	
	@Override
	public void save(Turn turn) {
		entityManager.getTransaction().begin();
		entityManager.persist(turn);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public void update(Turn turn) {
		entityManager.getTransaction().begin();
		entityManager.merge(turn);
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public Turn get(int id) {
		return entityManager.find(Turn.class, id);
	}

	@Override
	public void delete(int id) {
		entityManager.getTransaction().begin();
		entityManager.remove(get(id));
		entityManager.getTransaction().commit();
//		entityManager.close();
	}

	@Override
	public ArrayList<Turn> getAll() {
		return (ArrayList<Turn>) entityManager
				.createQuery("Select a From Turn a", Turn.class)
				.getResultList();
	}

}
