package com.thirdExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This method receives the client POST requests
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Fetch password
		String password = request.getParameter("userPass");

		if (password != null && password.equals("Thanos")) {
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);

		} else {
			out.print("Passoword mismatch");
			RequestDispatcher rd = request.getRequestDispatcher("/index3.html");
			rd.include(request, response);
		}

		out.close();
	}

}
