package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.Admin;
import com.sportyshoes.web.model.Shoe;

@Repository
public class AdminDaoImpl extends JdbcDaoSupport implements AdminDao
{
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public boolean updateAdmin(String username, String password) 
	{
		boolean isAdminUpdated = false;
		String sql = "update administrators set password=? where username=?";
		int val = getJdbcTemplate().update(sql, password, username);
		if(val > 0)
			isAdminUpdated = true;
			
		return isAdminUpdated;
	}	

	@SuppressWarnings("deprecation")
	@Override
	public boolean authenticate(Admin admin) 
	{
		boolean flag = false;
		String sql = "select username from administrators where password=?";
		String check = null;
		
		try 
		{
			check = getJdbcTemplate().queryForObject(sql, new Object[]{admin.getPass()}, String.class);
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
		if(admin.getUser().equals(check))
		{
			flag = true;
		}
		
		return flag;
	}
	
	@Override
	public List<Admin> getAllAdmins()
	{
		List<Admin> admins = new ArrayList<Admin>();
		String sql = "select * from administrators";
		List<Map<String, Object>> adminData = getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> s: adminData)
		{
			Admin admin = new Admin();
			admin.setUser((String)s.get("username"));
			admin.setPass((String)s.get("password"));
			admins.add(admin);
		}
		return admins;
	}
}
