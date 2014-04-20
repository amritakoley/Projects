package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: FailureServ
 *
 */
 public class FailureServ extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	public FailureServ() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		System.out.println("IN FAILUESERV DOGET");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("Sorry, you have entered wrong zipcode");
	        out.println("<a href=\"FormServlet\">try again</a>");
	        out.println("</body>");
	        out.println("</html>");
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}   	  	    
}