package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BookDAO;
import com.niit.model.Book;
import com.niit.service.BookService;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	BookDAO bookDAO;
	
	public boolean addBook(Book book) 
	{
		bookDAO.addBook(book);
		return true;
	}

	public boolean deleteBook(int bookid) 
	{
		bookDAO.deleteBook(bookid);
		return true;
	}

	public boolean updateBook(Book book) 
	{
		bookDAO.updateBook(book);
		return true;
	}

	public List<Book> displayBooks()
	{
		return bookDAO.displayBooks();
	}

	public Book displayByBookId(int bookid) {
		return bookDAO.displayByBookId(bookid);
	}

}
