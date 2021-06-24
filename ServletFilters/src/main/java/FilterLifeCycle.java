

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/servlet")
public class FilterLifeCycle implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.print("<p>Filter is invoked before</p>\n");

		// Sends request to next resource
		// It could be another filter or a servlet
		chain.doFilter(request, response);

		out.print("<p>Filter is invoked after</p>\n");
		out.close();

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
