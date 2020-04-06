package com.niit.dao;

import java.util.List;

import com.niit.model.Book;

public interface BookDAO 
{
	public boolean addBook(Book book);
	public boolean deleteBook(int bookid);
	public boolean updateBook(Book book);
	public List<Book> displayBooks();
	public Book displayByBookId(int bookid);
}
