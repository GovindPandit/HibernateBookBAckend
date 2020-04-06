package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.config.AppConfig;
import com.niit.model.User;
import com.niit.service.UserService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)
public class UserTest 
{
	@Autowired
	UserService userService;
	
	@Test
	public void addUser()
	{
		User u=new User();
		u.setUsername("sagar123");
		assertEquals(true, userService.addUser(u)); 
	}
}
