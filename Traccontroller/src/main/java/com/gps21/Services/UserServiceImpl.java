package com.gps21.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.Services.UserService;
import com.gps21.dao.Userdao;
import com.gps21.model.Positions;


@Service
@Transactional 
public class UserServiceImpl implements UserService {
  
	@Autowired
	private Userdao udo;

	@Override
	@Transactional
	public List<Positions> plist() {
		return udo.plist();
	}

}
