package com.workman.blueridgechapel.controller;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.service.AmenitiesService;
import com.workman.blueridgechapel.service.TestimonialService;
import com.workman.blueridgechapel.service.UserService;




/**
 * 
 * @author blwor
 * 
 * This is the HomeController used to define mappings and use methods defined in the service classes
 * 
 * HomeController(AmenitiesService aMENITIES_SERVICE, TestimonialService tESTIMONIAL_SERVICE, UserService uSER_SERVICE): This method is used
 * to manually autowire all the listed services to this controller.
 * 
 * String home(): mapping the index.html to the /home path. Logging the application has started.
 * 
 * ModelAndView about(): creating a new model and view to display the home page along with displaying a list of amenities at the B&B.
 * 
 * String contact(): mapping the contact.html to the /contact path.
 * 
 * String showRegistrationForm(Model model): mapping the register page to the /register path. And creating a new user object and model to 
 * use from the form values
 * 
 * 
 * String registration(User user, BindingResult result, Model model): Gets and sets the user information entered in from the form fields,
 * checks to see if the email is already registered and displays an error if it is. if not it checks to see if the fields have any errors
 * if not we create a new encrypted password using bcrypt and the user defined password and set it. Then we save the user and redirect
 * the user back to the register page
 * 
 */

@Controller
public class HomeController {
	
	
	private final AmenitiesService AMENITIES_SERVICE;
	private final TestimonialService TESTIMONIAL_SERVICE;
	private final UserService USER_SERVICE;
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);



	public HomeController(AmenitiesService aMENITIES_SERVICE, TestimonialService tESTIMONIAL_SERVICE, UserService uSER_SERVICE) {
		super();
		AMENITIES_SERVICE = aMENITIES_SERVICE;
		TESTIMONIAL_SERVICE = tESTIMONIAL_SERVICE;
		USER_SERVICE = uSER_SERVICE;
		
	}

	@RequestMapping("/home")
	public String home() {
		logger.info("The application has been started");
		return "index";
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView list = new ModelAndView("about");
		list.addObject("amenitiesList", AMENITIES_SERVICE.getAmenityByPropertyLocation(1));
		return list;
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	


	
	@RequestMapping("/register")
	public String showRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}

	
	@PostMapping("/register/save")
	public String registration(User user, BindingResult result, Model model) {
		User existingUser = USER_SERVICE.findUserByEmail(user.getEmail());

		if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email", null, "There is already an account registered with the same email");
			logger.error("User login error. User = null, User.getEmail != null, and User not empty");
		}

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			logger.error("User login error.");
			return "/register";
		}
		
		int strength = 10;
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());
        String encodedPassword = bcryptEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
		
		USER_SERVICE.saveUser(user);
		logger.info("Login successful");
		return "redirect:/register?success";
	}
	


}
