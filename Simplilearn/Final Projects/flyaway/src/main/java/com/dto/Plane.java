package com.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plane")
public class Plane 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="flight_id")
	private Integer flight_id;
	@Column(name="plane_id")
	private Integer plane_id;
	@Column(name="airline")
	private String airline;
	
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	@Override
	public String toString() {
		return "Plane [flight_id=" + flight_id + ", plane_id=" + plane_id + ", airline=" + airline + "]";
	}
}
