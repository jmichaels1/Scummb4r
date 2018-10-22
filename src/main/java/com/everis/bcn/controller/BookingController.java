package com.everis.bcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.dto.BookingDto;

/**
 * 
 * @author J Michael
 *
 */
@Controller
public class BookingController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView booking() {
		return new ModelAndView("booking", "booking", new BookingDto());
	}

}
