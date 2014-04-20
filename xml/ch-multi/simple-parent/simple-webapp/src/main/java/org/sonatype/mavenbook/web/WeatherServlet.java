package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;
import java.io.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WeatherServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
		//out.println(request);
	String Zipcode = request.getParameter("zip" );
	String regex = "[0-9]+"; 
	if((Zipcode.length() == 5) && (Zipcode.matches(regex)))
	{
		WeatherService weatherService = new WeatherService();
		PrintWriter out = response.getWriter();
        try {
				if(weatherService.retrieveForecast( Zipcode ) == null)
				{
					out.println("Data not available for " + Zipcode);
				}
				else
				{
					out.println( weatherService.retrieveForecast( Zipcode ) );
				}
			
		} catch( Exception e ) {
			out.println( "Error Retrieving Forecast: " + e.getMessage() );
		}
			out.flush();
			out.close();
	
	} else {
	PrintWriter out = response.getWriter();
	out.println( "Invalid Zipcode format! Only five digit numbers. Retry!");
	}	
		
    }
}