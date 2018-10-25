package com.everis.bcn.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.bcn.entity.Turn;


/**
 * 
 * @author jsalirio
 *
 */
@Controller
public class HelloWordController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloWordController.class);
	
	@Autowired
	private EntityManager entityManager;

	
	/**
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("hello")
	public String home(@RequestParam(value="name", required = false)String name, Model model) {
		logger.info("Welcome ! The client locale is : ", name);
		model.addAttribute("name", name);
		
//		Turn t1 = new Turn();
//		//	t1.setId(2);
//		t1.setDescription("jejejejexD");
//		System.out.println("PERSIST BEFORE");
//		entityManager.persist(t1);
//		System.out.println("PERSIST AFTER");
		return "hello";
	}
	
}
