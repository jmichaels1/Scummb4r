package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.Dao;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.manager.HibernateManagerDB;


/**
 * 
 * @author J Michael
 *
 */
public class MesaDAOImp implements Dao<Mesa> {
	
	private HibernateManagerDB hm;

	@Override
	public void save(Mesa mesa) {
		hm.getEntityManager().persist(mesa);
	}

	@Override
	public void update(Mesa mesa) {
		hm.getEntityManager().merge(mesa);
	}

	@Override
	public Mesa get(int id) {
		return hm.getEntityManager().find(Mesa.class, id);
	}

	@Override
	public void delete(int id) {
		hm.getEntityManager().remove(get(id));
	}

	@Override
	public ArrayList<Mesa> getAll() {
		return (ArrayList<Mesa>) hm.getEntityManager()
				.createQuery("Select a From Mesa a", Mesa.class)
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
