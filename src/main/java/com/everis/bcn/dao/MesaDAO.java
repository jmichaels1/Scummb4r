package com.everis.bcn.dao;

import java.util.ArrayList;

import com.everis.bcn.entity.Mesa;

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

}
