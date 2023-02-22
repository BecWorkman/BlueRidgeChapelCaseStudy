package com.workman.blueridgechapel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.blueridgechapel.model.Reservation;
import com.workman.blueridgechapel.model.Testimonial;
import com.workman.blueridgechapel.repository.ReservationRepository;

/**
 * 
 * @author blwor
 * This is the ReservationService class where we implement all our custom queries and other crud opperations.
 * 
 * ReservationService(ReservationRepository reservationRepo): This method is setting and establishing a repository associated with this service
 * 
 * getReservationRepo(): This method is getting the set repository and returning it. 
 * 
 * setReservationRepo(ReservationRepository reservationRepo): This method is setting the ReservationRepository 
 *
 * List<Reservation> getAllReservations(): This method is creating a list of properties and finding all the properties in the database and 
 * adding each to the list then returning the list.
 * 
 * Reservation getReservationById(Long id): This method takes in a long value and uses a JPA repository method to return the database
 * row associated with the id passed in.
 * 
 * addReservation(Reservation newReservation) : This method takes in a reservation object and uses the save method in the JPA repository to save the 
 * reservation to the database.
 * 
 * updateReservation(Long id, Reservation reservation): This method takes in an id of long and a reservation object of reservation. Then the method
 * finds the current reservation data the user is updating, checks to see if the reservation data is there and if it is it creates and 
 * new _reservation object and sets the values the user entered and saving them to the database.
 *
 * deleteReservation(Long id): This method takes in an id of long and used the JPA repository method deleteById to delete the associated row
 * in the database.
 */

@Service
public class ReservationService {
	
	
	ReservationRepository reservationRepo;
	
	public ReservationService(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	public ReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public void setReservationRepo(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}
	
	public List<Reservation> getAllReservations(){
		List<Reservation> reservationList = new ArrayList<Reservation>();
		reservationRepo.findAll().forEach(reservationList::add);
		return reservationList;
	}
	
	public Reservation getReservationById(Long id) {
		return reservationRepo.getReferenceById(id);
	}
	
	public void addReservation(Reservation newReservation) {
		 reservationRepo.save(newReservation);
	}
	
	public void updateReservation(Long id, Reservation reservation) {
		Optional<Reservation> reservationData = reservationRepo.findById(id);
		if(reservationData.isPresent()) {
			Reservation _reservation = reservationData.get();
			_reservation.setNumberOfGuests(reservation.getNumberOfGuests());
			_reservation.setCheckInDate(reservation.getCheckInDate());
			_reservation.setCheckOutDate(reservation.getCheckOutDate());
			_reservation.setPetStatus(reservation.getPetStatus());
			reservationRepo.save(_reservation);
		}
	}
	
	public void deleteReservation(Long id) {
		reservationRepo.deleteById(id);
	}
	

}
