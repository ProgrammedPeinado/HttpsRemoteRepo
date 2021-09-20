package com.client;


import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.beans.Student;
import com.util.HibernateUtil;

public class Client
{
	public static void main(String[] args)
	{
		//--Fixed steps for any operation
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//--Fixed steps for any operation
		
		Student student1 = new Student("Ramlal", "Verma", 9);
		session.save(student1);
		transaction.commit();
		factory.close();
		
	}
}
