package com.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.UserDao;
import com.pack.model.User;
@Service
public class UserService implements IUserInterface
{
	@Autowired
UserDao userdao;

	
	public void addUser(User user) {
		userdao.addUser(user);
		
	}

	
	
	

}
