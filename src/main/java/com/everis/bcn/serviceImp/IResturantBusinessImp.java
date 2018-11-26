package com.everis.bcn.serviceImp;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

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
	
	private ModelMapper modelMapper;
		
	private StringBuilder success = new StringBuilder("ENHORABUENA, su reserva ha sido registrada : ");
	private static final String FAILED_MESAS = "LO SIENTO, todas las mesas se encuentran reservadas";
	private static final String FAILED_CAPACITY = "LO SIENTO, no hay mesas disponibles para la cantidad de personas";
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	
	
	@Override
	public boolean editBooking(Booking booking) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean cancelBooking(Booking booking) {
		boolean resp = true;
		if (!bookinDao.isValidBooking(booking)) resp = false;
		else bookinDao.delete(booking.getBookingId());
		return resp;
	}

	@Override
	public boolean reserve(Booking booking) {
		boolean resp = true;
			Set<Mesa> setMesa = mesaDao.getMesasIdOfTheRestaurant(booking.getRestaurant().getRestaurantId());
			Set<Mesa> setBookingMesa = bookinDao.getMesasIdOfTheTurn(booking.getRestaurant().getRestaurantId(), 
					booking.getTurn().getTurnId());
			List<Mesa> listMesasAvailablesCapacity = setMesa.stream().filter(mesa -> (!setBookingMesa.contains(mesa) 
					&& booking.getPersonas()<=mesa.getCapacity())).collect(Collectors.toList());
			booking.setMesa(listMesasAvailablesCapacity.size()>0? listMesasAvailablesCapacity.get(0): null);
			if (booking.getMesa() != null) {
				booking.setLocalizador(updateMesaLozalizator(booking.getLocalizador(), booking.getMesa().getId()));
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
	
	/***
	 * message By Register
	 * Booking
	 * @param booking
	 * @return
	 */
	public String messageByRegisterBooking(Booking booking) {
		return (IsThereTableAvailable(booking.getRestaurant().getRestaurantId(), 
				booking.getTurn().getTurnId()))? reserve(booking)? 
						success.append(bookingDetail(booking)).toString():FAILED_CAPACITY : FAILED_MESAS;
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
	
	/**
	 * add mesaId 
	 * in lozalizator
	 */
	private long updateMesaLozalizator(long localizator, int mesaId) {
		return  Long.parseLong(String.valueOf(localizator).substring(0, 2) + mesaId 
				+ String.valueOf(localizator).substring(2, String.valueOf(localizator).length()));
	}
	
	/**
	 * info detail string
	 * @return
	 */
	private String bookingDetail(Booking booking) {
		return " detail : Codigo de Restaurant - " + booking.getRestaurant().getRestaurantId() + "\n" + 
						"Mesa - " + booking.getMesa().getId() + "\n" + 
						"Day - " + FORMAT.format(booking.getDay()) + "\n" +  
						"Turno - " + booking.getTurn().getTurnId() + "\n" +  
						"Localizator : " + booking.getLocalizador();
	}
	
	/**
	 * config modelmapper booking
	 * by reserve mapping
	 * @return
	 */
	public ModelMapper modelMapperBookingConfig() {
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
	 * config modelmapper cancel booking
	 * @return
	 */
	public ModelMapper modelMapperCancelConfig() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration (). setAmbiguityIgnored (true);
		modelMapper.addMappings(new PropertyMap<CancelDto, Booking>() {
			@Override
			protected void configure() {
				map().setRestaurant(source.getResturant()); 
				map().setDay(source.getDay());
				map().setTurn(source.getTurn());
				map().setLocalizador(source.getLocalizator());
			}
		});
		return modelMapper;
	}

	public String messageByCancelBooking(Booking bookingFromDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
