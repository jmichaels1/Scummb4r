package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.TurnDAO;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public class TurnDAOImp implements TurnDAO {
	
	private HibernateManagerDB hm;
	
	@Override
	public void addTurn(Turn turn) {
		hm.getEntityManager().persist(turn);
	}

	@Override
	public void updateTurn(Turn turn) {
		hm.getEntityManager().merge(turn);
	}

	@Override
	public Turn getTurn(int id) {
		return hm.getEntityManager().find(Turn.class, id);
	}

	@Override
	public void deleteTurn(int id) {
		hm.getEntityManager().remove(getTurn(id));
	}

	@Override
	public ArrayList<Turn> getTurns() {
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
