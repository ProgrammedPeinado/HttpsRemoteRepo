package com.sportyshoes.web.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.User;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao 
{
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize()
	{
		setDataSource(dataSource);
	}
	
	@Override
	public boolean addUser(User user) 
	{
		boolean flag = false;
		String sql = "insert into user values(?,?,?,?,?)";
		int val = getJdbcTemplate().update(sql, new Object[] {user.getId(), user.getFirstname(), user.getLastname(), user.getPhoneNumber(),user.getEmail()});
		if(val > 0)
			flag = true;
		
		return flag;
	}

	@Override
	public List<User> getAllUsers() 
	{
		List<User> users =  new ArrayList();
		String sql = "select * from user";
		List<Map<String, Object>> userData = getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> usr: userData)
		{
			User user = new User();
			user.setId((Integer)usr.get("id"));
			user.setFirstname((String)usr.get("firstname"));
			user.setLastname((String)usr.get("lastname"));
			user.setPhoneNumber((String)usr.get("phoneNumber"));
			user.setEmail((String)usr.get("email"));
			
			if(user != null)
			{
				users.add(user);	
			}
			
		}
		
		return users;
	}

	@Override
	public User searchUser(int id) 
	{
		boolean flag = false;
		User user = new User();
		List<Map<String, Object>> userData= null;
		String sql = "select * from user where id=?";
		String check = null;
		
		try 
		{
			userData = getJdbcTemplate().queryForList(sql, id); //, new Object[] user.getFirstname(), user.getLastname(), user.getPhoneNumber(), user.getEmail(), User.class)
			for(Map<String, Object> usr: userData)
			{
				user.setId((Integer)usr.get("id"));
				user.setFirstname((String)usr.get("firstname"));
				user.setLastname((String)usr.get("lastname"));
				user.setPhoneNumber((String)usr.get("phoneNumber"));
				user.setEmail((String)usr.get("email"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}

		return user;
	}

	@Override
	public boolean updateUser(int id, String password) 
	{
		boolean isUserUpdated = false;
		String sql = "update user set password=? where id=?";
		int val = getJdbcTemplate().update(sql, password, id);
		if(val > 0)
			isUserUpdated = true;
			
		return isUserUpdated;
	}

	@Override
	public void deleteUser(int id) 
	{	
	}

}
