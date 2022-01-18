package com.pack;

import java.util.Iterator;
import java.util.List;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pack.HibernateUtil;
import com.pack.Customer;

public class CustomerDAO {
	
	public int insert(Customer customer)
	{
		 
			 
	 
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 		
 
		Transaction tx=null;
		tx=session.beginTransaction();
		
		int res=(int)session.save(customer); 
		tx.commit();
		System.out.println("Saved");
		
		session.close(); 
	 
		return res;
	}

	
	public Customer display(int customerId)
	{
		   Customer customer=null;
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 
		 String hql ="from Customer where customerId="+customerId;
		
			Query query = session.createQuery(hql);
	    //	  query.setParameter("custId",customerId);
	    	   	
	    	List<Customer> list=query.getResultList();
		 
		   for(Customer c:list)
		   {
			   customer=c;
		   }
		 return customer;
		
	     	    
		
	}
	
	
	public int deleteCustomer(int customerId)
	{
		
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 
		Transaction tx=null;
		tx=session.beginTransaction();
		 String hql ="delete from Customer where customerId=:custId";
		 Query query = session.createQuery(hql);
   	  query.setParameter("custId",customerId);
   	  int id=query.executeUpdate();
   	  tx.commit();
   	  session.close();
   	  return id;
   	  
   	  
	}
	
	public List<Customer> displayAll()
	{
		System.out.println("into");
		 String hql ="from Customer";
		  SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 
		  Query query = session.createQuery(hql);
		  
		List<Customer> customers=query.getResultList();
		   session.close();
		 return customers;
		 
		  	
		
		
		
	}
	

	public int updateCustomer(int customerId,String custName)
	{
		
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		  Session    session=factory.openSession(); 
		Transaction tx=null;
		tx=session.beginTransaction();
		 String hql ="update Customer set custName=:cust_name where customerId=:custId";
		 Query query = session.createQuery(hql);
   	  query.setParameter("custId",customerId);
   	  query.setParameter("cust_name",custName);
   	  int i=query.executeUpdate();
   	  tx.commit();
   	  session.close();
   	  return i;
   	  
   	  
	}
	
	}
	
	 

