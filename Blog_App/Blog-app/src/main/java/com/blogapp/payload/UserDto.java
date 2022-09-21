package com.blogapp.payload;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min=3,max=20,message="UserName should be in the range of 3-20")
	private String userName;
	
	@Email(message="Enter proper email")
	private String email;
	
	@NotEmpty(message="password should be in the range of 3-20")
	@Size(min=4,max=20)
	private String password;
	
	@NotEmpty(message="about should not be empty")
	private String about;
	
	private Set<RoleDto> roles= new HashSet();
}
