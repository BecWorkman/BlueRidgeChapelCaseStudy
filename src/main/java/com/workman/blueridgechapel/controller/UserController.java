package com.workman.blueridgechapel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.workman.blueridgechapel.model.User;
import com.workman.blueridgechapel.service.AmenitiesService;
import com.workman.blueridgechapel.service.PropertyService;
import com.workman.blueridgechapel.service.ReservationService;
import com.workman.blueridgechapel.service.TestimonialService;
import com.workman.blueridgechapel.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * 
 * @author blwor
 * 
 * This is the UserController used to define mappings and use methods defined in the service classes
 * 
 * String login(Model model, HttpSession session): this method starts a list of logged in users and begins the session it adds the model
 * attribute of user for the form in the login page and returns the login page
 * 
 * ModelAndView loginUser(User user, BindingResult result, HttpServletRequest request): this method starts a list of the logged in users with
 * the session defined in the login method. we define the entered user and the differnt views we want to display based on the uses input.
 * along with adding a bcrypt encoder object to encode the encrypted password when registered. if the user is equal to null we start a 
 * new list of users to be entered into the session. we check to see if the entered and if it sends you to the loginview. if not it checks to 
 * see if the encoded password entered matches password in the database, if it does then it checks to see what role the user has. if they 
 * are an admin it goes to the admin view, if they are a user it goes to a user view. before going to the view it also adds the entered user
 * into the list of users in the started session.
 * 
 * String logout(): this method ends the started session and returns the index page
 *
 */

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	AmenitiesService amenitiesService;

	@Autowired
	TestimonialService testimonialService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	PropertyService propertyService;
	
	@RequestMapping("/login")
	public String login(Model model, HttpSession session) {
		
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.getAttribute("Session_Users");
		
		if(users == null) {
			users = new ArrayList<>();
		}
		
		model.addAttribute("users", users);
		return "login";
	}

	@RequestMapping("/dashboard")
	public ModelAndView loginUser(User user, BindingResult result, HttpServletRequest request) {
		
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) request.getSession().getAttribute("Session_Users");
		
		User enteredUser = userService.findUserByEmail(user.getEmail());
		ModelAndView adminView = new ModelAndView("admin_dashboard");
		ModelAndView userView = new ModelAndView("user_dashboard");
		ModelAndView loginView = new ModelAndView("login");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(users == null) {
			users = new ArrayList<>();
			request.getSession().setAttribute("Session_Users", users);
		}
		
		try {
			if (enteredUser.getEmail() == null) {
				result.rejectValue("email", null, "Your login was invalid. Please try again");
				return loginView;
			} else if (encoder.matches(user.getPassword(), enteredUser.getPassword())) {
				if (enteredUser.getStatus().equals("admin")) {
					users.add(enteredUser);
					request.getSession().setAttribute("Session_Users", users);
					adminView.addObject("amenitiesList", amenitiesService.getAllAmenities());
					adminView.addObject("testimonialList", testimonialService.getAllTestimonials());
					adminView.addObject("reservationList", reservationService.getAllReservations());
					adminView.addObject("propertyList", propertyService.getAllProperties());
					return adminView;
				} else {
					users.add(enteredUser);
					request.getSession().setAttribute("Session_Users", users);
					return userView;
				}
			}
		} catch (NullPointerException e) {
			result.rejectValue("email", null, "Your login was invalid. Please try again");
			return loginView;

		}

		if (enteredUser.getStatus().equals("admin")) {
			users.add(enteredUser);
			request.getSession().setAttribute("Session_Users", users);
			adminView.addObject("amenitiesList", amenitiesService.getAllAmenities());
			adminView.addObject("testimonialList", testimonialService.getAllTestimonials());
			adminView.addObject("reservationList", reservationService.getAllReservations());
			adminView.addObject("propertyList", propertyService.getAllProperties());
			return adminView;
		} else {
			users.add(enteredUser);
			request.getSession().setAttribute("Session_Users", users);
			return userView;
		}

	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest session){
		session.getSession().invalidate();
		return "index";
	}

}
