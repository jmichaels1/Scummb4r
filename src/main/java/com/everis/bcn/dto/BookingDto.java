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
	
	private ArrayList<Restaurant> aListRenstaurant;
	private ArrayList<Turn> aListTurn;
	
	private int restaurantId;
	private Date dia;
	private int turnId;
	private int persons;
	private Mesa mesa;
	
	/**** Getters And Setters *****/
	
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
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
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
	
	
	
	

}
