package com.pro.demo.exception;

import org.springframework.http.HttpStatus;

public class BookNotFound extends RuntimeException {
	
	String ms;
	public BookNotFound(String ms, HttpStatus notFound) {
		super(ms);
		this.ms = ms;
	}

}
