package com.workman.blueridgechapel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.blueridgechapel.model.Testimonial;

/**
 * 
 * @author blwor
 * This is the TestimonialRepository that extends the JpaRepository so we can 
 * perform CRUD operations on the Testimonial POJO
 *
 */

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long>{

}
