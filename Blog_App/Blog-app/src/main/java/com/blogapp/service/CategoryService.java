package com.blogapp.service;

import java.util.List;

import com.blogapp.payload.CategoryDto;

public interface CategoryService {

	public List<CategoryDto> getAllCategories();
	
	public CategoryDto getCatgoryById(Integer categoryId);
	
	public CategoryDto createCategory(CategoryDto categoryDto );
	
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
   
    void deleteCategory(Integer categoryId);
	
}
