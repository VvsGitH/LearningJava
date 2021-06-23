package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Integer counter = 0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String param = request.getParameter("counter");
		//if (param != null)
		//	counter = Integer.parseInt(param);

		request.setAttribute("counter", counter);
		RequestDispatcher toServlet = request.getRequestDispatcher("Servlet2");
		toServlet.forward(request, response);
		
		//request.setAttribute("counter1", counter);
		//RequestDispatcher toJsp = getServletContext().getRequestDispatcher("/counters.jsp");
		//toJsp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}
