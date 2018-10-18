package com.everis.bcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OurRestaurantsController {
	
	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public ModelAndView restaurants() {
		ModelAndView model = new ModelAndView("restaurants");
		return model;
	}

}
