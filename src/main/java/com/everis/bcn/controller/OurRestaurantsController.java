package com.everis.bcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author jsalirio
 *
 */
@Controller
public class OurRestaurantsController {
	
	@Autowired private IResturantBusinessImp iResturantBusinessImp;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "restaurants")
	public ModelAndView restaurants() {
		ModelAndView mv = new ModelAndView("restaurants");
		mv.addObject("aListRestaurants", iResturantBusinessImp.getRestaurants());
		return mv;
	}

}
