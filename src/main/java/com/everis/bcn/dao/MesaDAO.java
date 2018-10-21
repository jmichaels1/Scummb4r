package com.everis.bcn.dao;

import java.util.ArrayList;

import com.everis.bcn.entity.Mesa;
import com.everis.bcn.manager.HibernateManagerDB;

/**
 * 
 * @author J Michael
 *
 */
public interface MesaDAO {
	
	public void addMesa(Mesa mesa);
	public void updateMesa(Mesa mesa);
	public Mesa getMesa(int id);
	public void deleteMesa(int id);
	public ArrayList<Mesa> getMesas();
	
	public void setHm(HibernateManagerDB hm);
	public HibernateManagerDB getHm();


}
