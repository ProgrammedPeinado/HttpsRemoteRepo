package com.springboot.web.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.web.model.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao
{
	@Autowired
	DataSource dataSource; //We need this to boot first to get database connection details
	
	@PostConstruct //For lifecycle method
	private void initialize()
	{
		setDataSource(dataSource);
	}

	@Override
	public void addEmployee(Employee employee)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee searchEmployee(int id)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEMployee(int id, String email)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int id)
	{
		// TODO Auto-generated method stub
		
	}
}
