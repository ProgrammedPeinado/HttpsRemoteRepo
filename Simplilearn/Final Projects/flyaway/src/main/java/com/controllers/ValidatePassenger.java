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
		Passenger pass = new Passenger();
		Flight flight = new Flight();
		FlightDaoImpl fdao = new FlightDaoImpl();
		
		System.out.println("This is the submission parameter:"+request.getParameter("submission"));
		pass.setFirstname(request.getParameter("firstname"));
		pass.setLastname(request.getParameter("lastname"));
		pass.setFlight_id(Integer.parseInt(request.getParameter("submission")));
		pass.setSeats_purchased(Integer.parseInt(request.getParameter("seats")));
		
		flight = fdao.searchFlightById(Integer.parseInt(request.getParameter("submission")));
		System.out.println("\n ===========\n DEBUG Back to post after single object search");
		
		request.setAttribute("flight", flight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("summary.jsp");
    	dispatcher.forward(request, response);
	}

}
