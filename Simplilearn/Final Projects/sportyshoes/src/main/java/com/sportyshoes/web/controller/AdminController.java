package com.sportyshoes.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sportyshoes.web.model.Admin;
import com.sportyshoes.web.service.AdminService;



@Controller
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/adminLogin")
	public String getAdminLogin()
	{
		return "admin_login";
	}
	
	@RequestMapping("/authenticate")
	public ModelAndView authentication(@RequestParam("username") String user, @RequestParam("pass") String pass)
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
	public ModelAndView passwordChange(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass, @RequestParam("pass") String pass)
	{
		List<Admin> admins = null;
		boolean flag = false;
		try
		{
			for(Admin a : admins)
			{
				if(pass.equals(oldpass))
				{
					ModelAndView modelAndView = new ModelAndView("changepass_success");
					flag = adminService.updateAdmin(a.getUser(), newpass);
					return modelAndView;
				} else {
					ModelAndView modelAndView = new ModelAndView("failedadmin");
				  return modelAndView;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			return new ModelAndView("home");
		}
	}
}
