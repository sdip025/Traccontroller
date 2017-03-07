package com.gps21.DaoImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.dao.Userdao;
import com.gps21.model.Device;
import com.gps21.model.Positions;
import com.gps21.model.User;

@Repository
public class Daoimpl implements Userdao {

	@Autowired
	private SessionFactory session;

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Positions> plist() {
  
  
		String selectposition = " from Positions p where p.id BETWEEN  75215 and  75223";

		List<Positions> plt = session.getCurrentSession()
				.createQuery(selectposition).list();
		System.out.println(plt);
		return plt;
	}

	@Override
	public List<User> ulist() {
		List<User> lognlist = new ArrayList<User>();
		String ulogin = "select u.login ,u.password from users u";
		lognlist = session.getCurrentSession().createQuery(ulogin).list();

		return lognlist;

	}

	
	                  /* Users Authentication.*/
	@Override
	public User userauthentication(String username, String password) {
		System.out.println("userauthentication" + username + " " + password);
		try {
			String ulogin = "from User u where u.username='"+username+"' and u.password='"+password+"'";

			Query userlogin = session.getCurrentSession().createQuery(ulogin);
			
			System.out.println("WithOut SetParameter" + username + " " + password);

		/*	userlogin.setParameter(0, username);

			userlogin.setParameter(1, password);*/

			return (User) userlogin.uniqueResult();

		} catch (Exception e) {
			System.out.println("without  DAoimpl");
			return null;
		}

	}
                                             /* Device List For Every Users.*/
	@Override
	@SuppressWarnings("unchecked")
	public List<Device> dlist(String uname) {
		String ldevice="select  d.name from  Device d where d.id in  ( select ud.devices_id from Userdevice ud where ud.users_id=(select u.id from User u where u.login='"+uname+"' ))";
	/*String ldevice="select  d.name from  devices d where d.id in  ( select ud.devices_id from users_devices ud where ud.users_id=(select u.id from users u where u.login='"+uname+"' ))";
	*/
		
		
		ArrayList<String>devlist=new ArrayList<String>();
		devlist.add(ldevice);
		               
		
		HashMap<String, ArrayList<String>> udevicelist=new HashMap<String, ArrayList<String>>();
		udevicelist.put(uname, devlist);
		
		List<Device> devicelist=new ArrayList<Device>();
		devicelist=session.getCurrentSession().createQuery(ldevice).list();
	
		
		
		return devicelist ;
	}

}
