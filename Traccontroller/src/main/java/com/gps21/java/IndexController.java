package com.gps21.java;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class IndexController extends UrlController {
	
    @RequestMapping(value="/userlist",method=RequestMethod.GET)
	public String userlist(ModelMap model , HttpServletRequest request){
		model.addAttribute(Baseurl, getBaseUrl(request));
		return "positionlist";
	} 
		

}
