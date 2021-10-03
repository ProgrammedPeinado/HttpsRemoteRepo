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

import com.dto.Passenger;

public class PassengerDaoImpl implements PassengerDAO
{
	private SessionFactory factory;
	
	public PassengerDaoImpl() 
	{
		System.out.println("Config about to load");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
		System.out.println("Config loaded");
	}
	
		
	@Override
	public Integer addPassenger(Passenger passenger) 
	{
		Integer pass_id = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		pass_id = (Integer) session.save(passenger);
		txn.commit();
		session.close();
		return pass_id;
	}	
	
	
	@Override
	public void updatePassenger(Integer passengerID, int seats) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Passenger passenger = session.get(Passenger.class, passengerID);
		System.out.println(passenger);
		passenger.setSeats_purchased(seats);
		System.out.println(passenger);
		
		session.update(passenger);
		txn.commit();
		session.close();
	}	
	
	@Override
	public void deletePassenger(Integer passengerID) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Passenger passenger = session.get(Passenger.class, passengerID);
		session.delete(passenger);
		txn.commit();
		session.close();
	}	
	
	
	@Override
	public List<Passenger> listPassengers(String src, String dest, String date, int seats) 
	{
		List<Passenger> passengers = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		System.out.println("Source: "+src+
							"\nDestination: "+dest+
							"\nDate: "+date+
							"\nSeats: "+seats);
		

		String hql = "SELECT fli.source, fli.destination, fli.date, fli.seats FROM Passenger AS fli WHERE ((fli.source =:source"+
						") AND (fli.destination =:destination"+
						") AND (fli.seats >=:seats"+
						") AND (fli.date >=:date))";

		
		//System.out.println(sql);
		//Query query = session.createQuery(hql);
		TypedQuery<Passenger> query = session.createQuery(hql);
		query.setParameter("source", src);
		query.setParameter("destination", dest);
		query.setParameter("seats", seats);
		query.setParameter("date", date);
		
		//TypedQuery<Passenger> query = session.createSQLQuery(sql);
		System.out.println("Query created");
		passengers = query.getResultList();
		System.out.println("Query completed, leaving the method.");
		session.close();
		return passengers;
	}	
	
	@Override
	public Passenger searchPassengerById(Integer passengerID) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Passenger = "+ passengerID;
		TypedQuery<Passenger> query = session.createQuery(hql);
		Passenger passenger = query.getSingleResult();
		return passenger;
	}
}
