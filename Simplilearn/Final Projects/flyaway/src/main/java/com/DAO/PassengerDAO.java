package com.DAO;

import java.util.List;

import com.dto.Passenger;

public interface PassengerDAO 
{
	public Integer addPassenger(Passenger passenger);
	public void updatePassenger(Integer passengerID, int flight_id);
	public void deletePassenger(Integer passengerID);
	public List<Passenger> listPassengers(String src, String dest,String date, int seats);
	public Passenger searchPassengerById(Integer passengerID);
}
