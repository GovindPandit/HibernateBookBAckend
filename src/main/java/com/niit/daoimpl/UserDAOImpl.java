package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository(value = "userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user) 
	{
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public boolean deleteUser(int userid) 
	{
		User u=new User();
		u.setUserid(userid);
		
		sessionFactory.getCurrentSession().delete(u);
		return true;
	}

	public boolean updateUser(User user) 
	{
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public List<User> displayUsers() 
	{
		return sessionFactory.getCurrentSession().createQuery("from com.niit.model.User").getResultList();
	}

	public User displayUserByName(String username) 
	{
		Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where username= :username");
		query.setParameter("username", username);
		return (User)query.getResultList().get(0);
	}

}
