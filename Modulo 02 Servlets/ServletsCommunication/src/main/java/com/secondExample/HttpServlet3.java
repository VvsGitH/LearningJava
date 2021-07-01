package com.secondExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/httpservlet3")
public class HttpServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		if (userName != null) {
			out.print("<h2>Welcome " + userName + "</h2>\n");

			// Creating a link to a special url with a parameter
			// The other servlet can access the url parameter
			out.print("<a href='httpservlet4?userName=" + userName + "'>GO HERE</a>");

		} else
			out.print("<h2>Something went wrong!</h2>");

		out.close();
	}
}
