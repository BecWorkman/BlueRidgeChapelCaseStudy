package com.workman.blueridgechapel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Reservation;
import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.repository.AmenitiesRepository;
import com.workman.blueridgechapel.repository.UserRepository;


/**
 * 
 * @author blwor
 * This is the UserService class where we implement all our custom queries and other crud opperations.
 * 
 * UserService(UserRepository userRepo): This method is setting and establishing a repository associated with this service
 * 
 * getUserRepo(): This method is getting the set repository and returning it. 
 * 
 * setUserRepo(UserRepository userRepo): This method is setting the UserRepository 
 * 
 * findUserByEmail(String email): This method takes in a string value and uses a custom query findByEmail to return the database
 * row associated with the email passed in.
 * 
 * saveUser(User newUser): This method takes in a user object and uses the save method in the JPA repository to save the user to the database.
 *
 */

@Service
public class UserService {
	
	UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public void saveUser(User newUser) {
		userRepo.save(newUser);
		
	} 
}
