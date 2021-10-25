package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightDaoImpl;
import com.dto.Flight;



/**
 * Servlet implementation class ValidateUser
 */
public class ValidateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FlightDaoImpl flightDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateFlight() {
        super();
        flightDao = new FlightDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("The selection just hit Validate flight:"+request.getParameter("selection"));
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registration.jsp");
		request.setAttribute("selection", request.getParameter("selection"));
		request.getRequestDispatcher("registration.jsp").forward(request, response);
        
	}

}
