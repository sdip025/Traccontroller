package com.gps21.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gps21.model.Devices;
import com.gps21.model.Home;
import com.gps21.Services.UserService;
import com.gps21.model.Users;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("username")
@EnableWebMvc
public class HomeController {

	@Autowired
	UserService uservice;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	Boolean logresult = false;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginpage() {

		return "login";
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public String redirect() {

		return "redirect:locationpage";
	}

	@RequestMapping(value = "/locationpage", method = RequestMethod.GET)
	public String locationpage(Model model) {

		model.addAttribute("latlong", uservice.plist());

		return "location";
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public String loginresult(@ModelAttribute("userlog") Users userlog,
			ModelMap map, HttpSession session) {
		System.out.println("controller read " + userlog.getLogin() + " "
				+ userlog.getPassword());
		if (uservice.userauthentication(userlog.getLogin(),
				userlog.getPassword()) != null) {

			map.addAttribute("username", userlog.getLogin());

			return "home";

		}

		else {
			System.out.println("cannot read " + userlog.getLogin() + " "
					+ userlog.getPassword());

			System.out.println("cannot read userauthentication "
					+ uservice.userauthentication(userlog.getPassword(),
							userlog.getLogin()));
			map.put("errormessage", "Invalid Account");
			return "login";
		}
	}

	/*@RequestMapping(value = "/position", method = RequestMethod.GET,produces="application/json")
	public HashMap<String,List<Devices>> devicelist(HttpSession session) {
		String username=(String)session.getAttribute("username");
		System.out.println(username);

		return uservice.devicelist(username);
	}*/

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession sessions) {
		// sessions.removeAttribute("username");
		if (model.containsAttribute("username"))
			model.asMap().remove("username");
		sessions.invalidate();
		System.out.println("logout");
		return "redirect:login";
	}
   
	@RequestMapping(value="/changepassword",method=RequestMethod.POST)
	public String changepassword(@Valid @ModelAttribute("home") Home home,BindingResult res){
		
		if (res.hasErrors()) {
			System.out.println("ChangePassword" +home.getConfirmpassword());
			
			
			
		}
		
	
		
		
		return "home";	
	}
	
	
	
	
	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/position", method = RequestMethod.GET, produces
	 * = "application/json") public List<Positions> getlocation() { return
	 * uservice.plist(); }
	 */

	/*@ResponseBody
	@RequestMapping(value = "/dlist", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<Devices> devicelist(HttpSession session) {

		String uname = (String) session.getAttribute("username");
		System.out.print("Session Value" + uname);
		return uservice.dlist(uname);
	}*/

	/*
	 * @RequestMapping(value="/dlist" , method=RequestMethod.POST ) public
	 * String userdevice(@ModelAttribute("Uname") Device dev){
	 * 
	 * 
	 * 
	 * 
	 * return"home"; }
	 */

}
