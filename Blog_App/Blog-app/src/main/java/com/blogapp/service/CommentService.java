package com.blogapp.service;

import com.blogapp.payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto comment,Integer postId);
	
	void deletComment(Integer commentId);
}
