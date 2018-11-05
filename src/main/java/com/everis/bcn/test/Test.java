package com.everis.bcn.test;

import java.util.Optional;
import java.util.function.Consumer;


import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

public class Test {
	
//	@PersistenceContext(unitName="persistence", type = PersistenceContextType.EXTENDED)
//	static EntityManager entityManager;
	
//	@PersistenceContext(unitName= "persistence")
//	private static EntityManagerFactory emf;
	

	public static void main(String[] args) {


//		HibernateManagerDB hm = new HibernateManagerDB("persistence");
		
		TurnDAOImp dao_turn = new TurnDAOImp();
		BookingDAOImp dao = new BookingDAOImp();
		RestaurantDAOImp rest_dao = new RestaurantDAOImp();
		MesaDAOImp dao_mesa = new MesaDAOImp();
		
//		td.setHm(hm); // "injection" hm in dao class
//		dao.setHm(hm);
//		rest_dao.setHm(hm);
		
//		hm.beginTransaction();
		
		Turn t1 = new Turn();
//		t1.setTurnId(2);
		t1.setDescription("1");
		
		dao_turn.save(t1);
		
//		Restaurant r = new Restaurant();
//		r.setRestaurantId(1);
//		
//		rest_dao.save(r);
		
//		
//		Mesa m = new Mesa();
//		m.setRestaurant(r);
		
//		dao_mesa.save(m);
		
//		Mesa m = dao_mesa.get(1);
//		System.out.println("get db restaurant : " + m.getRestaurant());
		
//		
//		Booking booking = new Booking();
//		booking.setDay(new Date());
//		booking.setLocalizador(4444);
//		booking.setPersonas(10);
//		booking.setRestaurant(r);
//		booking.setMesa(m);
//		booking.setTurn(t1);
////		
//		dao.save(booking);
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
//		dao.getAll().stream().forEach((booking1) -> {
//			System.out.println(booking1);
//		});
//		
//		Turn turn = tds.getTurn(1);
//		System.out.println("Turn 1 : " + turn);
		
		Restaurant r1 = new Restaurant();
		r1.setAddress("Carrer sant iscle 45");
		r1.setDescription("Buen restaurant, aire acondicionado, vista al mar");
		r1.setName("Suamu");
		
		Restaurant r2 = new Restaurant();
		r2.setAddress("Av diagonal 32");
		r2.setDescription("Ven a disfrutar de nuetras mejores tapas");
		r2.setName("Goiko");
		
		Restaurant r3 = new Restaurant();
		r3.setAddress("Carrer Roma 81");
		r3.setDescription("Los mejors postres al 2 x 1");
		r3.setName("El chino");
		
		rest_dao.save(r1);
		rest_dao.save(r2);
		rest_dao.save(r3);
		
//		dao_turn.save(t1);
		
//		hm.commitTransaction();
//		hm.closeTransaction();
//		
	}

}
