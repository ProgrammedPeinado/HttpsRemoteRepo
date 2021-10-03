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
		if (request.getParameter("id") == null)
		{
			System.out.println("id is null");
			response.getWriter().append("The id was nulled");
		}
		else
		{
			Flight flightID = flightDao.searchFlightById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("flight", flightID);
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
	        dispatcher.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
