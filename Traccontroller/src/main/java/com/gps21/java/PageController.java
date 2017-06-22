package com.gps21.java;

import java.util.Locale;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/* Page Routing */

	@RequestMapping(value = "/account")
	public String account() {

		return "account";

	}

	@RequestMapping(value = "/message")
	public String Message() {

		return "message";
	}

	/*@RequestMapping(value = "/changepassword")
	public String Changepassword() {

		return "changepassword";
	}*/

	@RequestMapping(value = "/monitor")
	public String Monitor() {

		return "monitor";
	}

	@RequestMapping(value = "/statistics")
	public String Statistics() {

		return "statistics";
	}

	@RequestMapping(value = "/more")
	public String More() {

		return "more";
	}

	@RequestMapping(value = "/testa")
	public String Test() {

		return "testa";
	}

}
