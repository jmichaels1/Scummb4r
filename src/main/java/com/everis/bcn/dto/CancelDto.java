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
public class CancelDto extends Dto {
	
	private long localizator;
	
	/*** Getters And Setters ****/
	
	public long getLocalizator() {
		return localizator;
	}
	public void setLocalizator(long localizator) {
		this.localizator = localizator;
	}
}
