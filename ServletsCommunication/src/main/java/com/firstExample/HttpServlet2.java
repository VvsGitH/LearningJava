package com.firstExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/httpservlet2")
public class HttpServlet2 extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get the current session.
		// If there is no current session returns null
		HttpSession session = request.getSession(false);

		if (session != null) {
			String userName = (String) session.getAttribute("userName");
			if (userName != null)
				out.print("<h2>Hello " + userName + "</h2>");
			else
				out.print("<h2>Something went wrong!</h2>");
		}

		out.close();
	}

}
