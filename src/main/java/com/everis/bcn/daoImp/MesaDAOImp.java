package com.everis.bcn.daoImp;

import java.util.ArrayList;

import com.everis.bcn.dao.MesaDAO;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.manager.HibernateManagerDB;

public class MesaDAOImp implements MesaDAO {
	
	private HibernateManagerDB hm;

	@Override
	public void addMesa(Mesa mesa) {
		hm.getEntityManager().persist(mesa);
	}

	@Override
	public void updateMesa(Mesa mesa) {
		hm.getEntityManager().merge(mesa);
	}

	@Override
	public Mesa getMesa(int id) {
		return hm.getEntityManager().find(Mesa.class, id);
	}

	@Override
	public void deleteMesa(int id) {
		hm.getEntityManager().remove(getMesa(id));
	}

	@Override
	public ArrayList<Mesa> getMesas() {
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
