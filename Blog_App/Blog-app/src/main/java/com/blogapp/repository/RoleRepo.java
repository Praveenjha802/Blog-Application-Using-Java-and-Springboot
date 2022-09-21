package com.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.Entity.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
