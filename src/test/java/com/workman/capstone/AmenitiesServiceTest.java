package com.workman.capstone;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.service.AmenitiesService;

@SpringBootTest
public class AmenitiesServiceTest {
	
	@Autowired
	private AmenitiesService amenitiesService;
	
	@Test
	public void testGetAllAmenities() {
		List<Amenities> amenitiesList = amenitiesService.getAllAmenities();
		assertThat(amenitiesList.size() > 1);
	}

	@ParameterizedTest
	@CsvSource({"1"})
	public void testGetAmenitiesByPropertyLocation(int id) {
		List<Amenities> amenitiesList = amenitiesService.getAmenityByPropertyLocation(id);
		assertThat(amenitiesList.size() > 1);
	}
	
	
	

}
