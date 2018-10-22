package com.everis.bcn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.function.Consumer;


import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.everis.bcn.daoImp.BookDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.manager.HibernateManagerDB;

public class Test {
	
//	@PersistenceContext(unitName="persistence", type = PersistenceContextType.EXTENDED)
//	static EntityManager entityManager;
	
	@PersistenceContext(unitName= "persistence")
	private static EntityManagerFactory emf;
	

	public static void main(String[] args) {


		HibernateManagerDB hm = new HibernateManagerDB("persistence");
		
		TurnDAOImp td = new TurnDAOImp();
		BookDAOImp dao = new BookDAOImp();
		
		td.setHm(hm); // "injection" hm in dao class
		dao.setHm(hm);
		
		hm.beginTransaction();
		
//		Turn t1 = new Turn();
//		t1.setId(2);
//		t1.setDescription("cambio");
		
//		td.updateTurn(t1);
		
//		Booking booking = new Booking();
//		booking.setDia(new Date());
//		booking.setLocalizador(4);
//		booking.setPersonas(10);
		
//		dao.saved(booking);
//
//		ArrayList<Booking> lt = dao.getAll();
//		
//		lt.forEach(new Consumer<Booking>() {
//			@Override
//			public void accept(Booking item) {
//				System.out.println(item);
//			}
//		});
//		
//		Booking booking = new Booking();
//		booking.setDia(new Date());
//		booking.setLocalizador(5);
//		booking.setPersonas(10);
//		
//		dao.save(booking);
//		
//		Optional<Booking> booking_cons = dao.get(2);
//		System.out.println("Booking 1 : " + booking_cons);
		
//		dao.delete(2);
		dao.getAll().stream().forEach((booking1) -> {
			System.out.println(booking1);
		});
//		
//		Turn turn = tds.getTurn(1);
//		System.out.println("Turn 1 : " + turn);
		
		hm.commitTransaction();
		hm.closeTransaction();
		
	}

}
