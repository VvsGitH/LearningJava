package com.secondExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpservlet4")
public class HttpServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Accessing the url parameter!
		String userName = request.getParameter("userName");
		if (userName != null)
			out.print("<h2>Hello " + userName + "!</h2>\n");
		else
			out.print("<h2>Something went wrong!<h2>");

		out.close();
	}

}
