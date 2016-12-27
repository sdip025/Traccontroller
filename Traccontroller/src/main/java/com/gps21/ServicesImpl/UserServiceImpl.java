package com.gps21.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gps21.Services.UserService;
import com.gps21.dao.Userdao;
import com.gps21.model.Position;

public class UserServiceImpl implements UserService {
     
	
	@Autowired
	private Userdao udo;
	
	
	
	@Override
	public List<Position> list() {
		// TODO Auto-generated method stub
		return udo.list();
	}

}
