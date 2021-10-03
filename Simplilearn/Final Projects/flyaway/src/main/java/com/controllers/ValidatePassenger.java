package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightDaoImpl;
import com.DAO.PassengerDaoImpl;
import com.dto.Flight;
import com.dto.Passenger;



/**
 * Servlet implementation class ValidateUser
 */
public class ValidatePassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PassengerDaoImpl passDao;
    private FlightDaoImpl flightDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidatePassenger() {
        super();
        passDao = new PassengerDaoImpl();
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

		if (request.getParameter("id") == null)
		{
			System.out.println("id is null");
			response.getWriter().append("The id was nulled");
		}
		else
		{
			Passenger passenger = passDao.searchPassengerById(Integer.parseInt(request.getParameter("id")));
			Flight flight = flightDao.searchFlightById(passenger.getFlight_id());
			response.getWriter().append(request.getParameter("id"));
			request.setAttribute("passenger", passenger);
			request.setAttribute("flight", flight);
			RequestDispatcher dispatcher = request.getRequestDispatcher("summary.jsp");
	        dispatcher.forward(request, response);
		}
	}

}
