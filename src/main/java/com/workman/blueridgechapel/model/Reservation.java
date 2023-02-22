package com.workman.blueridgechapel.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * 
 * @author Becky Workman
 * This POJO is used to facilitate reservation creation and 
 * getting reservation information.
 *
 */

@Entity
public class Reservation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int numberOfGuests;
	private String petStatus;
	private Long propertyLocation;

	public Reservation(){}

	public Reservation(String name, String email, LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests,
			String petStatus, Long propertyLocation) {
		super();
		this.name = name;
		this.email = email;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.petStatus = petStatus;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}

	public Long getPropertyLocation() {
		return propertyLocation;
	}

	public void setPropertyLocation(Long propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(checkInDate, checkOutDate, email, id, name, numberOfGuests, petStatus, propertyLocation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(checkInDate, other.checkInDate) && Objects.equals(checkOutDate, other.checkOutDate)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && numberOfGuests == other.numberOfGuests
				&& Objects.equals(petStatus, other.petStatus)
				&& Objects.equals(propertyLocation, other.propertyLocation);
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", name=" + name + ", email=" + email + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + ", numberOfGuests=" + numberOfGuests + ", petStatus=" + petStatus
				+ ", propertyLocation=" + propertyLocation + "]";
	}

	
	
}
