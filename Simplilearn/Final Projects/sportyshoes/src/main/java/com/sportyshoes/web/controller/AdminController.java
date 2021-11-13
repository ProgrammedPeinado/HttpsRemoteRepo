package com.sportyshoes.web.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.web.model.Admin;
import com.sportyshoes.web.service.AdminService;
import com.sportyshoes.web.service.ShoeService;



@Controller
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping("/adminLogin")
	public String getAdminLogin()
	{
		return "admin_login";
	}
	
	@RequestMapping("/adminPassChangePage")
	public String getAdminPassChange()
	{
		return "adminpasschange";
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authentication(@RequestParam("user") String user, @RequestParam("pass") String pass)
	{
		Admin admin = new Admin();
		admin.setUser(user);
		admin.setPass(pass);
		
		
		if (adminService.authenticate(admin)) {
			ModelAndView modelAndView = new ModelAndView("adminpage");
			modelAndView.addObject("admin", admin);
			return modelAndView;
			} else {
				ModelAndView modelAndView = new ModelAndView("failedadmin");
			  return modelAndView;
			}
	}
	
	@RequestMapping("/passwordChange")
	public ModelAndView passwordChange(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass)
	{
		List<Admin> admins = adminService.getAllAdmins();
		Admin a = new Admin();
		a.setUser(admins.get(0).getUser());
		a.setPass(admins.get(0).getPass());
		boolean flag = false;
		
		if(a.getPass().equals(oldpass))
		{
			ModelAndView modelAndView = new ModelAndView("changepass_success");
			flag = adminService.updateAdmin(a.getUser(), newpass);
			if(flag != false)
				return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("failedadmin");
		  return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
}
