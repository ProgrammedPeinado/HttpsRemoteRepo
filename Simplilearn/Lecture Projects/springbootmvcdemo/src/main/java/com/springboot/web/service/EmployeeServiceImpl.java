package com.springboot.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.dao.EmployeeDao;

@Service //Specifying service layer activation
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	
	
}
