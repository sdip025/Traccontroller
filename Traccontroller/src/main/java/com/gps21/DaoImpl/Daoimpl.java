package com.gps21.DaoImpl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.model.Devices;
import com.gps21.model.Users;
import com.gps21.dao.Userdao;
import com.gps21.model.Positions;


@Repository
public class Daoimpl implements Userdao {

	@Autowired
	private SessionFactory session;

	@Override
	@Transactional
	
	public List<Positions> plist() {

		String selectposition = " from Positions p where p.id BETWEEN  75215 and  75223";

		List<Positions> plt = session.getCurrentSession()
				.createQuery(selectposition).list();
		System.out.println(plt);
		return plt;
	}

	@Override
	public List<Users> ulist() {
		List<Users> lognlist = new ArrayList<Users>();
		String ulogin = "select u.login ,u.password from Users u";
		lognlist = session.getCurrentSession().createQuery(ulogin).list();

		return lognlist;

	}

	/* Users Authentication. */
	@Override
	public Users userauthentication(String username, String password) {
		System.out.println("userauthentication" + username + " " + password);
		try {
			String ulogin = "from Users u where u.login='" + username
					+ "' and u.password='" + password + "'";

			Query userlogin = session.getCurrentSession().createQuery(ulogin);

			System.out.println("Try Block" + username + " " + password + " "
					+ (Users) userlogin.uniqueResult());


			return (Users) userlogin.uniqueResult();

		} catch (Exception e) {
			System.out.println("without  DAoimpl " + e + " Exception ->"
					+ e.getMessage());
			return null;
		}

	}

	/* Device List For Every Users. */
	@Override
	@SuppressWarnings("unchecked")
	public List<Devices> dlist(String uname) {
		String ldevice = "select  d.name from  devices d where d.id in  ( select ud.devices_id from users_devices ud where ud.users_id=(select u.id from users u where u.login='"
				+ uname + "' ))";
		

		ArrayList<String> devlist = new ArrayList<String>();
		devlist.add(ldevice);

		HashMap<String, ArrayList<String>> udevicelist = new HashMap<String, ArrayList<String>>();
		udevicelist.put(uname, devlist);

		List<Devices> devicelist = new ArrayList<Devices>();
		devicelist = session.getCurrentSession().createQuery(ldevice).list();

		
		return devicelist;
	}

	

}
