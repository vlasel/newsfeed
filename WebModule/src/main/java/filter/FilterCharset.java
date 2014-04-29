package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterCharset
 */
//@WebFilter("/FilterCharset")
public class FilterCharset implements Filter {

	private String charset = null;
    /**
     * Default constructor. 
     */
    public FilterCharset() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		charset = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding(charset);
		
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");
	}

}
