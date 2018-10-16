package com.everis.bcn.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.bcn.entity.Turn;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HelloWordController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWordController.class);
	
	@PersistenceContext(unitName = "persistence")
	private static EntityManager manager;
	
	@PersistenceUnit(unitName = "persistence")
	private static EntityManagerFactory emf;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("hello")
	public String home(String name, Model model) {
		logger.info("Welcome ! The client locale is : ", name);
		
		manager = emf.createEntityManager();
		
		manager.persist(new Turn(1, "tarde"));
		
		model.addAttribute("name", "jeimmy" );
		return "hello";
	}
	
}
