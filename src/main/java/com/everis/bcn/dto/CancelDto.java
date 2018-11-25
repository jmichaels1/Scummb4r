package com.everis.bcn.dto;

import java.util.ArrayList;
import java.util.Date;

import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author J Michael
 *
 */
public class CancelDto {
	
	private ArrayList<Restaurant> aListRenstaurant;
	private ArrayList<Turn> aListTurn;
	
	private int restaurantId;
	private Date day;
	private int turnId;
	private int localizator;
	
	/*** Getters And Setters ****/
	
	public ArrayList<Restaurant> getaListRenstaurant() {
		return aListRenstaurant;
	}
	public void setaListRenstaurant(ArrayList<Restaurant> aListRenstaurant) {
		this.aListRenstaurant = aListRenstaurant;
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
	public int getLocalizator() {
		return localizator;
	}
	public void setLocalizator(int localizator) {
		this.localizator = localizator;
	}
	
	/******* Métodos agregados **********/
	
	public Restaurant getResturant() {
		return new RestaurantDAOImp().get(restaurantId);
	}
	
	public Turn getTurn() {
		return new TurnDAOImp().get(turnId);
	}
}
