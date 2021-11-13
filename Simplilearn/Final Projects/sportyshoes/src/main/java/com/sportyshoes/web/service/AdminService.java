package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportyshoes.web.model.Admin;

@Service
public interface AdminService 
{
	public boolean updateAdmin(String admin, String pass);
	public boolean authenticate(Admin admin);
	public List<Admin> getAllAdmins();
}
