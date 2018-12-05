package com.everis.bcn.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.everis.bcn.assemblerDto.BookingAssembler;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;

public class Test3 {
	
	public static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * test
	 * @return
	 */
	public static ModelMapper modelMapperBookingConfig() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration (). setAmbiguityIgnored (true);
		modelMapper.addMappings(new PropertyMap<BookingDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturantFromDto()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurnFromDto());
				map().setPersonas(source.getPersons());
			}
		});
		return modelMapper;
	}
	
	public static void main(String[] args) throws ParseException {
		
		BookingAssembler assembler = new BookingAssembler();
		BookingDto dto = new BookingDto();
		
		dto.setRestaurantName("Goiko");
		dto.setDay(FORMAT.parse("2019-12-10"));
		dto.setTurn(4);
		dto.setPersons(4);

		
		System.out.println("Booking from dto : " + assembler.getBookingFromDto(dto, modelMapperBookingConfig()));
		
	}
}
