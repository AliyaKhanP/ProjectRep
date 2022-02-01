package com.pack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.pack.model.User;
@Repository
public class UserDao implements IUserDao
{
	@Autowired
SessionFactory sessionFactory;

	
	public void addUser(User user) 
	{
		
		Session session= sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
	}

		
		
	

	

}
