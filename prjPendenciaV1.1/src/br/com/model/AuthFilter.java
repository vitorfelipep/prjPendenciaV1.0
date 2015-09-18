package br.com.model;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter{
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	FilterChain chain)
	throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
	
		Boolean userSession = req.getSession().getAttribute("Usuario") != null;
			if (!userSession && !req.getRequestURL().toString().contains("index.jsf")){
				resp.sendRedirect("home.jsf");  
			} else {

		           try {  
		               chain.doFilter(request, response);  
		           } catch (Exception e) {  
		               e.printStackTrace();  
		           }    
			}
			
//			HttpSession sess = ((HttpServletRequest) request).getSession(true);
//			String newCurrentPage = ((HttpServletRequest) request).getServletPath();
//			
//			if (sess.getAttribute("currentPage") == null) { 
//				sess.setAttribute("lastPage", newCurrentPage); 
//				sess.setAttribute("currentPage", newCurrentPage); 
//				
//				System.out.println(sess);
//				
//			} else { String oldCurrentPage = sess.getAttribute("currentPage").toString(); 
//				if (!oldCurrentPage.equals(newCurrentPage)) { 
//					sess.setAttribute("lastPage", oldCurrentPage); 
//					sess.setAttribute("currentPage", newCurrentPage); 
//				} 
//			}
//		 chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}
}
