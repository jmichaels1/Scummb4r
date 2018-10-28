package com.everis.bcn.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.everis.bcn.assemblerDto.BookingAssembler;
import com.everis.bcn.dto.BookingDto;
import com.everis.bcn.entity.Booking;
import com.everis.bcn.entity.Restaurant;
import com.everis.bcn.entity.Turn;
import com.everis.bcn.serviceImp.IResturantBusinessImp;

/**
 * 
 * @author J Michael
 *
 */
@Controller
public class BookingController extends BookingAssembler {
	
	private IResturantBusinessImp iResturantBusinessImp;
	private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@RequestMapping(value="booking", method=RequestMethod.GET)
	public ModelAndView booking() {
		return new ModelAndView("booking", "command", new BookingDto());
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public ModelAndView form(@ModelAttribute("command") BookingDto dto, BindingResult result, SessionStatus session){
		ModelAndView mv = new ModelAndView();
//		SimpleDateFormat dt1 = new SimpleDateFormat("dd-mm-yyyy");
		Booking booking = getBookingFromDto(dto);
//		System.out.println("soc l'dto: " + dto);
//		System.out.println("soc l'date de dto: " + dt1.format(dto.getDay()));
		System.out.println("Soc l'booking : " + booking);
		return null;
	}
	
	
	@ModelAttribute("aListRestaurnt")
	public ArrayList<Integer> getRestaurantIdList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		final ArrayList<Integer> aListRestaurnt = new ArrayList<Integer>();
		iResturantBusinessImp.getRestaurants().stream().forEach(new Consumer<Restaurant>() {
			@Override
			public void accept(Restaurant restaurant) {
				aListRestaurnt.add(restaurant.getId());
			}
		});
		return aListRestaurnt;
	}
	
	@ModelAttribute("aListTurn")
	public ArrayList<Integer> getTurnList(){
		iResturantBusinessImp = new IResturantBusinessImp();
		final ArrayList<Integer> aListTurn = new ArrayList<Integer>();
		iResturantBusinessImp.getTurns().stream().forEach(new Consumer<Turn>() {
			@Override
			public void accept(Turn turn) {
				aListTurn.add(turn.getId());
			}
		});
		return aListTurn;
	}

}
