package com.blogapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.Entity.Category;
import com.blogapp.payload.ApiResponse;
import com.blogapp.payload.CategoryDto;
import com.blogapp.service.Impl.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl; 
	//create category
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<CategoryDto>(categoryServiceImpl.createCategory(categoryDto),HttpStatus.CREATED);
	}
	
	//get a category
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId) {
		return new ResponseEntity<CategoryDto>(categoryServiceImpl.getCatgoryById(categoryId),HttpStatus.ACCEPTED);
	}
	
	// get all category
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		return new  ResponseEntity<List<CategoryDto>>(categoryServiceImpl.getAllCategories(),HttpStatus.ACCEPTED);
	}
	
	//update category
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer categoryId,@RequestBody CategoryDto categoryDto) {
		return new ResponseEntity<CategoryDto> (categoryServiceImpl.updateCategory(categoryDto, categoryId),HttpStatus.ACCEPTED);
	}
	
	//delete category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId ) {
		 categoryServiceImpl.deleteCategory(categoryId);
		 return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true), HttpStatus.OK);
	}
}
