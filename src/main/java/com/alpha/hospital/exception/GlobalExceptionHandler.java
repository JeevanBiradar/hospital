package com.alpha.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.hospital.ResponseStructure;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(DoctorNotFoundException.class)
	    public ResponseEntity<ResponseStructure<String>> handleStudentNotFound(DoctorNotFoundException ex) {

	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStatusCode(HttpStatus.NOT_FOUND.value());
	        rs.setMessage(ex.getMessage());
	        rs.setData(null);

	        return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
	    }

}
