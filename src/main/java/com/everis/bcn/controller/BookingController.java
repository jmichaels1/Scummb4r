package com.everis.bcn.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.assemblerDto.BookingAssembler;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.model.BookingDtoValidate;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Controller("/booking")
public class BookingController extends BookingAssembler {
	
	private IResturantBusinessImp iResturantBusinessImp;
	private BookingDtoValidate dtoValidate;
	private ArrayList<Integer> aListRestaurnt;
	private ArrayList<Integer> aListTurn;
	
	/**
	 * Método Constructor
	 */
	public BookingController() {
		dtoValidate = new BookingDtoValidate();
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
		iResturantBusinessImp = new IResturantBusinessImp();
		dtoValidate = new BookingDtoValidate();
		ModelAndView mv = new ModelAndView();   
		
		dtoValidate.validate(dto, result);
		if (!result.hasErrors()) {
			mv.setViewName("infRegBooking");
			mv.addObject("message", iResturantBusinessImp
					.messageByRegisterBooking(getBookingFromDto(dto, this.modelMapperBookingConfig()))); 
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
	@ModelAttribute("aListRestaurnt")
	public ArrayList<Integer> getRestaurantIdList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		aListRestaurnt = new ArrayList<Integer>();
		iResturantBusinessImp.getRestaurants().stream().forEach(rest->aListRestaurnt.add(rest.getRestaurantId()));
		return aListRestaurnt;
	}
	
	/**
	 * 
	 * @return
	 */
	@ModelAttribute("aListTurn")
	public ArrayList<Integer> getTurnList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		aListTurn = new ArrayList<Integer>();
		iResturantBusinessImp.getTurns().stream().forEach(rest->aListTurn.add(rest.getTurnId()));
		return aListTurn;
	}
}
