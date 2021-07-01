package it.cybsec.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/update")
public class UpdateData extends HttpServlet {

	private DatabaseConnection dc;
	private Connection conn;
	private PreparedStatement st;
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
		try {
			dc = new DatabaseConnection();
			setStatement();
		} catch (Exception e) {

		}
	}
	
	private void setStatement() throws SQLException {
		conn = dc.getConnection();
		st = conn.prepareStatement("update actor set first_name = ?, last_name = ? where actor_id = ?");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		try {
			if(conn.isClosed())
				setStatement();
				
			st.setString(1, request.getParameter("firstName"));
			st.setString(2, request.getParameter("lastName"));
			st.setInt(3, Integer.parseInt(request.getParameter("id")));
			st.execute();
			st.close();
			conn.close();

			message += "Successfully updated - id=" + request.getParameter("id");
			message += " nome = '" + request.getParameter("firstName") + "'";
			message += " cognome = '" + request.getParameter("lastName") + "'";
					
			request.setAttribute("message", message);
			request.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
