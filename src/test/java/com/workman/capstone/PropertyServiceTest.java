package com.workman.capstone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.Amenities;
import com.workman.blueridgechapel.model.Property;
import com.workman.blueridgechapel.service.PropertyService;

@SpringBootTest
public class PropertyServiceTest {
	
	@Autowired
	private PropertyService propertyService;
	
	@Test
	public void testGetAllProperties() {
		Property property = new Property();
		property.setId(1L);
		property.setName("The Blue Ridge Chapel");
		property.setAddress("123 Address Ln City PA 16059");

		List<Property> expectedList = new ArrayList<>();
		expectedList.add(property);
		
		List<Property> actualList = propertyService.getAllProperties();
		assertEquals(expectedList, actualList);
	}

}
