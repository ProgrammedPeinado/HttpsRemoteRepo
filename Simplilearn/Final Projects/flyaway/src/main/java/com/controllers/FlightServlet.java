package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightDAO;
import com.DAO.FlightDaoImpl;
import com.DAO.PlaneDAO;
import com.DAO.PlaneDaoImpl;
import com.dto.Flight;
import com.dto.Plane;

/**
 * Servlet implementation class FlightServlet
 */
@WebServlet("/FlightServlet")
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String adminOptions = request.getParameter("selection");
		FlightDAO flightDAO = new FlightDaoImpl();
		PlaneDAO planeDAO = new PlaneDaoImpl();
		String source = null; //to identify the parametrized method
		String dest = null; //
		List<Flight> res = null;
		List<Plane> resAir = null;
		
		if(adminOptions ==null);
			adminOptions = "none";
			
		switch(adminOptions)
		{
			case "listSources":
			{
				res = flightDAO.listFlights(source, dest);
				request.setAttribute("List", res);
				response.sendRedirect("admin_list.jsp");
				break;
			}
			case "listAirlines":
			{
				resAir = planeDAO.listAirlines();
				request.setAttribute("List", resAir);
				response.sendRedirect("admin_list.jsp");
				break;
			}
			default:
			{
				res = flightDAO.listFlights();
				request.setAttribute("List", res);
				response.sendRedirect("admin_list.jsp");
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
