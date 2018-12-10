package com.everis.bcn.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Component
public class BookingDtoValidate implements Validator {
	
	@Override
	public boolean supports(Class<?> type) {
		return BookingDto.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		BookingDto bookingDto = (BookingDto) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "day",
		        "required.persons", "es olbigatorio indicar el día de la reserva");
		
		if (bookingDto.getPersons() < 1)  errors.rejectValue(null, "Cantidad de Personas para la reserva no es válido");
		if (bookingDto.getDay() == null)  errors.rejectValue(null, "fecha de reserva no es válida");
		
	//	if (!isAvailable) errors.rejectValue(null, "Booking not available"); 
	}

}
