package com.workman.blueridgechapel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workman.blueridgechapel.model.Testimonial;
import com.workman.blueridgechapel.service.AmenitiesService;
import com.workman.blueridgechapel.service.PropertyService;
import com.workman.blueridgechapel.service.ReservationService;
import com.workman.blueridgechapel.service.TestimonialService;

/**
 * 
 * @author blwor
 *
 *This is the TestimonialController used to define mappings and use methods defined in the service classes
 *
 *String bookNow(Reservation reservation): this method returns the book_now page along with taking in an object of reservation defined
 *on the form withing the page
 *
 * ModelAndView createTestimonial(Testimonial testimonial):this method returns a model and veiw object that redirects to the testimonials page
 * then it uses the add testimonial method to add the testimonial to the database then return the view
 *
 * ModelAndView deleteTestimonial(@PathVariable("id") Long id): sets the mapping path as /testimonial/delete/{id}. it creates a model and view 
 * object directing to the admin_dashboard then deletes the entity associated with the id passed in from the url. then it will add objects of 
 * the testimonials amenities and reservations into the view and return it.
 * 
 *
 */

@Controller
public class TestimonialController {
		
	@Autowired
	TestimonialService testimonialService;
	
	@Autowired
	AmenitiesService amenitiesService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/testimonials")
	public ModelAndView getAllTestimonials() {
		ModelAndView list = new ModelAndView("testimonials");
		list.addObject("testimonialList", testimonialService.getAllTestimonials());
		return list;
	}
	
	@RequestMapping("/testimonials/add")
	public ModelAndView createTestimonial(Testimonial testimonial) {
		ModelAndView newTestimonial = new ModelAndView("testimonials");
		testimonialService.addTestimonial(testimonial);
		newTestimonial.addObject("testimonialList", testimonialService.getAllTestimonials());
		return newTestimonial;
	}
	
	@RequestMapping("/testimonial/delete/{id}")
	public ModelAndView deleteTestimonial(@PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("admin_dashboard");
		testimonialService.deleteTestimonial(id);
		view.addObject("amenitiesList", amenitiesService.getAllAmenities());
		view.addObject("testimonialList", testimonialService.getAllTestimonials());
		view.addObject("reservationList", reservationService.getAllReservations());
		view.addObject("propertyList", propertyService.getAllProperties());
		return view;
	}

}






