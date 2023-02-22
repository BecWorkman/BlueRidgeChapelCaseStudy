package com.workman.blueridgechapel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Property;
import com.workman.blueridgechapel.repository.PropertyRepository;

/**
 * 
 * @author blwor
 * This is the PropertyService class where we implement all our custom queries and other crud opperations.
 * 
 * PropertyService(PropertyRepository propertyRepo): This method is setting and establishing a repository associated with this service
 * 
 * getProperyRepo(): This method is getting the set repository and returning it. 
 * 
 * setProperyRepo(PropertyRepository propertyRepo): This method is setting the PropertyRepository 
 *
 * List<Property> getAllProperties(): This method is creating a list of properties and finding all the properties in the database and 
 * adding each to the list then returning the list.
 * 
 * Property getPropertyById(Long id): This method takes in a long value and uses a JPA repository method to return the database
 * row associated with the id passed in.
 * 
 * addProperty(Property newproperty) : This method takes in a property object and uses the save method in the JPA repository to save the 
 * property to the database.
 * 
 * updateProperty(Long id, Property property): This method takes in an id of long and a property object of property. Then the method
 * finds the current property data the user is updating, checks to see if the property data is there and if it is it creates and 
 * new _property object and sets the values the user entered and saving them to the database.
 *
 * deleteProperty(Long id): This method takes in an id of long and used the JPA repository method deleteById to delete the associated row
 * in the database.
 */

@Service
public class PropertyService {
	
	PropertyRepository propertyRepo;
	
	public PropertyService(PropertyRepository propertyRepo) {
		this.propertyRepo = propertyRepo;
	}

	public PropertyRepository getPropertyRepo() {
		return propertyRepo;
	}

	public void setPropertyRepo(PropertyRepository propertyRepo) {
		this.propertyRepo = propertyRepo;
	}
	
	public List<Property> getAllProperties(){
		List<Property> propertyList = new ArrayList<Property>();
		propertyRepo.findAll().forEach(propertyList::add);
		return propertyList;
	}
	
	public Property getPropertyById(Long id){
		return propertyRepo.getReferenceById(id);
	}
	
	public void addProperty(Property newproperty) {
		propertyRepo.save(newproperty);
	} 
	

	
	public void updateProperty(Long id, Property property) {
		Optional<Property> propertyData = propertyRepo.findById(id);
		if(propertyData.isPresent()) {
			Property _property = propertyData.get();
			_property.setName(property.getName());
			_property.setAddress(property.getAddress());
			propertyRepo.save(_property);
		}
	}
	public void deleteProperty(Long id) {
		propertyRepo.deleteById(id);
	}

}
