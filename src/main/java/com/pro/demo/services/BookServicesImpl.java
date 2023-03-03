package com.pro.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pro.demo.dao.BookDao;
import com.pro.demo.entity.Book;
import com.pro.demo.exception.BookNotFound;

@Service
public class BookServicesImpl implements BookServices{
	
	@Autowired
	BookDao bookdao;
	@Override
	public Book createBook(Book b) {
		return bookdao.save(b);
	}
	
	@Override
	public Book readBook(int id) {
		return bookdao.findById(id).orElseThrow(()-> new BookNotFound("Book with id number is : " + id + "not found", HttpStatus.CONFLICT));
	}
	
	@Override
	public Book editBookById(int id, Book b) {
	  Book b1 = bookdao.findById(id).get();
	  b1.setName(b.getName());
	  b1.setPrice(b.getPrice());
	  return bookdao.save(b1);
	}
	
	@Override
	public void removeBook(int id) {
		bookdao.deleteById(id);
	}
	
//	Book name which is starts from g 
	@Override
	public List<Book> getAllBook(){
		return bookdao.getAllBook();
	}
	
//	sort book on price
	@Override
	public List<Book> getAllBookWithOrderByPrice(){
		return bookdao.getAllBookWithOrderByPrice();
	}
	
//	sort book on name & also find count of name 
	@Override
	public List<Book> getAllBookWithNameCount(){
		return bookdao.getAllBookWithNameCount();
	}
	
	
	
}
