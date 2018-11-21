package com.everis.bcn.serviceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.everis.bcn.daoImp.BookingDAOImp;
import com.everis.bcn.daoImp.MesaDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.dto.CancelDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Mesa;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.service.IResturantBusiness;
import com.mysql.cj.xdevapi.Result;

/**
 * 
 * @author J Michael
 *
 */
public class IResturantBusinessImp implements IResturantBusiness {
	
	private BookingDAOImp bookinDao = new BookingDAOImp();
	private RestaurantDAOImp restaurantDao = new RestaurantDAOImp();
	private TurnDAOImp turnDAO = new TurnDAOImp();
	private MesaDAOImp mesaDao = new MesaDAOImp();
	
//	private BookingDAOImp bookinDao;
//	private RestaurantDAOImp restaurantDao;
//	private TurnDAOImp turnDAO;
//	private MesaDAOImp mesaDao;
	
	private StringBuilder success = new StringBuilder("ENHORABUENA, su reserva ha sido registrada : ");
	private static final String FAILED_MESAS = "LO SIENTO, todas las mesas se encuentran reservadas";
	private static final String FAILED_CAPACITY = "LO SIENTO, no hay mesas disponibles para la cantidad de personas";
	
	@Override
	public boolean editBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean cancelBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reserve(Booking booking) {
		boolean resp = true;
			Set<Mesa> setMesa = mesaDao.getMesasIdOfTheRestaurant(booking.getRestaurant().getRestaurantId());
			Set<Mesa> setBookingMesa = bookinDao.getMesasIdOfTheTurn(booking.getRestaurant().getRestaurantId(), booking.getTurn().getTurnId());
			List<Mesa> listMesasAvailables = setMesa.stream().filter(mesa -> (!setBookingMesa.contains(mesa) && booking.getPersonas()<=mesa.getCapacity())).collect(Collectors.toList());
			booking.setMesa(listMesasAvailables.size()>0? listMesasAvailables.get(0): null);
			if (booking.getMesa() == null) resp = false;
			else bookinDao.save(booking);

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
	
	/***
	 * message By Register
	 * Booking
	 * @param booking
	 * @return
	 */
	public String messageByRegisterBooking(Booking booking) {
		return (IsThereTableAvailable(booking.getRestaurant().getRestaurantId(), 
				booking.getTurn().getTurnId()))? reserve(booking)? 
						success.append(booking).toString():FAILED_CAPACITY : FAILED_MESAS;
	}
	
	/***
	 * return boolean of table
	 * available by turn in restaurant
	 * @param RestaurantId
	 * @param turnId
	 * @return
	 */
	@Transactional
	public boolean IsThereTableAvailable(int restaurantId, int turnId) {
		return mesaDao.getMesasIdOfTheRestaurant(restaurantId).stream().filter(
				mesa -> (!bookinDao.getMesasIdOfTheTurn(restaurantId, turnId)
						.contains(mesa))).collect(Collectors.toList()).size()>0;
	}
	
	
	//public String getMessageBooking
}
