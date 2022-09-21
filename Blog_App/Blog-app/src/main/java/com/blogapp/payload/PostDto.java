package com.blogapp.payload;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private String postId;
	
	private String postTitle;
	
	private String content;
	
	private Date addedDate;
	
	private UserDto user;
	
	private CategoryDto category;
	
	private String imageName;
	
	private Set<CommentDto> comments=new HashSet<>();
	
}
