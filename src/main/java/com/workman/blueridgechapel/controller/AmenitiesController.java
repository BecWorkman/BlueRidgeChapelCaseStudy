package com.workman.blueridgechapel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Property;
import com.workman.blueridgechapel.service.AmenitiesService;
import com.workman.blueridgechapel.service.PropertyService;
import com.workman.blueridgechapel.service.ReservationService;
import com.workman.blueridgechapel.service.TestimonialService;



/**
 * 
 * @author blwor
 * 
 * This is the AmenitiesController used to define mappings and use methods defined in the service classes
 * 
 * ModelAndView updateAmenity(@PathVariable("id") Long id, Model model): sets the mapping path as /amenity/update{id}. Creates a model and 
 * view object returning the amenities_form. Creates an amenities object from the selected id in the path, checks to see if the amenity object
 * is null and returns an error if it is. Then updates the title of the page to update amenity adds the object to the form and returns the 
 * view.
 * 
 * ModelAndView add(Amenities amenity, Model model): sets the mapping path as /amenity/add creates a model and view object returning the 
 * amenities_form, creates an amenities object and adds a model attribute of title to set the title of the page 
 *
 * ModelAndView save(Amenities amenity, Property property): this method creates a model and view object directing the the admin_dashboard
 * then it checks to see if the amenity passed in has a id associated with it and if it does it will update the amenity using the update amenity
 * method or it will save/add it using the .save method from the JPA repository. it will also add objects of the testimonials amenities and 
 * reservations into the view as well
 * 
 * ModelAndView deleteAmenity(@PathVariable("id") Long id): sets the mapping path as /amenity/delete/{id}. it creates a model and view 
 * object directing to the admin_dashboard then deletes the entity associated with the id passed in from the url. then it will add objects of 
 * the testimonials amenities and reservations into the view and return it.
 * 
 * 
 *
 */

@Controller
public class AmenitiesController {
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@Autowired
	TestimonialService testimonialService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	PropertyService propertyService;
	
	@RequestMapping("/amenity/update/{id}")
	public ModelAndView updateAmenity(@PathVariable("id") Long id, Model model) {
		ModelAndView view = new ModelAndView("amenities_form");
		Amenities amentityObj = amenitiesService.getAmenityById(id);
		if(amentityObj == null) {
			throw new RuntimeException("Amenity with id" + id + "is not found");
		}
		model.addAttribute("title","Update Amenity");
		view.addObject("amenity", amentityObj);
		return view;
	}
	
	@RequestMapping("/amenity/add")
	public ModelAndView add(Amenities amenity, Model model) {
		ModelAndView view = new ModelAndView("amenities_form");
		view.addObject("amenity", new Amenities());
		model.addAttribute("title", "Add Amenity");
		return view;
	}
	
	@RequestMapping("/amenity/save")
	public ModelAndView save(Amenities amenity, Property property) {
		ModelAndView view = new ModelAndView("admin_dashboard");
		
		if(amenity.getId() != null) {
			amenitiesService.updateAmenity(amenity.getId(), amenity);
		}else {
			
			amenitiesService.addAmenity(amenity);
		}
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		view.addObject("reservationList", reservationService.getAllReservations());
		view.addObject("propertyList", propertyService.getAllProperties());

		return view;
	}
	
	@RequestMapping("/amenity/delete/{id}")
	public ModelAndView deleteAmenity(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("admin_dashboard");
		amenitiesService.deleteAmenity(id);
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		view.addObject("reservationList", reservationService.getAllReservations());
		view.addObject("propertyList", propertyService.getAllProperties());

		return view;
	}
	

}

