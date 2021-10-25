package com.springboot.web.dao;

import java.util.List;

import com.springboot.web.model.Employee;

public interface EmployeeDao
{
	public void addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee searchEmployee(int id);
	
	public void updateEMployee(int id, String email);
	
	public void deleteEmployee(int id);
}
