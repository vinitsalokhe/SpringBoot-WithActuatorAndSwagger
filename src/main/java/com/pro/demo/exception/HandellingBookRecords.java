package com.pro.demo.exception;

import java.awt.print.Book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Component
public class HandellingBookRecords extends ResponseEntityExceptionHandler{
 
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<Book> handelRecord(){
		return new ResponseEntity("Book record is not found in your database", HttpStatus.NOT_FOUND);
	}
}
