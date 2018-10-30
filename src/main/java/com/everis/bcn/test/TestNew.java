package com.everis.bcn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;

public class TestNew {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-mm-yyyy");

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
		
		MesaDAOImp dao_mesa = new MesaDAOImp();
		BookingDAOImp dao_booking = new BookingDAOImp();
		TurnDAOImp dao_turn = new TurnDAOImp();
		RestaurantDAOImp dao_rest = new RestaurantDAOImp();
		
//		Date d = dao_booking.get(1).getDia();
//		System.out.println("fecha desde db : " + FORMAT.format(d));
		
		Set<Booking> bookingList = dao_rest.get(1).getaListBooking();
		
		System.out.println("count booking db : " + bookingList.size());
				
		
//		Date date;
//		try {
//			date = FORMAT.parse("15-09-2018");
//			Restaurant r = new Restaurant();
//			r.setId(1);
//			
//			Mesa m = new Mesa();
//			m.setId(6);
//			m.setRestaurant(r);
//			
//			Turn t = new Turn();
//			t.setId(3);
//			
//			Booking b = new Booking();
//			b.setDia(date);
//			b.setMesa(m);
//			b.setRestaurant(r);
//			b.setTurn(t);
//			
//			dao_booking.save(b);
//			
//		} catch (Exception e) {
//			System.out.println("Erro parse");
//		}
		
		
		
		
		
	}

}
