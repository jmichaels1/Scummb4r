package com.everis.bcn.assemblerDto;

import java.text.SimpleDateFormat;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/***
 * 
 * @author J Michael
 *
 */
public class BookingAssembler extends IResturantBusinessImp {
	
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	private ModelMapper modelMapper;
	private Booking booking;

	/**
	 * get BookingDto object
	 * from booking
	 * @return
	 */
	public Booking getBookingFromDto(BookingDto bookingDto) {
		booking = new Booking();
		modelMapper = modelMapperConfig();
		modelMapper.map(bookingDto, booking);
		booking.setLocalizador(generateLocalizator());
		return booking;
	}
	
	/**
	 * config modelmapper
	 * by reserve mapping
	 * @return
	 */
	public ModelMapper modelMapperConfig() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration (). setAmbiguityIgnored (true);
		modelMapper.addMappings(new PropertyMap<BookingDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturant()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurn());
				map().setPersonas(source.getPersons());
			}
		});
		return modelMapper;
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
