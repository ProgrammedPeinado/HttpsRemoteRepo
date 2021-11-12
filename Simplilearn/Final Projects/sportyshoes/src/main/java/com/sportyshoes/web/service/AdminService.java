package com.sportyshoes.web.service;

import org.springframework.stereotype.Service;

import com.sportyshoes.web.model.Admin;

@Service
public interface AdminService 
{
	public boolean updateAdmin(String admin, String pass);
	public boolean authenticate(Admin admin);
}
