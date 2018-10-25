package com.everis.bcn.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Controller
public class BookingController {
	
	private IResturantBusinessImp iResturantBusinessImp;
	
	
	@RequestMapping(value="booking")
	public ModelAndView booking() {
	//	return new ModelAndView("booking", "bookingDto", new BookingDto(new Date()));
		return new ModelAndView("booking");
	}
	
	@ModelAttribute("aListRestaurnt")
	public ArrayList<Integer> getRestaurantIdList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		ArrayList<Integer> aListRestaurnt = new ArrayList<Integer>();
		iResturantBusinessImp.getRestaurants().stream().forEach((restaurant) -> {
			aListRestaurnt.add(restaurant.getId());
		});
		return aListRestaurnt;
	}
	
	@ModelAttribute("aListTurn")
	public ArrayList<Integer> getTurnList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		ArrayList<Integer> aListTurn = new ArrayList<Integer>();
		iResturantBusinessImp.getRestaurants().stream().forEach((turn) -> {
			aListTurn.add(turn.getId());
		});
		return aListTurn;
	}

}
