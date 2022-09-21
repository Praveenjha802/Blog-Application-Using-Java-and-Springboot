package com.blogapp.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.blogapp.Entity.User;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.repository.UserRepo;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) {

		User user=userRepo.findByUserName(username).orElseThrow(()-> new ResourceNotFoundException("User","UserName"+username,0));
		//System.out.println(user.getPassword());
		return user;
	}
	

}
