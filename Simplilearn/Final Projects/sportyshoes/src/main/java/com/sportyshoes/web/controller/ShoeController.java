package com.sportyshoes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sportyshoes.web.service.ShoeService;

@Controller
public class ShoeController 
{
	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping("/getShoes")
	public ModelAndView getShoes()
	{
		Map<String, ArrayList<String>> shoes = shoeService.getShoeTags();
		ModelAndView modelAndView = new ModelAndView("displayshoes");
		modelAndView.addObject("shoes", shoes);
		return modelAndView;
	}
	
}
