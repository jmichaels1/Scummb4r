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
	@Column(name = "turnId", unique = true, nullable = false)
	private int turnId;
	
	@Column(name = "description")
	private String description;
	
	/**
	 * Constructor without parameters
	 */
	public Turn() {
	}
	
	/**
	 * Constructor with parameters
	 * @param id
	 * @param description
	 */
	public Turn(int turnId, String description) {
		super();
		this.turnId = turnId;
		this.description = description;
	}

	public int getTurnId() {
		return turnId;
	}

	public void setTurnId(int turnId) {
		this.turnId = turnId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**** sobreCarga *****/
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + turnId;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (turnId != other.turnId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turn [id=" + turnId + ", description=" + description + "]";
	}
	

}
