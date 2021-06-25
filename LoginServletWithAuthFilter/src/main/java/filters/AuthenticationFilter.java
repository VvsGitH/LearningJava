package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Get and log resource URI
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		// Get the current session, if exist
		HttpSession session = req.getSession(false);

		// Redirect to login page if the session is expired and we are not currently
		// loggin in
		if (session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.html");

		// If the session is not expired, continue to the other pages
		} else
			chain.doFilter(request, response);

	}

	public void destroy() {
		// close any resources here
	}

}
