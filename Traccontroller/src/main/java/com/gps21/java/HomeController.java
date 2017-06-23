package com.gps21.java;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.gps21.model.Changepassword;

import com.gps21.Services.UserService;
import com.gps21.model.Users;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("username")
public class HomeController {

	private UserService uservice;

	@Autowired
	public void HomeController(UserService uservice) {

		this.uservice = uservice;
	}

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

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String loginresult(@ModelAttribute("userlog") Users userlog,
			ModelMap map, HttpSession session) throws NullPointerException,
			Exception {
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession sessions) throws Exception {

		if (model.containsAttribute("username"))
			model.asMap().remove("username");
		sessions.invalidate();
		System.out.println("logout");
		return "redirect:login";
	}

	@RequestMapping(value = "/updatepassword", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	String updatepassword(@RequestBody Changepassword users, ModelMap map)
			throws JSONException, NullPointerException, JsonGenerationException {

		System.out.println("Updatedpassword" + users.getConfirmpassword() + "-"
				+ users.getExistedpassword() + "-" + users.getNewpassword()
				+ "--" + users.getUsername());

		String message = uservice.updatepassword(users);

		users.setMessage(message);

		System.out.println("return value->" + message + "--"
				+ users.getMessage());

		map.addAttribute("messagee", message);
		return "updatepassword";
	}

}
