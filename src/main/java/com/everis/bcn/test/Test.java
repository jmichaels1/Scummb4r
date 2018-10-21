package com.everis.bcn.test;


import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.bcn.dao.BookingDAO;
import com.everis.bcn.dao.TurnDAO;
import com.everis.bcn.daoImp.BookDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.manager.HibernateManagerDB;

public class Test {
	
//	@PersistenceContext(unitName="persistence", type = PersistenceContextType.EXTENDED)
//	static EntityManager entityManager;
	
	@PersistenceContext(unitName= "persistence")
	private static EntityManagerFactory emf;
	

	public static void main(String[] args) {


		HibernateManagerDB hm = new HibernateManagerDB("persistence");
		
		TurnDAO td = new TurnDAOImp();
		BookingDAO bd = new BookDAOImp();
		
		td.setHm(hm); // "injection" hm in dao class
		bd.setHm(hm);
		
		hm.beginTransaction();
		
//		Turn t1 = new Turn();
//		t1.setId(2);
//		t1.setDescription("cambio");
		
//		td.updateTurn(t1);
		
		bd.deleteBooking(1);
//		
		ArrayList<Turn> lt = td.getTurns();
		
		lt.forEach(new Consumer<Turn>() {
			@Override
			public void accept(Turn item) {
				System.out.println(item);
			}
		});
		
//		Booking booking = new Booking();
//		booking.setDia(new Date());
//		booking.setLocalizador(5);
//		booking.setPersonas(10);
//		
//		bd.addBooking(booking);
//		
//		Booking booking_cons = bd.getBooking(1);
//		System.out.println("Booking 1 : " + booking_cons);
//		
//		Turn turn = td.getTurn(1);
//		System.out.println("Turn 1 : " + turn);
		
		hm.commitTransaction();
		hm.closeTransaction();
		
	}

}
