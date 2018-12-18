package com.everis.bcn.controller;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.model.BookingAssembler;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.model.ReserveValidate;
import com.everis.bcn.model.ModelAttributeConfig;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Controller("/booking")
public class BookingController {
	
	@Autowired private IResturantBusinessImp iResturantBusinessImp;
	@Autowired private ReserveValidate reserveValidate;
	
	/**
	 * Método Constructor
	 */
	public BookingController() {
		reserveValidate = new ReserveValidate();
	}
	
	/**
	 * ModelAndView booking
	 * @return
	 */
	@RequestMapping(value="booking", method=RequestMethod.GET)
	public ModelAndView booking() {
		return new ModelAndView("booking", "command", new BookingDto());
	}
	
	/**
	 * ModelAndView infRegBooking or booking
	 * Depends on registration validation
	 * @param dto
	 * @param result
	 * @param session
	 * @return
	 */
	@RequestMapping(value="booking", method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("command") BookingDto dto, BindingResult result, SessionStatus session){
		ModelAndView mv = new ModelAndView();   
		reserveValidate.validate(dto, result);
		
		if (!result.hasErrors()) {
			mv.setViewName("infReserve");
			mv.addObject("message", iResturantBusinessImp.manageReserve(dto)); 
			
		} else {
			mv.setViewName("booking");
			mv.addObject("command", new BookingDto());
		}
		
		return mv;
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("aListRestaurant")
	public ArrayList<String> getRestaurantIdList(){
		return (ArrayList<String>) iResturantBusinessImp.getRestaurants().stream()
				.map(restaurant->restaurant.getName()).collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("aListTurn")
	public ArrayList<Integer> getTurnList(){
		return (ArrayList<Integer>) iResturantBusinessImp.getTurns().stream()
				.map(turn->turn.getTurnId()).collect(Collectors.toList());
	}

}
