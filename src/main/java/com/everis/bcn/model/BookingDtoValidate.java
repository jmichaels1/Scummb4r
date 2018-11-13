package com.everis.bcn.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
public class BookingDtoValidate implements Validator {
	
	private IResturantBusinessImp iResturantBusinessImp;
	private Boolean isAvailable = true;

	@Override
	public boolean supports(Class<?> type) {
		return BookingDto.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BookingDto bookingDto = (BookingDto) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "day",
		        "required.persons", "es olbigatorio indicar el d�a de la reserva");
		
//		Restaurant restaurant = bookingDto.getResturant();
				
		System.out.println("cantidad personas del dto : " + bookingDto.getPersons());
		if (bookingDto.getPersons() < 1)  errors.rejectValue(null, "Cantidad de Personas para la reserva no es v�lido");
		if (bookingDto.getDay() == null)  errors.rejectValue(null, "fecha de reserva no es v�lida");
		
	//	if (!isAvailable) errors.rejectValue(null, "Booking not available"); 
	}

}
