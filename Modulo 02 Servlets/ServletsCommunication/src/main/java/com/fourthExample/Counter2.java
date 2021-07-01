package com.fourthExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/counter2")
public class Counter2 extends HttpServlet {
	private static final long serialVersionUID = 2L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Integer counter = (Integer) request.getAttribute("counter");
		out.print("<p>" + counter + "</p>\n");

		counter++;
		request.setAttribute("counter", counter);

		RequestDispatcher rd = request.getRequestDispatcher("counter1");
		rd.include(request, response);

		out.close();
	}

}
