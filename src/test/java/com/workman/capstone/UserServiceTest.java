package com.workman.capstone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.repository.UserRepository;
import com.workman.blueridgechapel.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
		
	@Test
	public void testFindByEmail() {	
		
		User expected = new User();
		expected.setId((long) 1);
		expected.setName("Becky Workman");
		expected.setEmail("blw@gmail.com");
		expected.setPassword("123");
		expected.setStatus("Admin");
		User actual = userService.findUserByEmail("blw@gmail.com");
		assertEquals(expected.getEmail(),actual.getEmail());

	}

}
