package com.blogapp.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.Entity.Comment;
import com.blogapp.Entity.Post;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.CommentDto;
import com.blogapp.repository.CommentRepository;
import com.blogapp.repository.PostRepository;
import com.blogapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	PostRepository postRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post=postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
		Comment comment=modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		commentRepo.save(comment);
		return modelMapper.map(comment, CommentDto.class);
	}

	@Override
	public void deletComment(Integer commentId) {

		Comment comment=commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","CommentId",commentId));
		commentRepo.delete(comment);
	}

}
