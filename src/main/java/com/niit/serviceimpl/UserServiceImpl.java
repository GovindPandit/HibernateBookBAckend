package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.niit.dao.UserDAO;
import com.niit.daoimpl.UserDAOImpl;
import com.niit.model.User;
import com.niit.others.Email;
import com.niit.service.UserService;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	UserDAO userDAO;
	
	public boolean addUser(User user)
	{
		//performing validation
		user.setAuthority("user");
		user.setStatus(true);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDAO.addUser(user);
		Email email=new Email(user.getEmail(), "Spring Demo", "Welcome to the email api");
		email.sendEmail();
		//sending email
		return true;
	}

	public boolean deleteUser(int userid) 
	{
		userDAO.deleteUser(userid);
		return true;
	}

	public boolean updateUser(User user) 
	{
		userDAO.updateUser(user);
		return true;
	}

	public List<User> displayUsers() 
	{
		return userDAO.displayUsers();
	}

	public User displayUserByUsername(String username) 
	{
		return userDAO.displayUserByName(username);
	}
	
}
