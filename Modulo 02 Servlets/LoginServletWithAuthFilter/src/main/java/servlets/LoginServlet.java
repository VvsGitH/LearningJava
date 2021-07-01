package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String userID = "admin";
	private final String password = "password";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		if (userID.equals(user) && password.equals(pwd)) {
			// Create session
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60); // 30mins

			// Create cookie
			Cookie userNameCookie = new Cookie("user", user);
			userNameCookie.setMaxAge(30*60);
			response.addCookie(userNameCookie);

			// Redirect
			response.sendRedirect("LoginSuccess.jsp");

		} else {
			// Wrong credentials!
			// Include login.hmtl
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			response.getWriter().print("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);	
		}
	}

}
