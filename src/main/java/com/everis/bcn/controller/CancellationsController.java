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


import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.serviceImp.IResturantBusinessImp;


/**
 * 
 * @author J Michael
 *
 */
@Controller("/cancel")
public class CancellationsController  {
	
	@Autowired private IResturantBusinessImp iResturantBusinessImp;

	private ArrayList<Integer> aListRestaurnt;
	private ArrayList<Integer> aListTurn;

	public CancellationsController() {
		
	}
	
	/**
	 * ModelAnview cancel
	 * @return
	 */
	@RequestMapping(value="cancel", method=RequestMethod.GET)
	public ModelAndView cancel() {
		return new ModelAndView("cancel", "command", new CancelDto());
	}
	
	@RequestMapping(value="cancel", method=RequestMethod.POST)
    public ModelAndView formCancel(@ModelAttribute("command") CancelDto dto, BindingResult result, SessionStatus session){
//		iResturantBusinessImp = new IResturantBusinessImp();
//		dtoValidate = new BookingDtoValidate();
		ModelAndView mv = new ModelAndView();   
		
//		dtoValidate.validate(dto, result);
//		if (!result.hasErrors()) {
			mv.setViewName("infRegCancelBooking");
			mv.addObject("message", iResturantBusinessImp.manageCancelReserve(dto)); 
//		} else {
//			mv.setViewName("booking");
//			mv.addObject("command", new BookingDto());
//		}
		
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
