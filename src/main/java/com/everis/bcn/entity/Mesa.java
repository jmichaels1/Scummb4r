package com.everis.bcn.entity;

import java.io.Serializable;

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
@Table(name="mesa")
public class Mesa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "restaurant")
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
		this.id = id;
		this.capacity = capacity;
		this.restaurant = restaurant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		Mesa other = (Mesa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", capacity=" + capacity + ", restaurant=" + restaurant + "]";
	}
	
}
