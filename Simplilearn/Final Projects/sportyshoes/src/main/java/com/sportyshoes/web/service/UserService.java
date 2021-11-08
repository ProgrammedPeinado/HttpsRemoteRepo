package com.sportyshoes.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportyshoes.web.model.User;

@Service
public interface UserService 
{
	public boolean addUser(User user);
	public List<User> getAllUsers();
	public User searchUser(int id);
	public boolean updateUser(int id, String password);
	public void deleteUser(int id);
}
