package com.everis.bcn.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author jsalirio
 *
 */
@Entity
@Table(name="mesa")
public class Mesa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mesaId", unique = true, nullable = false)
	private int mesaId;
	
	@Column(name = "capacity")
	private int capacity;
	
	@ManyToOne
	@JoinColumn(name = "restaurantId", nullable = false)
	private Restaurant restaurant;
	
	/**
	 * Constructor without parameters
	 */
	public Mesa() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 * @param id
	 * @param capacity
	 * @param restaurant
	 */
	public Mesa(int id, int capacity, Restaurant restaurant) {
		super();
		this.mesaId = id;
		this.capacity = capacity;
		this.restaurant = restaurant;
	}

	public int getId() {
		return mesaId;
	}

	public void setId(int id) {
		this.mesaId = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mesaId;
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
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
		Mesa other = (Mesa) obj;
		if (mesaId != other.mesaId)
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + mesaId + ", capacity=" + capacity + "]";
	}
	
}
