package com.everis.bcn.dao;

import java.util.ArrayList;

import com.everis.bcn.entity.Turn;

public interface TurnDAOImp {
	
	public void addTurn(Turn turn);
	public void updateTurn(Turn turn);
	public Turn getTurn(int id);
	public void deleteTurn(int id);
	public ArrayList<Turn> getTurn();

}
