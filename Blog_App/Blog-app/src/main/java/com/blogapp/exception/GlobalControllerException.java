package com.blogapp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogapp.payload.ApiResponse;

@RestControllerAdvice
public class GlobalControllerException {

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		return new ResponseEntity<ApiResponse>(new ApiResponse(ex.getMessage(),false),HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
	
		Map<String,String> resp= new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldErrror=((FieldError)error).getField();
		String message=error.getDefaultMessage();
		resp.put(fieldErrror, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}

}
