package com.everis.bcn.assemblerDto;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/***
 * 
 * @author J Michael
 *
 */
public class BookingAssembler extends IResturantBusinessImp {
	
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private Booking booking;

	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public Booking getBookingFromDto(Object bookingDto, ModelMapper modelMapper) {
		booking = new Booking();
		modelMapper.map(bookingDto, booking);
		booking.setLocalizador(generateLocalizator());
		return booking;
	}
	
	/**
	 * generate Localizator
	 * @param booking
	 * @return
	 */
	private long generateLocalizator() {		
		return Long.parseLong(""+booking.getRestaurant().getRestaurantId() 
				+ booking.getTurn().getTurnId() +  FORMAT.format(booking.getDay())
				.replaceAll("/", ""));
	}
}
