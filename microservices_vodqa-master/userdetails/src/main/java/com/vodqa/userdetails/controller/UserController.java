package com.vodqa.userdetails.controller;

import com.vodqa.userdetails.entities.LoginDetails;
import com.vodqa.userdetails.entities.User;
import com.vodqa.userdetails.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public Boolean register(@RequestBody User user) {
		try {
			LOGGER.info("Inside register()" + user);
			userRepository.save(user);
			return true;
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		    LOGGER.info(e.getMessage());
            return false;
		}

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody LoginDetails loginDetails) {
		User user = userRepository.findByEmail(loginDetails.getEmail());
		LOGGER.info("Inside login() and the email is: " + loginDetails.getEmail());
		if (user == null) {
			return "Login Failed ! Email Doesn't Exist";
		}
		else if (user.getPassword().equals(loginDetails.getPassword()))
		{
			return "Login Sucessfully";
		}
		else
		{
			return "Login Failed";
		}

	}

	@GetMapping("/health")
	public String healthCheck()
	{
		return "ok";
	}



}


