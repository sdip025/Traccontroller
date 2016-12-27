package com.gps21.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.dao.Userdao;
import com.gps21.model.Position;

@Repository
@Transactional
public class Daoimpl implements Userdao {
	
	@Autowired
        private	SessionFactory session;

	
	
	@Override
	public List<Position> list() {
		// TODO Auto-generated method stub
		List<Position> plist=session.getCurrentSession().createQuery("from positions").list();
		
		
		return plist;
	}
	

}
