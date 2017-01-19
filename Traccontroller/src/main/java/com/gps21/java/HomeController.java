package com.gps21.java;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.List;

import org.json.JSONArray;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.gps21.Services.UserService;
import com.gps21.model.Positions;
import com.gps21.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@EnableWebMvc
public class HomeController {

	@Autowired
	UserService uservice;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	return "home";

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

	@ResponseBody
	@RequestMapping(value = "/position", method = RequestMethod.GET, produces = "application/json")
	public List<Positions> getlocation() {
		return uservice.plist();
	}

}
