package com.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dto.Admin;

public class AdminDaoImpl implements AdminDAO
{
private SessionFactory factory;
	
	public AdminDaoImpl() 
	{
		System.out.println("Config about to load");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
		System.out.println("Config loaded");
	}
	
		
	@Override
	public String addAdmin(Admin admin) {
		String administrator = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		administrator = (String) session.save(admin);
		txn.commit();
		session.close();
		return administrator;
	}	
	
	
	@Override
	public void updateAdmin(String admin, String pass) 
	{
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		Admin administrator = session.get(Admin.class, admin);
		administrator.setPass(pass);
		session.update(administrator);
		txn.commit();
		session.close();
	}	
	
	@Override
	public void deleteAdmin(String admin) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Admin administrator = session.get(Admin.class, admin);
		session.delete(admin);
		txn.commit();
		session.close();
	}	
	
	@Override
	public Admin searchAdminByUser(String admin) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "SELECT ad.user, ad.pass FROM administrators ad "+"WHERE ad.user="+admin;
		TypedQuery<Admin> query = session.createQuery(hql);
		Admin administrator = query.getSingleResult();
		return administrator;
	}
}
