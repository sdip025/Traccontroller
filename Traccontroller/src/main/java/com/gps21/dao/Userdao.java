package com.gps21.dao;

import java.util.List;

import com.gps21.model.Device;
import com.gps21.model.Positions;
import com.gps21.model.User;

public interface Userdao {

	public List<Positions> plist();

	public List<User> ulist();

	public User userauthentication(String login, String password);

	public List<Device> dlist(String uname);

}
