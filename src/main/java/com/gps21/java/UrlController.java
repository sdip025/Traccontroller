package com.gps21.java;


import javax.servlet.http.HttpServletRequest;

public class UrlController {
 
	public static final String Baseurl="http://localhost:8080/java/";
	
	
	
	public String getBaseUrl(HttpServletRequest request){
   
		return request.getScheme()+"://" + request.getServerName()+":"+ request.getServerPort()+request.getContextPath();
	}
	
	
	
	
}
