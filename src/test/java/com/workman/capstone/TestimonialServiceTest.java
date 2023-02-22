package com.workman.capstone;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.Testimonial;
import com.workman.blueridgechapel.service.TestimonialService;

@SpringBootTest
public class TestimonialServiceTest {
	
	@Autowired
	private TestimonialService testimonialService;
	
	@Test
	public void testAddTestimonial() {
		Testimonial testimonial = new Testimonial();
		testimonial.setId((long) 1);
		testimonial.setName("Becky Workman");
		testimonial.setTitle("Absolutley Beautiful");
		testimonial.setMessage("Fantastic place! I cant wait to plan my next vacation!");
		testimonial.setRating(5);
		testimonialService.addTestimonial(testimonial);
		
		Testimonial actual = testimonialService.getTestimonialById(1L);
		assertNotNull(actual);
	}

}
