package com.DAO;

import java.util.List;
import com.dto.Flight;

public interface FlightDAO 
{
	public Integer addFlight(Flight flight);
	public void updateFlight(Integer flightID, int seats);
	public void deleteFlight(Integer flightID);
	public List<Flight> listFlights(String src, String dest,String date, int seats);
	public Flight searchFlightById(Integer flightID);
}
