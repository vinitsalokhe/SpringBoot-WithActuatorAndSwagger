package com.pro.demo.controller;

import java.util.List;

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

import com.pro.demo.entity.Book;
import com.pro.demo.services.BookServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book-base")
public class BookController {

	@Autowired
	BookServices bookservices;
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book b){
		Book bl = bookservices.createBook(b);
		return new ResponseEntity<Book>(bl,HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Book> readBook(@PathVariable("id") int id){
		Book bk = bookservices.readBook(id);
		return new ResponseEntity<Book>(bk,HttpStatus.FOUND);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Book> editBookById(@Valid @PathVariable("id") int id, @RequestBody Book b){
		Book bk = bookservices.editBookById(id, b);
		return new ResponseEntity<Book>(bk,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeBook(@PathVariable("id") int id ){
		bookservices.removeBook(id);
		return ResponseEntity.ok("Book Record Are Delete Finaliy...");
	}
	
//	Book name which is starts from g 
	@GetMapping("/searchAllBookRecords")
	public List<Book> getAllBook(){
		return bookservices.getAllBook();
	}
	
//	sort book on price
	@GetMapping("/findAllBookWithPrice")
	public List<Book> getAllBookWithOrderByPrice(){
		return bookservices.getAllBookWithOrderByPrice();
	}
	
//	sort book on name & also find count of name 
	@GetMapping("/findAllBookWithCount")
	public List<Book> getAllBookWithNameCount(){
		return bookservices.getAllBookWithNameCount();
	}
	
	
}
