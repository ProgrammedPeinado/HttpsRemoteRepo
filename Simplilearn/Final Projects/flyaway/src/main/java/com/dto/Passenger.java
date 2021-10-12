package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passengers")
public class Passenger 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="passenger_id")
	private Integer passenger_id;
	@Column(name="flight_id")
	private Integer flight_id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="seats_purchased")
	private Integer seats_purchased;
	
	public Passenger()
	{
	}
	
	public Passenger(String firstname, String lastname, int flight_id, int seats_purchased)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.flight_id = flight_id;
		this.seats_purchased = seats_purchased;
	}
	
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getSeats_purchased() {
		return seats_purchased;
	}
	public void setSeats_purchased(int seats_purchased) {
		this.seats_purchased = seats_purchased;
	}
	
	@Override
	public String toString() {
		return "Passenger [passenger_id=" + passenger_id + ", flight_id=" + flight_id + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", seats_purchased=" + seats_purchased + "]";
	}
	
}
