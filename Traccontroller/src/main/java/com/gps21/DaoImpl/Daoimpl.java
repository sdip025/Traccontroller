package com.gps21.DaoImpl;

import java.util.List;




import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.dao.Userdao;
import com.gps21.model.Positions;

@Repository

public class Daoimpl implements Userdao {
	
	@Autowired
   private SessionFactory session;
   
	
	@Override
	@Transactional
	public List<Positions>plist() {
		
		@SuppressWarnings("unchecked")
		String selectposition="from Positions pn where pn=20";
		
		List<Positions> plt=session.getCurrentSession().createQuery(selectposition).list();
		
	return plt;
	}
	

}
