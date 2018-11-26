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
	
	private int restaurantId;
	private Date day;
	private int turnId;
	
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
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getTurnId() {
		return turnId;
	}
	public void setTurnId(int turnId) {
		this.turnId = turnId;
	}
	
/******* Métodos agregados **********/
	
	public Restaurant getResturant() {
		return new RestaurantDAOImp().get(restaurantId);
	}
	
	public Turn getTurn() {
		return new TurnDAOImp().get(turnId);
	}
}
