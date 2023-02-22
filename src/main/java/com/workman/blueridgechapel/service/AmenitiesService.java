package com.workman.blueridgechapel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Property;
import com.workman.blueridgechapel.model.Testimonial;
import com.workman.blueridgechapel.repository.AmenitiesRepository;
import com.workman.blueridgechapel.repository.PropertyRepository;

/**
 * 
 * @author blwor
 * This is the AmenitiesService class where we implement all our custom queries and other crud opperations.
 * 
 * AmenitiesService(AmenitiesRepository amenitiesRepo): This method is setting and establishing a repository associated with this service
 * 
 * getAmenitiesRepo(): This method is getting the set repository and returning it. 
 * 
 * setAmenitiesRepo(AmenitiesRepository amenitiesRepo): This method is setting the AmenitiesRepository 
 *
 * List<Amenities> getAllAmenities(): This method is creating a list of amenities and finding all the amenities in the database and adding 
 * each to the list then returning the list.
 * 
 * Amenities getAmenityById(Long id): This method takes in a long value and uses a custom query getById(id) to return the database
 * row associated with the id passed in.
 * 
 * List<Amenities> getAmenityByPropertyLocation(int property): This method is creating a list of amenities and using a custom query
 * getByPropertyLocation(property) and finding all the amenities with the specified property id. Then each of these amenities are added
 * to the list that then gets returned.
 * 
 * addAmenity(Amenities newAmenity) : This method takes in a amenities object and uses the save method in the JPA repository to save the 
 * amenity to the database.
 * 
 * updateAmenity(Long id, Amenities amenity): This method takes in an id of long and an amenities object of amenity. Then the method
 * finds the current amenity data the user is updating, checks to see if the amenity data is there and if it is it creates and new _amenity
 * object and sets the values the user entered and saving them to the database.
 *
 * deleteAmenity(Long id): This method takes in an id of long and used the JPA repository method deleteById to delete the associated row
 * in the database.
 */

@Service
public class AmenitiesService {
	
	
	AmenitiesRepository amenitiesRepo;
	PropertyRepository propertyRepo;
	
	
	public AmenitiesService(AmenitiesRepository amenitiesRepo) {
		this.amenitiesRepo = amenitiesRepo;
	}

	public AmenitiesRepository getAmenitiesRepo() {
		return amenitiesRepo;
	}

	public void setAmenitiesRepo(AmenitiesRepository amenitiesRepo) {
		this.amenitiesRepo = amenitiesRepo;
	}
	
	public List<Amenities> getAllAmenities(){
		List<Amenities> amenitiesList = new ArrayList<Amenities>();
		amenitiesRepo.findAll().forEach(amenitiesList::add);
		return amenitiesList;
	}
	
	public Amenities getAmenityById(Long id){
		return amenitiesRepo.getById(id);
	}
	
	public List<Amenities> getAmenityByPropertyLocation(int property) {
		List<Amenities> amenitiesList = new ArrayList<Amenities>();
		amenitiesRepo.getByPropertyLocation(property).forEach(amenitiesList::add);
		return amenitiesList;
	}
	
	public void addAmenity(Amenities newAmenity) {
		amenitiesRepo.save(newAmenity);
	}
	
	public void updateAmenity(Long id, Amenities amenity) {
		Optional<Amenities> amenityData = amenitiesRepo.findById(id);
		if(amenityData.isPresent()) {
			Amenities _amenity = amenityData.get();
			_amenity.setName(amenity.getName());
			_amenity.setDescription(amenity.getDescription());
			_amenity.setPropertyLocation(amenity.getPropertyLocation());
			amenitiesRepo.save(amenity);
		}
	}
	
	public void deleteAmenity(Long id) {
		amenitiesRepo.deleteById(id);
	}

}
