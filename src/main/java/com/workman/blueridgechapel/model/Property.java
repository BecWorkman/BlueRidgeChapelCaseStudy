package com.workman.blueridgechapel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate property creation and 
 * getting property information for each property location.
 *
 */
@Entity
public class Property implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	
	@ManyToMany(targetEntity = Amenities.class)
	private Set<Amenities> propertyAmenities;
	
	
	public Property() {}

	public Property(Long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(address, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
