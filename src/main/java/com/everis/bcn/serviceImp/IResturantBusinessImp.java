package com.everis.bcn.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.bcn.model.BookingAssembler;
import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.dto.Dto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.model.MessageString;
import com.everis.bcn.model.ModdelMapperConfig;
import com.everis.bcn.service.IResturantBusiness;

/**
 * 
 * @author J Michael
 *
 */
@Service
public class IResturantBusinessImp implements IResturantBusiness {
	
	@Autowired private BookingDAOImp bookinDao;
	@Autowired private RestaurantDAOImp restaurantDao;
	@Autowired private TurnDAOImp turnDAO;
	@Autowired private MesaDAOImp mesaDao;
	
	@Autowired private MessageString messageString;
	@Autowired private BookingAssembler bookingAssembler;
	@Autowired private ModdelMapperConfig moddelMapperConfig;
	
	
	@Override
	public boolean editBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean cancelBooking(Booking bookingFromDto) {
		boolean resp = true;
		Booking booking_cancel_aux = bookinDao.get(bookingFromDto.getLocalizador());
		if (booking_cancel_aux == null || !bookingFromDto.equals(booking_cancel_aux)) resp = false;
		else bookinDao.delete(booking_cancel_aux.getBookingId());
		return resp;
	}

	@Override
	public boolean reserve(Booking booking) {
		boolean resp = true;
			Set<Mesa> setMesa = mesaDao.getMesasIdOfTheRestaurant(booking.getRestaurant().getRestaurantId());
			Set<Mesa> setBookingMesa = bookinDao.getMesasOfTheTurn(booking.getRestaurant().getRestaurantId(), 
					booking.getTurn().getTurnId(), booking.getDay());
			List<Mesa> listMesasAvailablesCapacity = setMesa.stream().filter(mesa -> (!setBookingMesa.contains(mesa) 
					&& booking.getPersonas()<=mesa.getCapacity())).collect(Collectors.toList());
			
			booking.setMesa(listMesasAvailablesCapacity.size()>0? listMesasAvailablesCapacity.get(0): null);
			
			if (booking.getMesa() != null) {
				booking.setLocalizador(generateLocalizator(booking));
				bookinDao.save(booking);
				
			} else resp = false;
			 
		return resp;
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		restaurantDao.save(restaurant);
	}
	
	@Override
	public Set<Restaurant> getRestaurants() {
		return restaurantDao.getAll();
	}
	

	@Override
	public Set<Turn> getTurns() {
		return turnDAO.getAll();
	}
	

	@Override
	public Set<Booking> getBookings() {
		return bookinDao.getAll();
	}
	
	/**
	 * generate Localizator
	 * @param booking
	 * @return
	 */
	private long generateLocalizator(Booking booking) {
		return Long.parseLong(""+booking.getRestaurant().getRestaurantId() + booking.getMesa().getId() +
				+ booking.getTurn().getTurnId() +  MessageString.getFormat().format(booking.getDay())
				.replaceAll("-", ""));
	}
	
	/***
	 * message By Register
	 * Booking
	 * @param booking
	 * @return
	 */
	public String manageReserve(Dto dto) {
		Booking booking = bookingAssembler.getBookingFromDto(dto, moddelMapperConfig.getModelMapperBooking());
		messageString.setSuccess_booking(new StringBuilder());
		return (IsThereTableAvailable(booking.getRestaurant().getRestaurantId(), 
				booking.getTurn().getTurnId(), booking.getDay()))? reserve(booking)? 
						messageString.getSuccess_booking().append(reserveDetail(booking)).toString():MessageString.getFailedCapacity() : MessageString.getFailedMesas();
	}
	
	/***
	 * return boolean of table
	 * available by turn in restaurant
	 * @param RestaurantId
	 * @param turnId
	 * @return
	 */
	@Transactional
	public boolean IsThereTableAvailable(int restaurantId, int turnId, Date day) {
		return mesaDao.getMesasIdOfTheRestaurant(restaurantId).stream().filter(
				mesa -> (!bookinDao.getMesasOfTheTurn(restaurantId, turnId, day)
						.contains(mesa))).collect(Collectors.toList()).size()>0;
	}
	
	
	/**
	 * info detail string
	 * @return
	 */
	private String reserveDetail(Booking booking) {
		return " detail : Codigo de Restaurant - " + booking.getRestaurant().getRestaurantId() + "," + 
						"Mesa - " + booking.getMesa().getId() + "," + 
						"Day - " + MessageString.getFormat().format(booking.getDay()) + "," +  
						"Turno - " + booking.getTurn().getTurnId() + "," +  
						"Localizator : " + booking.getLocalizador();
	}
	
	/***
	 * 
	 * @param bookingFromDto
	 * @return
	 */
	public String manageCancelReserve(Dto dto) {
		Booking booking = bookingAssembler.getBookingFromDto(dto, moddelMapperConfig.getModelMapperBookingCancel());
		return cancelBooking(booking)? messageString.getSuccess_cancelBooking().toString() : messageString.getFailedCancel();
	}
}
