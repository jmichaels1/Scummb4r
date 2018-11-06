package com.everis.bcn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * @author jsalirio
 *
 */
@Entity
@Table(name="booking")
public class Booking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookingId", unique = true, nullable = false)
	private int bookingId;
	
	@Column(name="localizador")
	private long localizador;
	
	@Column(name="personas")
	private int personas;
	
	@Column(name="day")
	@Temporal(TemporalType.DATE)
	private Date day;
	
	@ManyToOne
	@JoinColumn(name="mesaId", nullable = false)
	private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name = "restaurantId", nullable = false)
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "turnId", nullable = false)
	private Turn turn;
	
	/**
	 * Constructor without parameters
	 */
	public Booking() {
		super();
	}

	

	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public long getLocalizador() {
		return localizador;
	}

	public void setLocalizador(long localizador) {
		this.localizador = localizador;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingId != other.bookingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
//		final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-mm-yyyy");
//		return "Booking [id=" + bookingId + ", localizador=" + localizador + ", personas=" + personas + ", day=" + 
//				FORMAT.format(day) + ", mesa=" + mesa + ", restaurant=" + restaurant + ", turn=" + turn + "]";
		return "Booking [id=" + bookingId + ", localizador=" + localizador + ", personas=" + personas + ", day=" + 
		day + ", mesa=" + mesa + ", turn=" + turn + "]";
	}
	
	
	

	

}
