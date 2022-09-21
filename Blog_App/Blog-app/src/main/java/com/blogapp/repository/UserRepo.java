package com.blogapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
}
