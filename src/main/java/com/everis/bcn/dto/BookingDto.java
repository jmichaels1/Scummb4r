package com.everis.bcn.dto;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.serviceImp.IResturantBusinessImp;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author J Michael
 *
 */
public class BookingDto {
	
	private ArrayList<Restaurant> aListRestaurant;
	private ArrayList<Turn> aListTurn;
	
	private int restaurantId;
	
	@DateTimeFormat(pattern = "dd/mm/yy") 
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
	
	/******* M�todos agregados **********/
	
	public Restaurant getResturant() {
		IResturantBusinessImp i = new IResturantBusinessImp();
		return i.getRestaurant(restaurantId);
	}
	
	public Turn getTurn() {
		IResturantBusinessImp i = new IResturantBusinessImp();
		return i.getTurn(turnId);
	}
	
	@Override
	public String toString() {
		return "BookingDto [restaurantId=" + restaurantId + ", day=" + day + ", turnId=" + turnId + ", persons="
				+ persons + ", mesa=" + mesa + "]";
	}
	
	
	
	

}
