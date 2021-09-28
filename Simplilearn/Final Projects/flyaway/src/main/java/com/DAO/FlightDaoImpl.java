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

import com.dto.Flight;

public class FlightDaoImpl implements FlightDAO{
	private SessionFactory factory;
	
	public FlightDaoImpl() 
	{
		System.out.println("Config about to load");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();
		System.out.println("Config loaded");
	}
	
		
	@Override
	public Integer addFlight(Flight flight) {
		Integer empId = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		// save methods adds new row into database table
		empId = (Integer) session.save(flight);
		txn.commit();
		session.close();
		return empId;
	}	
	
	
	@Override
	public void updateFlight(Integer flightID, int seats) {
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		Flight flight = session.get(Flight.class, flightID);
		System.out.println(flight);
		flight.setSeats(seats);
		System.out.println(flight);
		
		session.update(flight);
		txn.commit();
		session.close();
	}	
	
	@Override
	public void deleteFlight(Integer flightID) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		Flight flight = session.get(Flight.class, flightID);
		session.delete(flight);
		txn.commit();
		session.close();
	}	
	
	
	@Override
	public List<Flight> listFlights(String src, String dest, String date, int seats) 
	{
		List<Flight> flights = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		String hql = "FROM Flight f where (f.source = "+src+
						") AND (f.destination = "+dest+
						") AND (f.seats >= "+seats+
						") AND (f.date >= "+date+")";
		
		TypedQuery<Flight> query = session.createQuery(hql);
		flights = query.getResultList();
		session.close();
		return flights;
	}	
	
	@Override
	public Flight searchFlightById(Integer flightID) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Flight f where f.id = "+ flightID;
		TypedQuery<Flight> query = session.createQuery(hql);
		Flight flight = query.getSingleResult();
		return flight;
	}
}













