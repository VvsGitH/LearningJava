package firstExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "counterFilter", urlPatterns = "/servlet")
public class CounterFilter implements Filter {

	static int count = 0;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		out.print("<p>Total Visitors: " + count + "</p>\n");

		chain.doFilter(request, response);

		out.print("<p>Total Visitors: " + ++count + "</p>\n");
		// out.close();
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}
