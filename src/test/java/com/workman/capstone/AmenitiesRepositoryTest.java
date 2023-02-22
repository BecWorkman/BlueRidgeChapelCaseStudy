package com.workman.capstone;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.repository.AmenitiesRepository;

@SpringBootTest
public class AmenitiesRepositoryTest{
	
	@Autowired
	private AmenitiesRepository amenitiesRepo;
	
	@Test
	public void testGetByPropertyLocation() {
		List<Amenities> allAmenities = amenitiesRepo.getByPropertyLocation(1);
		assertNotNull(allAmenities);
	}
	
	@Test
	public void testGetById() {
		Amenities expected = amenitiesRepo.getById(2L);
		assertNotNull(expected);
		
	}

}
