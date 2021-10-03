package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrators")
public class Admin 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="username")
	private String user;
	@Column(name="password")
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Admin [user=" + user + ", pass=" + pass + "]";
	}
}
