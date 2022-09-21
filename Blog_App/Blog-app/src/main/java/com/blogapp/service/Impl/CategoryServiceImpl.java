package com.blogapp.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.Entity.Category;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.CategoryDto;
import com.blogapp.repository.CategoryRepository;
import com.blogapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryDto> categories= new ArrayList<>();
		categoryRepo.findAll().forEach((category)->{
			CategoryDto categoryDto=modelMapper.map(category, CategoryDto.class);
			categories.add(categoryDto);
		});
		return categories;
	}

	@Override
	public CategoryDto getCatgoryById(Integer categoryId) {
		Category category=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		return modelMapper.map(category,CategoryDto.class);
	}

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category  category=modelMapper.map(categoryDto, Category.class);
		categoryRepo.save(category);
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category= categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryID",categoryId));
		modelMapper.map(categoryDto, category);
		categoryRepo.save(category);
		return modelMapper.map(category,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category= categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","CategoryID",categoryId));
		categoryRepo.delete(category);

	}

}
