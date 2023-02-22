package com.workman.blueridgechapel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.blueridgechapel.model.Reservation;

/**
 * 
 * @author blwor
 * This is the ReservationRepository that extends the JpaRepository so we can 
 * perform CRUD operations on the Reservation POJO
 *
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	

}
