package com.springboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
	@RequestMapping("/home")
	public String getHomePage()
	{
		return "home";
	}
	
	@RequestMapping("/greet")
	public ModelAndView greetUser(@RequestParam("name") String name)
	{
		ModelAndView modelAndView = new ModelAndView("greet");
		modelAndView.addObject("name", name);
		return modelAndView;
	}
}
