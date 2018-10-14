package com.everis.bcn.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * @author jsalirio
 *
 */
@Entity
@Table(name="restaurant")
public class Restaurant implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "address", length = 100)
	private String address;
	
	@Column(name = "description", length = 500)
	private String description;
	
	@OneToMany(mappedBy = "aListMesa", fetch=FetchType.EAGER)
	private ArrayList<Mesa> aListMesa;
	
	//TODO lista de reservas?
	
	/**
	 * Constructor without parameters
	 */
	public Restaurant() {
	}
	
	/**
	 * Contructor with parameter
	 * @param id
	 * @param name
	 * @param address
	 * @param description
	 */
	public Restaurant(int id, String name, String address, String description) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
	}
	
	
	/**** Metodos ******/


	@Transient
	public Integer getTotalPlazas() {
		//TODO implementar
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		Restaurant other = (Restaurant) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description
				+ ", getTotalPlazas()=" + getTotalPlazas() + "]";
	}
	

}
