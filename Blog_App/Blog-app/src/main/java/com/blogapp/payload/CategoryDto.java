package com.blogapp.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private int categoryId;
	@NotEmpty
	@Size(min=3,max=20,message="CategoryName should be in the range of 3-20")
	private String categoryTitle;
	
	@NotEmpty(message="about should not be empty")
	private String categoryDescription;
}
