package com.everis.bcn.dto;

import java.util.ArrayList;
import java.util.Date;

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
	private Date dia;
	private int turnId;
	private int locator;

}
