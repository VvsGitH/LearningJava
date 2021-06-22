package com.cyber.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String DEFAULT_USER = "Guest";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("user");
		if (user == null)
			user = HelloServlet.DEFAULT_USER;
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			.append("<html>\r\n"
					+ " <head>\r\n"
					+ "  <title>Hello User Application</title>\r\n"
					+ " </head>\r\n"
					+ " <body>\r\n"
					+ "  Hello, ")
			.append(user)
			.append("!<br/><br/>\r\n"
					+ "  <form action=\"greeting\" method=\"POST\">\r\n"
					+ "   Enter your name:<br/>\r\n"
					+ "   <input type=\"text\" name=\"user\"/><br/>\r\n"
					+ "   <input type=\"submit\" value=\"Submit\"/>\r\n"
					+ "  </form>\r\n"
					+ " <body>\r\n"
					+ "</html>\r\n");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started.");
	}

	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped.");
	}
}
