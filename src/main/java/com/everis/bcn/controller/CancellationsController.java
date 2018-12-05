package com.everis.bcn.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.assemblerDto.BookingAssembler;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.model.BookingDtoValidate;
import com.everis.bcn.serviceImp.IResturantBusinessImp;


/**
 * 
 * @author J Michael
 *
 */
@Controller("/cancel")
public class CancellationsController extends BookingAssembler  {
	
	private IResturantBusinessImp iResturantBusinessImp;
	private CancelDto cancelDto;
	private ArrayList<Integer> aListRestaurnt;
	private ArrayList<Integer> aListTurn;

	public CancellationsController() {
		cancelDto = new CancelDto();
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
		iResturantBusinessImp = new IResturantBusinessImp();
//		dtoValidate = new BookingDtoValidate();
		ModelAndView mv = new ModelAndView();   
		
//		dtoValidate.validate(dto, result);
//		if (!result.hasErrors()) {
			mv.setViewName("infRegCancelBooking");
			mv.addObject("message", iResturantBusinessImp.messageByCancelBooking(getBookingFromDto(dto, modelMapperCancelConfig()))); 
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
		return (ArrayList<String>) new IResturantBusinessImp().getRestaurants().stream()
				.map(restaurant->restaurant.getName()).collect(Collectors.toList());
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("aListTurn")
	public ArrayList<Integer> getTurnList(){
		return (ArrayList<Integer>) new IResturantBusinessImp().getTurns().stream()
				.map(turn->turn.getTurnId()).collect(Collectors.toList());
	}
}
