package com.sportyshoes.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.dao.AdminDaoImpl;
import com.sportyshoes.web.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDaoImpl adminDao;
	
	@Override
	public boolean updateAdmin(String admin, String pass) 
	{
		return adminDao.updateAdmin(admin, pass);
	}

	@Override
	public boolean authenticate(Admin admin) 
	{
		return adminDao.authenticate(admin);
	}

}
