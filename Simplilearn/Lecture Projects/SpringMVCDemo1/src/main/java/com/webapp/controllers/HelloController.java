package com.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/controller")
public class HelloController
{
	@RequestMapping("/hello")
	public ModelAndView sayHello()
	{
		ModelAndView modelAndView = new ModelAndView("Hello");
		return modelAndView;
	}
	
	@RequestMapping("/hi")
	public ModelAndView sayHi()
	{
		ModelAndView modelAndView = new ModelAndView("Hi");
		return modelAndView;
	}

}
