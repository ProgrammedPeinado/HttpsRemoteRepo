package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdata_2")
public class Student
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Roll_no")
	private int rollNo;
	
	@Column(name="grade")
	private int grade;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	public Student()
	{
	}
	
	public Student(String firstname, String lastname, int grade)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.grade = grade;
	}
	public int getRollNo()
	{
		return rollNo;
	}

	public void setRollNo(int rollNo)
	{
		this.rollNo = rollNo;
	}

	public int getGrade()
	{
		return grade;
	}

	public void setGrade(int grade)
	{
		this.grade = grade;
	}

	public String getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	
	
}
