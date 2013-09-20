package grails.util.http;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class MultiReadServletFilter implements Filter {

	private static final Set<String> MULTI_READ_HTTP_METHODS = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER) {{
		add("PUT");
		add("POST");
	}};

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		if(servletRequest instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			if(MULTI_READ_HTTP_METHODS.contains(request.getMethod())) {
				filterChain.doFilter(new MultiReadHttpServletRequest(request), servletResponse);
				return;
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		}

	public void destroy() {
		}
}
