package com.workman.blueridgechapel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.blueridgechapel.model.Amenities;

/**
 * 
 * @author blwor
 * This is the AmenitiesRepository that extends the JpaRepository so we can 
 * perform CRUD operations on the Amenities POJO
 * 
 * getById Method: This method will get an amenities object by its id and return an amenities object
 * getByPropertyLocation Method: This method will get a list of amenities by an associated property location. 
 * Which will return a list of amenities
 *
 */

@Repository
public interface AmenitiesRepository extends JpaRepository<Amenities, Long>{
	
	public Amenities getById(Long id);
	
	public List<Amenities> getByPropertyLocation(int propertyLocation);
	
}
