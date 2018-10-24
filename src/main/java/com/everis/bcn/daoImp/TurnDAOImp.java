package com.everis.bcn.daoImp;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public class TurnDAOImp implements Dao<Turn> {
	
	private HibernateManagerDB hm;
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void save(Turn turn) {
		//hm.getEntityManager().persist(turn);
		entityManager.persist(turn);
	}

	@Override
	public void update(Turn turn) {
		hm.getEntityManager().merge(turn);
	}

	@Override
	public Turn get(int id) {
		return hm.getEntityManager().find(Turn.class, id);
	}

	@Override
	public void delete(int id) {
		hm.getEntityManager().remove(get(id));
	}

	@Override
	public ArrayList<Turn> getAll() {
		return (ArrayList<Turn>) hm.getEntityManager()
				.createQuery("Select a From Turn a", Turn.class)
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
