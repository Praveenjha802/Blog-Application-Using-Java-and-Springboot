package com.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.payload.ApiResponse;
import com.blogapp.payload.CommentDto;
import com.blogapp.service.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commentDto,
			@PathVariable Integer postId
			){

		return new ResponseEntity<CommentDto>(commentService.createComment(commentDto, postId),HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		commentService.deletComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment has been deleted",true),HttpStatus.OK);
	}
	
	
}
