package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class PasswordChange
 */

public class PasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admins = null;
		AdminDAO adminCheck = new AdminDaoImpl();
		String oldpass = request.getParameter("oldpass");
		String newpass = request.getParameter("newpass");
		PrintWriter out = response.getWriter();
		
		
		admins = adminCheck.getAdmins();
		
		try
		{
			for(Admin a : admins)
			{
				if(a.getPass().equals(oldpass));
				{
					adminCheck.updateAdmin(a.getUser(), newpass);
					out.println("Your password has been updated successfully!");
					out.println("<br><a href=\"/flyaway\">Book a flight and register as passenger</a>");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
