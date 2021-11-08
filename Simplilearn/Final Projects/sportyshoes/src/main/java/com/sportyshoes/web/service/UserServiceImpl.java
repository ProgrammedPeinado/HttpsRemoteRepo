package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.web.dao.UserDaoImpl;
import com.sportyshoes.web.model.User;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserDaoImpl userDao;
	
	@Override
	public boolean addUser(User user) 
	{
		return userDao.addUser(user);
	}

	@Override
	public List<User> getAllUsers() 
	{
		return userDao.getAllUsers();
	}

	@Override
	public User searchUser(int id) 
	{
		return userDao.searchUser(id);
	}

	@Override
	public boolean updateUser(int id, String password) 
	{
		return userDao.updateUser(id, password);
	}

	@Override
	public void deleteUser(int id) 
	{
		userDao.deleteUser(id);
	}
	
}
