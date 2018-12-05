package com.everis.bcn.dto;

import com.everis.bcn.entity.Mesa;

/**
 * 
 * @author J Michael
 *
 */
public class BookingDto extends Dto {

	private int persons;
	private Mesa mesa;
	
	/**** Getters And Setters *****/
	
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
