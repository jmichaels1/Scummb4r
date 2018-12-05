package com.everis.bcn.dto;

import java.util.ArrayList;
import java.util.Date;

import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author jsalirio
 *
 */
public abstract class Dto {
	
	private ArrayList<Restaurant> aListRestaurant;
	private ArrayList<Turn> aListTurn;
	
	private String restaurantName;
	private Date day;
	private int turn;
	
	
	/*** Getters And Setters ****/
	
	public ArrayList<Restaurant> getaListRestaurant() {
		return aListRestaurant;
	}
	public void setaListRestaurant(ArrayList<Restaurant> aListRestaurant) {
		this.aListRestaurant = aListRestaurant;
	}
	public ArrayList<Turn> getaListTurn() {
		return aListTurn;
	}
	public void setaListTurn(ArrayList<Turn> aListTurn) {
		this.aListTurn = aListTurn;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantId) {
		this.restaurantName = restaurantId;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
/******* Métodos agregados **********/
	
	public Restaurant getResturantFromDto() {
		return new RestaurantDAOImp().get(restaurantName);
	}
	
	public Turn getTurnFromDto() {
		return new TurnDAOImp().get(turn);
	}
}
