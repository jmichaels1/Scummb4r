package com.everis.bcn.controller;

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
	
	private IResturantBusinessImp business;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "restaurants")
	public ModelAndView restaurants() {
		ModelAndView mv = new ModelAndView("restaurants");
		business = new IResturantBusinessImp();
		mv.addObject("aListRestaurants", business.getRestaurants());
		return mv;
	}

}
