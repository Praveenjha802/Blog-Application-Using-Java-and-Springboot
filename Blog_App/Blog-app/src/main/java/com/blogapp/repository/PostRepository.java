package com.blogapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.Entity.Category;
import com.blogapp.Entity.Post;
import com.blogapp.Entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByCategory(Category category);
	
	List<Post> findByUser(User user);
	
	List<Post> findByTitleContaining(String title);
	// same method written in custom
	//@Query("select p from Post p where p.title like :key") // %key%
	//List<Post> searchByTitle(String title);
}
