package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;

@RestController
public class Mycontroller 
{
	@Autowired
	RegistrationService service;
	
	@RequestMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200/")
	public User registerUser(@RequestBody User user) throws Exception
	{
		String tempUsername=user.getUsername();
		if(tempUsername!=null && !"".equals(tempUsername))
		{
			User userobj=service.FetchUserByUsername(tempUsername);
			if(userobj!=null)
			{
				throw new Exception("user with"+ tempUsername+ " is already exist");
			}
		}
		User userObj=null;
		userObj=service.saveUser(user);
	
		return userObj;
	}
	@RequestMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200/")
	public User login(@RequestBody User user) throws Exception
	{
		String tempUsername=user.getUsername();
		String password=user.getPassword();
		User userObj=null;
		if(tempUsername!=null &&password!=null)
		{
			userObj=service.FetchUserByUsernamepassword(tempUsername, password);
		}
		if(userObj==null)
		{
			throw new Exception("this user does not exist");
		}
		return userObj;
	}
}
