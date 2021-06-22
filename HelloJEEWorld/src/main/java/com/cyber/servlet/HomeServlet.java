package com.cyber.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyber.model.Impiegato;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Impiegato> impList = new ArrayList<Impiegato>();

		Impiegato imp1 = new Impiegato();
		imp1.setId(1);
		imp1.setName("Pinco");
		imp1.setRole("Designer");
		impList.add(imp1);

		Impiegato imp2 = new Impiegato();
		imp2.setId(2);
		imp2.setName("Baciccio");
		imp2.setRole("Manager");
		impList.add(imp2);

		request.setAttribute("impList", impList);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
	}

}
