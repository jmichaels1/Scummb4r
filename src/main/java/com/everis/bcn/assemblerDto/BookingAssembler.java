package com.everis.bcn.assemblerDto;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/***
 * 
 * @author J Michael
 *
 */
public class BookingAssembler extends IResturantBusinessImp {
	
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd-mm-yyyy");

	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public Booking getBookingFromDto(BookingDto bookingDto) {
		Booking booking = new Booking();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration (). setAmbiguityIgnored (true);
		modelMapper.addMappings(new PropertyMap<BookingDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturant()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurn());
				map().setPersonas(source.getPersons());
				map().setMesa(source.getMesa());
			}
		});
		
		modelMapper.map(bookingDto, booking);
		
		booking.setLocalizador(generateLocalizator(booking));

		return booking;
	}
	
	/**
	 * generate Localizator
	 * @param booking
	 * @return
	 */
	private long generateLocalizator(Booking booking) {
		System.out.println("print from generateLocalizator() : " + booking);
//		return Integer.parseInt("" + booking.getRestaurant().getId() + booking.getTurn().getId() + 
//				booking.getMesa().getId() + FORMAT.format(booking.getDia()).replaceAll("-", ""));
		return Long.parseLong("" + booking.getRestaurant().getRestaurantId() + booking.getTurn().getTurnId() + 
				FORMAT.format(booking.getDay()).replaceAll("-", ""));
	}
	
	
	
	

}
