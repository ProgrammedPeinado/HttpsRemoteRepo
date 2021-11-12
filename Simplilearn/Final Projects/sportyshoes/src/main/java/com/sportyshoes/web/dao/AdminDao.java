package com.sportyshoes.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Admin;

@Repository
public interface AdminDao 
{
	public boolean updateAdmin(String admin, String pass);
	public boolean authenticate(Admin admin);
}
