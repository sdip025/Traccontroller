package com.gps21.Services;

import com.gps21.model.Changepassword;
import com.gps21.model.Users;

public interface UserService {

	public Users userauthentication(String login, String password);
	public String updatepassword(Changepassword users);

}
