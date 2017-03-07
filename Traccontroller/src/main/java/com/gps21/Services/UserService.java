package com.gps21.Services;

import java.util.ArrayList;
import java.util.List;






import com.gps21.model.Device;
import com.gps21.model.Positions;
import com.gps21.model.User;



public interface UserService {
	public List<Positions>plist();
	public List<User>ulList();
	public User userauthentication(String login, String password);
	public ArrayList<Device>dlist(String uname);

}
