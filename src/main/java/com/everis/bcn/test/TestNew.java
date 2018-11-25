package com.everis.bcn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

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
	
//	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	//	formatter.setTimeZone(TimeZone.getTimeZone("Europe/Madrid"));
		
		
		MesaDAOImp dao_mesa = new MesaDAOImp();
		BookingDAOImp dao_booking = new BookingDAOImp();
		TurnDAOImp dao_turn = new TurnDAOImp();
		RestaurantDAOImp dao_rest = new RestaurantDAOImp();
		
//		Date d = dao_booking.get(1).getDay();
//		System.out.println("fecha desde db : " + FORMAT.format(d));
		
//		Set<Booking> bookingList = dao_rest.get(1).getaListBooking();
//		Set<Booking> bookingList = dao_booking.getAll();
		
//		System.out.println("count booking db : " + bookingList.size());
		
//		bookingList.stream().forEach(booking -> System.out.println("booking getDate : " + booking.getDay()));
				
		
//		Date date;
		try {
//			date = new Date(Calendar.getInstance().getTime().getTime());
//			date = FORMAT.parse("01/11/2018");
//			Restaurant r = new Restaurant();
//			r.setRestaurantId(2);
//			
//			Mesa m = new Mesa();
//			m.setId(5);
//			m.setRestaurant(r);
//			
//			Turn t = new Turn();
//			t.setTurnId(3);
			
			//c.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			//date = formatter.parse("2018-11-02");
			
			//System.out.println("date before : " + date);

//			Booking b = new Booking();
//			b.setDay(formatter.parse("2018-11-05"));
//			b.setMesa(m);
//			b.setRestaurant(r);
//			b.setTurn(t);
//			
//			dao_booking.save(b);
//			
//			System.out.println("date after : " + b.getDay());
			
//			dao_mesa.getMesasIdOfTheRestaurant(2).stream().forEach(Mesa -> System.out.println(Mesa));
//			dao_booking.getMesasIdOfTheTurn(2, 3).stream().forEach(MesaId -> System.out.println(MesaId));
			
//			dao_rest.getAll().stream().forEach(Rest -> System.out.println(Rest));
			
//			dao_rest.get(2).getaListBooking().stream().forEach(booking -> System.out.println(booking));
			
			Booking b = new Booking();
			b.setBookingId(16);
			
			dao_booking.delete(b.getBookingId());
			
			
		
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage() + e.getCause());
		}
	
		}
}
		