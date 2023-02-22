package com.workman.capstone;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	public void testFindByEmail() {
		User user = userRepo.findByEmail("blworkman03@gmail.com");
		assertNotNull(user);
	}

}
