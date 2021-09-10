package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepo;
import com.example.demo.model.User;

@Service
public class RegistrationService 
{
	
	@Autowired
	UserRepo urepo;
	
	
	public User saveUser(User user)
	{
		return urepo.save(user);
	}
	public User FetchUserByUsername(String username)
	{
		return urepo.findByUsername(username);
	}
	
	public User FetchUserByUsernamepassword(String username,String password)
	{
		return urepo.findByUsernameAndPassword(username, password);
	}
}
