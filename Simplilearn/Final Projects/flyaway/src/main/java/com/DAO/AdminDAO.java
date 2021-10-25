package com.DAO;

import java.util.List;

import com.dto.Admin;

public interface AdminDAO 
{
	public String addAdmin(Admin admin);
	public void updateAdmin(String admin, String pass);
	public void deleteAdmin(String admin);
	public List<Admin> getAdmins();
}
