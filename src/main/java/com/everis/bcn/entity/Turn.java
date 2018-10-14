/**
 * 
 */
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
@Table(name="turn")
public class Turn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "description")
	private int description;
	
	/**
	 * Constructor without parameters
	 */
	public Turn() {
		super();
	}
	
	/**
	 * Constructor with parameters
	 * @param id
	 * @param description
	 */
	public Turn(int id, int description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + description;
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
		Turn other = (Turn) obj;
		if (description != other.description)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turn [id=" + id + ", description=" + description + "]";
	}
	

}
