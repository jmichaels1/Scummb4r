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

import com.everis.bcn.daoImp.BookDAOImp;
import com.everis.bcn.daoImp.RestaurantDAOImp;
import com.everis.bcn.daoImp.TurnDAOImp;

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
	private Date day;
	
	@Column(name="mesa")
	private Mesa mesa;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Restaurant restaurant;
	
	@Column(name="turn")
	private Turn turn;
	
	/**
	 * Constructor without parameters
	 */
	public Booking() {
		super();
	}

	public int getId() {
		return bookingId;
	}

	public void setId(int id) {
		this.bookingId = id;
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

	public Date getDia() {
		return day;
	}

	public void setDia(Date dia) {
		this.day = dia;
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
		return "Booking [id=" + bookingId + ", localizador=" + localizador + ", personas=" + personas + ", day=" + day
				+ ", mesa=" + mesa + ", restaurant=" + restaurant + ", turn=" + turn + "]";
	}
	
	
	

	

}
