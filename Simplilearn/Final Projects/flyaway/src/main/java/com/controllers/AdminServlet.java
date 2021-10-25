package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AdminDAO;
import com.DAO.AdminDaoImpl;
import com.dto.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("admin_login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Admin> admins = null;
		AdminDAO adminCheck = new AdminDaoImpl();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		//List admin then compare
		admins = adminCheck.getAdmins();
		
		try
		{
			for(Admin a : admins)
			{
				if(a.getUser().equals(user) & a.getPass().equals(pass));
				{
					response.sendRedirect("admin_page.jsp");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
