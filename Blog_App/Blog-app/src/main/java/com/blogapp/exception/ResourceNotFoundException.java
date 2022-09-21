package com.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	private long id;
	private String resourceName;
	private String fieldName;
	public ResourceNotFoundException(String resourceName, String fieldName,long id) {
		super(String.format("%s not found %s : %s",resourceName,fieldName,id));
		this.id = id;
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}

}
