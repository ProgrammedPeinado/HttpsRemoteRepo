package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController
{
	@RequestMapping("/home")
	public ModelAndView getHomePage()
	{
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
	//This method accepts data from the jsp form
	@RequestMapping("/welcome")
	public ModelAndView welcomeUser(@RequestParam(name="username") String name)
	{
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;
	}
}
