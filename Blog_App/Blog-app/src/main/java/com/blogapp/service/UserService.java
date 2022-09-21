package com.blogapp.service;

import java.util.List;

import com.blogapp.payload.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto userDto);
	
	public List<UserDto> getAllUsers();
	
	public UserDto getUserByID(Integer userId);
	
	public UserDto createUser(UserDto user);
	
	public UserDto updateUser(UserDto user,Integer userId);
	
	public void deleteUser(Integer userId);
	
}
