package com.workman.blueridgechapel.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate amenity creation and 
 * getting amenity information for each property location.
 *
 */

@Entity
public class Amenities implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Long propertyLocation;
	
	
	
	
	public Amenities() {}


	public Amenities(Long id, String name, String description, Long propertyLocation) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.propertyLocation = propertyLocation;
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

	public Long getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Long propertyLocation) {
		this.propertyLocation = propertyLocation;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, propertyLocation);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amenities other = (Amenities) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(propertyLocation, other.propertyLocation);
	}


	@Override
	public String toString() {
		return "Amenities [id=" + id + ", name=" + name + ", description=" + description + ", propertyLocation="
				+ propertyLocation + "]";
	}
}
