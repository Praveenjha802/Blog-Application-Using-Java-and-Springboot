package com.blogapp.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blogapp.Entity.Role;
import com.blogapp.Entity.User;
import com.blogapp.configuration.AppConstants;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.UserDto;
import com.blogapp.repository.RoleRepo;
import com.blogapp.repository.UserRepo;
import com.blogapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public List<UserDto> getAllUsers() {
		List<User> list= userRepo.findAll();
		List<UserDto> userDto= new ArrayList<>();
		for(User user:list)
			userDto.add(userToDto(user));
			
		return userDto;
	}

	@Override
	public UserDto getUserByID(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return userToDto(user);
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = userDtoToUser(userDto);
		userRepo.save(user);
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userID) {
		User user=userRepo.findById(userID).orElseThrow(()->new ResourceNotFoundException("User","Id",userID));
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setId(userID);
		user.setPassword(userDto.getPassword());
		user.setUserName(userDto.getUserName());
		User user1=userRepo.save(user);
		
		return userToDto(user1);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		userRepo.delete(user);
	}
	private UserDto userToDto(User user) {
		UserDto userDto= new UserDto();
		
		modelMapper.map(user, userDto);
//		userDto.setAbout(user.getAbout());
//		userDto.setEmail(user.getEmail());
//		userDto.setId(user.getId());
//		userDto.setPassword(user.getPassword());
//		userDto.setUserName(user.getUserName());
		
		return userDto;
		
	}
	private User userDtoToUser(UserDto userDto) {
		User user= new User();
		modelMapper.map(userDto, user);
		
		return user;
		
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {

		User user=modelMapper.map(userDto, User.class);
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepo.findById(AppConstants.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser=userRepo.save(user);
		return modelMapper.map(newUser, UserDto.class);
	}

}
