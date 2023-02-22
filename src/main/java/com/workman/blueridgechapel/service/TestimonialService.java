package com.workman.blueridgechapel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.workman.blueridgechapel.model.Testimonial;
import com.workman.blueridgechapel.repository.TestimonialRepository;

/**
 * 
 * @author blwor
 * This is the TestimonialService class where we implement all our custom queries and other crud opperations.
 * 
 * TestimonialService(TestimonialRepository testimonialRepo): This method is setting and establishing a repository associated with this service
 * 
 * getTestimonialRepo(): This method is getting the set repository and returning it. 
 * 
 * setTestimonialRepo(TestimonialRepository testimonialRepo): This method is setting the TestimonialRepository 
 *
 * List<Testimonial> getAllTestimonials(): This method is creating a list of testimonials and finding all the testimonials in the database and 
 * adding each to the list then returning the list.
 * 
 * Testimonial getTestimonialById(Long id): This method takes in a long value and uses a JPA repository method to return the database
 * row associated with the id passed in.
 * 
 * addTestimonial(Testimonial newTestimonial) : This method takes in a testimonial object and uses the save method in the JPA repository to save the 
 * testimonial to the database.
 * 
 * updateTestimonial(Long id, Testimonial testimonial): This method takes in an id of long and a testimonial object of testimonial. Then the method
 * finds the current testimonial data the user is updating, checks to see if the testimonial data is there and if it is it creates and 
 * new _testimonial object and sets the values the user entered and saving them to the database.
 *
 * deleteTestimonial(Long id): This method takes in an id of long and used the JPA repository method deleteById to delete the associated row
 * in the database.
 */

@Service
public class TestimonialService {
	
	
	TestimonialRepository testimonialRepo;
	
	public TestimonialService(TestimonialRepository testimonialRepo) {
		this.testimonialRepo = testimonialRepo;
	}

	public TestimonialRepository getTestimonialRepo() {
		return testimonialRepo;
	}

	public void setTestimonialRepo(TestimonialRepository testimonialRepo) {
		this.testimonialRepo = testimonialRepo;
	}

	public List<Testimonial> getAllTestimonials(){
		List<Testimonial> testimonialList = new ArrayList<Testimonial>();
		testimonialRepo.findAll().forEach(testimonialList::add);
		return testimonialList;
	}
	
	public Testimonial getTestimonialById(Long id) {
		return testimonialRepo.getReferenceById(id);
	}
	
	public void addTestimonial(Testimonial newTestimonial) {
		 testimonialRepo.save(newTestimonial);
	}
	
	public void updateTestimonial(Long id, Testimonial testimonial) {
		Optional<Testimonial> testimonialData = testimonialRepo.findById(id);
		if(testimonialData.isPresent()) {
			Testimonial _testimonial = testimonialData.get();
			_testimonial.setTitle(testimonial.getTitle());
			_testimonial.setMessage(testimonial.getMessage());
			testimonialRepo.save(_testimonial);
		}
	}
	
	public void deleteTestimonial(Long id) {
		testimonialRepo.deleteById(id);
	}
	
}
