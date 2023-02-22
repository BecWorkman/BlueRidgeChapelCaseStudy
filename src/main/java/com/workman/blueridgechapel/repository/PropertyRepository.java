package com.workman.blueridgechapel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.blueridgechapel.model.Property;

/**
 * 
 * @author blwor
 * This is the PropertyRepository that extends the JpaRepository so we can 
 * perform CRUD operations on the Property POJO
 *
 */

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	
	

}
