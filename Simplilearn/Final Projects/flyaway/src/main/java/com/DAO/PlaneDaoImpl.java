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
import org.hibernate.query.Query;

import com.dto.Passenger;
import com.dto.Plane;

public class PlaneDaoImpl implements PlaneDAO
{
private SessionFactory factory;
	
	public PlaneDaoImpl() 
	{
		System.out.println("Config about to load");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
		System.out.println("Config loaded");
	}
	
		
	@Override
	public Integer addPlane(Plane plane) {
		Integer plane_id = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		plane_id = (Integer) session.save(plane);
		txn.commit();
		session.close();
		return plane_id;
	}	
	
	
	@Override
	public void updatePlane(String airline, Integer flightID) 
	{
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Plane plane = session.get(Plane.class, airline);
		System.out.println(plane);
		plane.setFlight_id(flightID);
		System.out.println(plane);
		
		session.update(plane);
		txn.commit();
		session.close();
	}	
	
	@Override
	public void deletePlane(Integer planeID) 
	{
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Plane plane = session.get(Plane.class, planeID);
		session.delete(plane);
		txn.commit();
		session.close();
	}	
	
	@Override
	public List<Plane> listPlanes() 
	{
		List<Plane> planes = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();

		String hql = "From Plane";

		TypedQuery<Plane> query = session.createQuery(hql);
		
		planes = query.getResultList();
		session.close();
		return planes;
	}
	
	@Override
	public List<Plane> listAirlines() 
	{
		List<Plane> planes = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();

		String hql = "Select distinct p From Plane p";

		Query<Plane> query = session.createQuery(hql);
		
		planes = query.list();
		session.close();
		return planes;
	}
	@Override
	public Plane searchPlaneByID(Integer flightID)
	{
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Passenger = "+ flightID;
		TypedQuery<Plane> query = session.createQuery(hql);
		Plane plane = query.getSingleResult();
		return plane;
	}  
}
