package com.sportyshoes.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sportyshoes.web.model.Shoe;
import com.sportyshoes.web.service.ShoeService;

@Controller
public class ShoeController 
{
	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping("/addShoePage")
	public String getAddShoe()
	{
		return "addshoe";
	}
	@RequestMapping("/updateShoePage")
	public String getUpdateShoe()
	{
		return "updateshoe";
	}
	@RequestMapping("/deleteShoePage")
	public String getDeleteShoe()
	{
		return "deleteshoe";
	}
	
	@RequestMapping("/getShoes")
	public ModelAndView getShoes()
	{
		Map<String, ArrayList<Shoe>> shoes = shoeService.getShoeTags();
		ModelAndView modelAndView = new ModelAndView("displayshoes");
		modelAndView.addObject("shoes", shoes);
		return modelAndView;
	}
	
	@RequestMapping("/addShoe")
	public ModelAndView addShoe(@RequestParam("name") String name, @RequestParam("tag") String tag, @RequestParam("thumbnail") String thumbnail)
	{
		ModelAndView modelAndView = new ModelAndView("addshoesuccessful");
		Shoe shoe = new Shoe();
		shoe.setShoe_name(name);
		shoe.setTag(tag);
		shoe.setThumbnail(thumbnail);
		
		boolean flag = shoeService.addShoe(shoe);
		
		return modelAndView;
	}
	
	@RequestMapping("/updateShoe")
	public ModelAndView updateShoe(@RequestParam("id") String id, @RequestParam("tag") String tag)
	{
		ModelAndView modelAndView = new ModelAndView("updateshoesuccessful");
		shoeService.updateShoe(Integer.parseInt(id), tag);
		return modelAndView;
	}
}
