package com.pro.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pro.demo.entity.Book;
@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

//	Book name which is starts from g 
	@Query(value = "select * from book WHERE name like 'g%' ", nativeQuery = true)
	public List<Book> getAllBook();
	
//	sort book on price
	@Query(value = "select * from book ORDER BY price ",nativeQuery = true)
	public List<Book> getAllBookWithOrderByPrice();
	
//	sort book on name & also find count of name 
	@Query(value = "select * from book ORDER BY name ",countQuery = "select count(*) from book",nativeQuery = true)
	public List<Book> getAllBookWithNameCount();
	
	
}
