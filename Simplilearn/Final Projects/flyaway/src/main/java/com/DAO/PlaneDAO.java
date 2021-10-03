package com.DAO;

import java.util.List;

import com.dto.Plane;

public interface PlaneDAO 
{
	public Integer addPlane(Plane plane);
	public void updatePlane(String airline, Integer flightID);
	public void deletePlane(Integer flightID);
	public List<Plane> listPlanes();
	public List<Plane> listAirlines();
	public Plane searchPlaneByID(Integer flightID);
}
