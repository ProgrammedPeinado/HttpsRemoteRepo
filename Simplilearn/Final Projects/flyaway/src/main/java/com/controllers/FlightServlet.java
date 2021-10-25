package com.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
		String adminOptions = request.getParameter("submittion");
		FlightDAO flightDAO = new FlightDaoImpl();
		PlaneDAO planeDAO = new PlaneDaoImpl();
		String source = null; //to identify the parametrized method
		String dest = null; //
		List<Flight> res = null;
		List<Plane> resAir = null;
		PrintWriter out = response.getWriter();
		
		if(adminOptions ==null)
		{
			adminOptions = "none";
		}
		System.out.println("\n ==================== \nThis is the adminOptions output");	
		switch(adminOptions)
		{
			case "listSources":
			{
				System.out.println("Getting all sources and destinations");
				String props = "source,destination";
				res = flightDAO.listFlights();
				
				
				request.setAttribute("props", props);
				request.setAttribute("List", res);
				request.getRequestDispatcher("admin_list.jsp").forward(request,response);
				break;
			}
			case "listAirlines":
			{
				System.out.println("Getting all airlines");
				String props = "airline";
				resAir = planeDAO.listAirlines();
				
				request.setAttribute("props", props);
				request.setAttribute("List", resAir);
				request.getRequestDispatcher("admin_list.jsp").forward(request,response);
				break;
			}
			default:
			{
				System.out.println("Getting all flights");
				String props = "id,source,destination,date,seats";
				res = flightDAO.listFlights();
				
				request.setAttribute("props", props);
				request.setAttribute("List", res);
				request.getRequestDispatcher("admin_list.jsp").forward(request,response);
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
