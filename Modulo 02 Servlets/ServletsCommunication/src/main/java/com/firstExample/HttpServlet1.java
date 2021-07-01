package com.firstExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/httpservlet1")
public class HttpServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Fetching the contents of the userName input field from the form in index.html
		// and printing it on the page.
		String userName = request.getParameter("userName");
		if (userName != null) {
			out.print("<h2>Welcome" + userName + "</h2>\n");

			// Creating a new session
			// and setting a session variable which contains the userName.
			// All servlets in the same session can access this variable.
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);

			// Link to the second servlet
			out.print("<a href='httpservlet2'>GO HERE</a>");

		} else
			out.print("<h2>Something went wrong!</h2>");

		out.close();
	}

}
