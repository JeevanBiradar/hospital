package com.alpha.hospital.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	 
	 
	 @ExceptionHandler(DuplicateDoctorException.class)
	    public ResponseStructure<String> handleDuplicateDoctor(DuplicateDoctorException ex) {

	        ResponseStructure<String> rs = new ResponseStructure<>();
	        rs.setStatusCode(HttpStatus.CONFLICT.value());
	        rs.setMessage(ex.getMessage());
	        rs.setData(null);

	        return rs;
	    }
	 
	 
	 @ExceptionHandler(DataIntegrityViolationException.class)
	   public ResponseStructure<String> handleDataIntegrity(DataIntegrityViolationException ex)
	   {
		   ResponseStructure<String> rs = new ResponseStructure<>();
		    rs.setStatusCode(HttpStatus.CONFLICT.value());
		    rs.setMessage("Duplicate ID or foreign key violation");
		    rs.setData(ex.getMostSpecificCause().getMessage());
		    return rs;
	   }
	 
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseStructure<Map<String, String>> handleMethodArgNotValid(MethodArgumentNotValidException ex)
	 {
		 Map<String, String> errormap = new HashMap<String, String>();
		 
		 List<ObjectError> objerror = ex.getAllErrors();
		 
		 for(ObjectError objectError : objerror)
		 {
			 System.out.println(objectError.getDefaultMessage());
			 
			 FieldError fr = (FieldError) objectError;
			 System.err.println(fr.getField());
			 
			 errormap.put(fr.getField(), objectError.getDefaultMessage());
		 }
		 
		 ResponseStructure<Map<String,String>> rs = new ResponseStructure<Map<String,String>>();
		 
		 rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		 rs.setMessage("validation Failed");
		 rs.setData(errormap);
		 
		 return rs;
	 }

	 
	  
}
