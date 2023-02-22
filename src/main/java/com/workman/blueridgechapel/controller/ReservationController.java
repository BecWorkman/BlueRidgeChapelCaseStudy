package com.workman.blueridgechapel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Reservation;
import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.service.AmenitiesService;
import com.workman.blueridgechapel.service.PropertyService;
import com.workman.blueridgechapel.service.ReservationService;
import com.workman.blueridgechapel.service.TestimonialService;

/**
 * 
 * @author blwor
 *
 *This is the ReservationController used to define mappings and use methods defined in the service classes
 *
 *String bookNow(Reservation reservation): this method returns the book_now page along with taking in an object of reservation defined
 *on the form withing the page
 *
 *String save(Reservation reservation): this method adds the reservation specified on the form in the book_now page and saves it to the database
 *then redirects to the book now page with a success param displaying a success message
 *
 * ModelAndView deleteReservation(@PathVariable("id") Long id): sets the mapping path as /reservation/delete/{id}. it creates a model and view 
 * object directing to the admin_dashboard then deletes the entity associated with the id passed in from the url. then it will add objects of 
 * the testimonials amenities and reservations into the view and return it.
 * 
 *
 */

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@Autowired
	TestimonialService testimonialService;
	
	@Autowired
	PropertyService propertyService;
	
	@RequestMapping("/bookNow")
	public String bookNow(Reservation reservation) {
		return "book_now";
	}
	
	@RequestMapping("/reservation/save")
	public String save(Reservation reservation) {
		reservationService.addReservation(reservation);
		return "redirect:/bookNow?success";
	}
	
	@RequestMapping("/reservation/delete/{id}")
	public ModelAndView deleteReservation(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("admin_dashboard");
		reservationService.deleteReservation(id);
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		view.addObject("reservationList", reservationService.getAllReservations());
		view.addObject("propertyList", propertyService.getAllProperties());
		return view;
	}
	

}
