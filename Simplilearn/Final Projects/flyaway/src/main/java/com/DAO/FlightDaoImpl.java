package com.DAO;

import java.io.PrintWriter;
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
		// save methods adds new row into database table
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
	public List<Flight> listFlights(String src, String dest, String date, int seats) 
	{
		List<Flight> flights = null;
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		System.out.println("Source: "+src+
							"\nDestination: "+dest+
							"\nDate: "+date+
							"\nSeats: "+seats);
		
		/**
		String sql = "SELECT f.src_point, f.dest_point, f.travel_date, f.seat_vacancy "+
				"FROM avail_flights f "+
				"WHERE ((f.src_point = \""+src+
				"\") AND (f.dest_point = \""+dest+
				"\") AND (f.seat_vacancy >= \""+Integer.toString(seats)+
				"\") AND (f.travel_date >= \""+date +"\" ));"; //Works
		**/

		String hql = "SELECT fli.id, fli.source, fli.destination, fli.date, fli.seats FROM Flight AS fli WHERE ((fli.source =:source"+
						") AND (fli.destination =:destination"+
						") AND (fli.seats >=:seats"+
						") AND (fli.date >=:date))";

		
		//System.out.println(sql);
		//Query query = session.createQuery(hql);
		TypedQuery<Flight> query = session.createQuery(hql);
		query.setParameter("source", src);
		query.setParameter("destination", dest);
		query.setParameter("seats", seats);
		query.setParameter("date", date);
		
		//TypedQuery<Flight> query = session.createSQLQuery(sql);
		System.out.println("Query created");
		flights = query.getResultList();
		System.out.println("Query completed, leaving the method.");
		session.close();
		return flights;
	}	
	
	@Override
	public Flight searchFlightById(Integer flightID) {
		Session session  = factory.openSession();
		Transaction txn = session.beginTransaction();
		String hql = "FROM Flight = "+ flightID;
		TypedQuery<Flight> query = session.createQuery(hql);
		Flight flight = query.getSingleResult();
		return flight;
	}
}













