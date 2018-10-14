package com.everis.bcn.dto;

import java.lang.reflect.Array;
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
public class BookDto {
	
	private ArrayList<Restaurant> aListRenstaurant;
	private ArrayList<Turn> aListTurn;
	
	private int restaurantId;
	private Date dia;
	private int turnId;
	private int persons;
	private Mesa mesa;

}
