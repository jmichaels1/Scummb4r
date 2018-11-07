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
		final BookingDto bookingDto = (BookingDto) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persons",
		        "required.persons", "El campo persons es Obligatorio. refrescar la página");
		
		Restaurant restaurant = bookingDto.getResturant();
		
		restaurant.getaListBooking().stream().forEach((booking) -> {
			if (booking.getRestaurant().getRestaurantId() == bookingDto.getRestaurantId() && 
					booking.getDay().equals(bookingDto.getDay()) && booking.getTurn().getTurnId() == bookingDto.getTurn().getTurnId()) {
				isAvailable = false;
//				break;
			}});
		
		if (!isAvailable) errors.rejectValue(null, "Booking not available"); 
	}

}
