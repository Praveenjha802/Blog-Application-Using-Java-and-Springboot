package com.blogapp.service;

import java.util.List;

import com.blogapp.Entity.Post;
import com.blogapp.payload.PostDto;
import com.blogapp.payload.PostResponse;

public interface PostService {

	//create
	
	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	// read 1 user
	
	PostDto getPostById(Integer postId);
	//read all post
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	// update post
	
	PostDto updatePost(PostDto postDto, Integer postId);
	// delete post
	
	void deletePost(Integer postId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> searchPosts(String title);
}
