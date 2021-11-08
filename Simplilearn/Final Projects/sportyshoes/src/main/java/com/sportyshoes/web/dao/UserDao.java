package com.sportyshoes.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sportyshoes.web.model.User;

@Repository
public interface UserDao
{
	public boolean addUser(User user);
	public List<User> getAllUsers();
	public User searchUser(int id);
	public boolean updateUser(int id, String password);
	public void deleteUser(int id);
}
