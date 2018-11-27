package com.everis.bcn.assemblerDto;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.dto.Dto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/***
 * 
 * @author J Michael
 *
 */
public class BookingAssembler extends IResturantBusinessImp {
	
	private Booking booking;

	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public Booking getBookingFromDto(Dto dto, ModelMapper modelMapper) {
		booking = new Booking();
		modelMapper.map(dto, booking);
		return booking;
	}
}
