package com.pro.demo.services;

import java.util.List;

import com.pro.demo.entity.Book;

public interface BookServices {

	Book createBook(Book b);

	Book readBook(int id);

	Book editBookById(int id, Book b);

	void removeBook(int id);

//	Book name which is starts from g 
	List<Book> getAllBook();
	
//	sort book on price
	List<Book> getAllBookWithOrderByPrice();

//	sort book on name & also find count of name 
	List<Book> getAllBookWithNameCount();





}
