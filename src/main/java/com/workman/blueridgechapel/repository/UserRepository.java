package com.workman.blueridgechapel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Reservation;
import com.workman.blueridgechapel.model.User;

/**
 * 
 * @author blwor
 * This is the UserRepository that extends the JpaRepository so we can 
 * perform CRUD operations on the User POJO
 * 
 * findByEmail(String email): This method will find the user associated by the email given and return a user object
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	 User findByEmail(String email);
	 
}
