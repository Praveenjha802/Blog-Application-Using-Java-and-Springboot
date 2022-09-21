package com.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapp.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
