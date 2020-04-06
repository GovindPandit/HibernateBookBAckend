package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.AppConfig;
import com.niit.model.Book;
import com.niit.service.BookService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)

public class BookTest 
{
	@Autowired
	BookService bookService;
	
	@Test
	public void addBook()
	{
		Book book=new Book();
		book.setBookname("Harry Potter");
		book.setDescription("ABCD");
		book.setPrice(560f);
		
		
		assertEquals(true, bookService.addBook(book));
	}
	
}
