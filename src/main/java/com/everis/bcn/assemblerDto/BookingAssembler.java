package com.everis.bcn.assemblerDto;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;

/***
 * 
 * @author J Michael
 *
 */
public class BookingAssembler {
	
	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public static Booking getBookingDto(BookingDto bookingDto) {
		Booking booking = new Booking();
	//	booking.setRestaurant(bookingDto.getRestaurantId());
		booking.setDia(bookingDto.getDay());
		booking.setMesa(bookingDto.getMesa());
//		booking.setTurnId(bookingDto.getTurn().getId());
//		booking.setPersons(bookingDto.getPersonas());
		return booking;
	}

}
