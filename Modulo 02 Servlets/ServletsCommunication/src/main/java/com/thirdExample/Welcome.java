package com.thirdExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 2L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Fetch username
		String userName = request.getParameter("userName");
		if (userName != null && !userName.equals(""))
			out.print("<h2>Welcome " + userName + "!</h2>");
		else
			out.print("<h2>Welcome anonymous one!</h2>");

		out.close();
	}

}
