package com.everis.bcn.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.bcn.serviceImp.IResturantBusinessImp;

/***
 * 
 * @author J Michael
 *
 */
//@Component
public class ModelAttributeConfig {
	
	private ArrayList<String> aListRestaurnt;
	private ArrayList<Integer> aListTurn;
	
	/**
	 * Default Constructor
	 */
	public ModelAttributeConfig() {
		config();
	}

	/*** Getters And Setters ***/

	public ArrayList<String> getaListRestaurnt() {
		return aListRestaurnt;
	}

	public void setaListRestaurnt(ArrayList<String> aListRestaurnt) {
		this.aListRestaurnt = aListRestaurnt;
	}

	public ArrayList<Integer> getaListTurn() {
		return aListTurn;
	}

	public void setaListTurn(ArrayList<Integer> aListTurn) {
		this.aListTurn = aListTurn;
	}
	
	/*** Métodos Agregados ****/
	
	/**
	 * attribute config
	 */
	private void config() {
		aListRestaurnt =  (ArrayList<String>) new IResturantBusinessImp().getRestaurants().stream()
				.map(restaurant->restaurant.getName()).collect(Collectors.toList());
		aListTurn = (ArrayList<Integer>) new IResturantBusinessImp().getTurns().stream()
				.map(turn->turn.getTurnId()).collect(Collectors.toList());
	}
}
