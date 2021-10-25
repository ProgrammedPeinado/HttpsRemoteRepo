package com.DAO;

import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
		Integer flight_id = null;
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		flight_id = (Integer) session.save(flight);
		txn.commit();
		session.close();
		return flight_id;
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
	public List<Flight> listFlights(String src, String dest) 
	{
		List<Flight> flights = null;
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(com.dto.Flight.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory factory = conf.buildSessionFactory(builder.build());
		
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();

		String hql = "FROM Flight AS fli";

		TypedQuery<Flight> query = session.createQuery(hql);

		flights = query.getResultList();

		session.close();
		return (List<Flight>)flights;
	}	
	
	@Override
	public List<Flight> listFlights(String src, String dest, String date, int seats) 
	{
		List<Flight> flights = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();

		String hql = "FROM Flight AS fli WHERE ((fli.source =:source"+
				") AND (fli.destination =:destination"+
				") AND (fli.seats >=:seats"+
				") AND (fli.date >=:date))";
	
		Query<Flight> query = session.createQuery(hql);
		
		query.setParameter("source", src);
		query.setParameter("destination", dest);
		query.setParameter("seats", seats);
		query.setParameter("date", date);
		
		flights = query.list();
		
		//flights = query.getResultList();

		session.close();
		return (List<Flight>)flights;
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Flight>listFlights() 
	{
		List<Flight> flights = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();

		String hql = "From Flight";

		
		TypedQuery<Flight> query = session.createQuery(hql);
		
		flights = query.getResultList();
		session.close();
		return (List<Flight>)flights;
	}
	
	@Override
	public Flight searchFlightById(Integer flightID) {
		Flight flight = new Flight();
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Flight AS fli WHERE fli.id = :flight_id";
		System.out.println("\n ================ DEBUG:"+hql+"============\n");
		Query<Flight> query = session.createQuery(hql);
		query.setParameter("flight_id", flightID);
		flight = query.getSingleResult();
		System.out.println("\n ================ DEBUG \nLeaving the single search");
		return flight;
	}
}













