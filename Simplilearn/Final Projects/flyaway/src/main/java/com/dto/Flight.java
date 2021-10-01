package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avail_flights")
public class Flight 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="flight_id")
	private String id;
	@Column(name="src_point")
	private String source;
	@Column(name="dest_point")
	private String destination;
	@Column(name="travel_date")
	private String date;
	@Column(name="time_to_board")
	private String time;
	@Column(name="price")
	private double price;
	@Column(name="seat_vacancy")
	private int seats;
	
	public Flight()
	{
	}
	
	public Flight(String id, String source, String destination, String date, String time, String price, String seats)
	{
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.time = time;
		this.price = Double.parseDouble(price);
		this.seats = Integer.parseInt(seats);
	}
	
	public Flight(String source, String destination, String seats, String date)
	{
		super();
		this.source = source;
		this.destination = destination;
		this.seats = Integer.parseInt(seats);
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", date=" + date + ", time="
				+ time + ", price=" + price + "]";
	}
}
