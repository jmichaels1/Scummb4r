package com.everis.bcn.model;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;

/***
 * 
 * @author jsalirio
 *
 */
@Component
public class ModdelMapperConfig {
	
	private ModelMapper modelMapperBooking;
	private ModelMapper modelMapperBookingCancel;
	
	/***
	 * Constructor Default
	 */
	public ModdelMapperConfig() {
		modelMapperBookingConfig();
		modelMapperCancelConfig();
	}

	/**** getters and setters *****/

	public ModelMapper getModelMapperBooking() {
		return modelMapperBooking;
	}

	public void setModelMapperBooking(ModelMapper modelMapperBooking) {
		this.modelMapperBooking = modelMapperBooking;
	}

	public ModelMapper getModelMapperBookingCancel() {
		return modelMapperBookingCancel;
	}

	public void setModelMapperBookingCancel(ModelMapper modelMapperBookingCancel) {
		this.modelMapperBookingCancel = modelMapperBookingCancel;
	}
	
	/***** Metods Agregados ******/
	
	/**
	 * config modelmapper booking
	 * by reserve mapping
	 * @return
	 */
	public void modelMapperBookingConfig() {
		modelMapperBooking = new ModelMapper();
		modelMapperBooking.getConfiguration (). setAmbiguityIgnored (true);
		modelMapperBooking.addMappings(new PropertyMap<BookingDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturantFromDto()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurnFromDto());
				map().setPersonas(source.getPersons());
			}
		});
//		return modelMapper;
	}
	
	/**
	 * config modelmapper cancel booking
	 * @return
	 */
	public void modelMapperCancelConfig() {
		modelMapperBookingCancel = new ModelMapper();
		modelMapperBookingCancel.getConfiguration (). setAmbiguityIgnored (true);
		modelMapperBookingCancel.addMappings(new PropertyMap<CancelDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturantFromDto()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurnFromDto());
				map().setLocalizador(source.getLocalizator());
			}
		});
//		return modelMapper;
	}
}
