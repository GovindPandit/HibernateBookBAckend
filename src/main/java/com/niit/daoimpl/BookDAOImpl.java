package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.BookDAO;
import com.niit.model.Book;

@Repository("bookDAO")
@Transactional
public class BookDAOImpl implements BookDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addBook(Book book) 
	{
		sessionFactory.getCurrentSession().save(book);
		return true;
	}

	public boolean deleteBook(int bookid) 
	{
		Book b=new Book();
		b.setBookid(bookid);
		
		sessionFactory.getCurrentSession().delete(b);
		return true;
	}

	public boolean updateBook(Book book) 
	{
		sessionFactory.getCurrentSession().update(book);
		return true;
	}

	public List<Book> displayBooks() 
	{
		return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Book").list();
	}

	public Book displayByBookId(int bookid) 
	{
		Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Book where bookid = :bookid");
		query.setParameter("bookid", bookid);
		return (Book)query.getResultList().get(0);
	}
	
}
