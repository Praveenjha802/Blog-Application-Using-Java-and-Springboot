package com.blogapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.payload.ApiResponse;
import com.blogapp.payload.UserDto;
import com.blogapp.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	// create user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUSer=userServiceImpl.createUser(userDto);
		
		return new ResponseEntity<>(createdUSer,HttpStatus.CREATED);
	}
	
	// update user
	
	@PutMapping("/{userID}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable Integer userID){
		UserDto updatedUSer=userServiceImpl.updateUser(userDto,userID);
		return new ResponseEntity<>(updatedUSer,HttpStatus.OK);
	}
	
	//delete user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		userServiceImpl.deleteUser(userId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
	}
	
	//Get Single user
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
		UserDto userDto=userServiceImpl.getUserByID(userId);
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
	}
	//Get all users
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> users=userServiceImpl.getAllUsers();
		
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
}
