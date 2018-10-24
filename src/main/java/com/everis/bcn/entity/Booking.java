package com.everis.bcn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name="localizador")
	private int localizador;
	
	@Column(name="personas")
	private int personas;
	
	@Column(name="day")
	private Date day;
	
	@Column(name="mesa")
	private Mesa mesa;
	
	@Column(name="restaurant")
	private Restaurant restaurant;
	
	@Column(name="turn")
	private Turn turn;
	
	/**
	 * Constructor without parameters
	 */
	public Booking() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 */
	public Booking(int id, int localizador, int personas, Date day) {
		super();
		this.id = id;
		this.localizador = localizador;
		this.personas = personas;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocalizador() {
		return localizador;
	}

	public void setLocalizador(int localizador) {
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
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", localizador=" + localizador + ", personas=" + personas + ", dia=" + day + "]";
	}
	
	

}
