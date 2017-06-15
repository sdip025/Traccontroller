package com.gps21.java;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gps21.Services.Devicedetails;
import com.gps21.model.Deviceproperties;
import com.gps21.model.Statistics;
import com.gps21.model.Userinput;

@Controller
public class DeviceController {

	private Devicedetails devicedetails;

	@Autowired
	public DeviceController(Devicedetails devicedetails) {
		this.devicedetails = devicedetails;

	}

	@ResponseBody
	@RequestMapping(value = "/devicedetails", method = RequestMethod.GET, produces = "application/json")
	public HashMap<String, String[]> devicedetails(HttpSession session) {

		String uname = (String) session.getAttribute("username");

		return devicedetails.deviceposition(uname);
	}

	@ResponseBody
	@RequestMapping(value = "/sddetails", method = RequestMethod.POST, produces = "application/json")
	public  Deviceproperties selectdevicename(
			@RequestBody Userinput userinput) {

		String devicename = userinput.getSelecteddevice();
		Deviceproperties dev=devicedetails
				.updateposition(userinput);
		System.out.println("Position details" + devicename+dev.getImei());
		/*HashMap<Userinput, Deviceproperties> devdetails = devicedetails
				.updateposition(userinput);

		for (Map.Entry<Userinput, Deviceproperties> dprop : devdetails
				.entrySet()) {
			Userinput uiput = dprop.getKey();
			Deviceproperties dp = dprop.getValue();
			System.out.println("Key" + uiput.getSelecteddevice());
			System.out.println(dp.getAddress() + dp.getLastupdate()
					+ dp.getLatitude() + dp.getLongitude());

		}*/

		return devicedetails
				.updateposition(userinput);
	}

	@ResponseBody
	@RequestMapping(value = "/mileagereport", method = RequestMethod.POST, produces = "application/json")
	public Statistics milagereport(@RequestBody Userinput userinput) {
		
		System.out.println(userinput.getDevicename());
		
		SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	String abcd=sdf.format(userinput.getFdata());
	System.out.println(abcd);
		
		
		System.out.println(userinput.getTdate());
		System.out.println(userinput.getGivenfuelconsumption());

		return null;
	}

}
