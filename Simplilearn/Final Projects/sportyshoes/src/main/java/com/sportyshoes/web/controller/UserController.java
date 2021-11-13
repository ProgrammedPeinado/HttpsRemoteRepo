package com.sportyshoes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.web.model.User;
import com.sportyshoes.web.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addUser")
	public String getAddUser()
	{
		return "adduser";
	}
	
	@RequestMapping("/updateUser")
	public String getUpdateUser()
	{
		return "updateUser";
	}
	
	@RequestMapping("/searchUserPage")
	public String getSearchUser()
	{
		return "searchuser";
	}
	@RequestMapping("/searchUser")
	public ModelAndView searchUser(@RequestParam("id") String id)
	{
		ModelAndView modelAndView = new ModelAndView("searchsuccess");
		modelAndView.addObject("user", userService.searchUser(Integer.parseInt(id)));
		return modelAndView;
	}
	
	@RequestMapping("/addNewUser")
	public String addUser(@ModelAttribute("user") User user)
	{
		String viewName = null;
		boolean isUserAdded = userService.addUser(user);
		if(isUserAdded)
			viewName = "addsuccess"; //jsp on add successful
		else
			viewName = "addfailure"; //jsp on add failed
		return "addsuccess";
	}
	
	
	
	@RequestMapping("/updateNewUser")
	public String updateUser(@RequestParam("id") int id, @RequestParam("password") String password)
	{
		String viewName = null;
		boolean isUserUpdated = userService.updateUser(id, password);
		if(isUserUpdated)
			viewName = "addsuccess";
		else 
			viewName = "addfailure";
		
		return viewName;	
	}
	
	@RequestMapping("/listUsers")
	public ModelAndView getAllUsers()
	{
		List<User> allUsers = userService.getAllUsers();
		ModelAndView modelAndView = new ModelAndView("displayusers");
		modelAndView.addObject("users", allUsers);
		return modelAndView;
				
	}
}
