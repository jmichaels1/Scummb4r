package com.everis.bcn.dto;

import java.util.ArrayList;
import java.util.Date;

import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

/**
 * 
 * @author J Michael
 *
 */
public class BookingDto {
	
	private ArrayList<Restaurant> aListRestaurant;
	private ArrayList<Turn> aListTurn;
	
	private int restaurantId;
	private Date day;
	private int turnId;
	private int persons;
	private Mesa mesa;
	
	
	/**** Getters And Setters *****/
	
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
	
	public int getTurnId() {
		return turnId;
	}
	public void setTurnId(int turnId) {
		this.turnId = turnId;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getDay() {
		return day;
	}


	public void setDay(Date day) {
		this.day = day;
	}
	
	
	
	

}
