package com.everis.bcn.dao;

import java.util.ArrayList;

import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

public interface TurnDAO {
	
	public void addTurn(Turn turn);
	public void updateTurn(Turn turn);
	public Turn getTurn(int id);
	public void deleteTurn(int id);
	public ArrayList<Turn> getTurns();
	
	public void setHm(HibernateManagerDB hm);
	public HibernateManagerDB getHm();

}
