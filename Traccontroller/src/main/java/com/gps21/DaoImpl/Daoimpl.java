package com.gps21.DaoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.model.Changepassword;
import com.gps21.model.Deviceproperties;

import com.gps21.model.Statistics;
import com.gps21.model.Userinput;
import com.gps21.model.Users;
import com.gps21.dao.Userdao;
import com.gps21.model.Positions;

@Repository
public class Daoimpl implements Userdao {

	@Autowired
	private SessionFactory session;

	/* Users Authentication. */
	@Override
	public Users userauthentication(String username, String password) {
		System.out.println("userauthentication" + username + " " + password);
		try {
			String ulogin = "  from Users u where u.login='" + username
					+ "' and u.password='" + password + "'";

			Query userlogin = session.getCurrentSession().createQuery(ulogin);

			System.out.println("Try Block" + username + " " + password + " "
					+ (Users) userlogin.uniqueResult());

			return (Users) userlogin.uniqueResult();

		} catch (HibernateException e) {
			System.out.println("without  DAoimpl " + e + " Exception ->"
					+ e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/* Device List For an Users. */

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = { HibernateException.class,
			TransactionException.class, HibernateException.class })
	public String updatepassword(Changepassword cpw) {

		String passwordmessage = "";

		try {

			String selectpassword = "select  u.password from Users u where u.login= :username";

			Query que = session.getCurrentSession().createQuery(selectpassword);
			que.setParameter("username", cpw.getUsername());

			List<String> changepassword = (List<String>) que.list();

			Iterator<String> ite = changepassword.iterator();
			String pw = "";

			while (ite.hasNext()) {

				pw = (String) ite.next();

			}

			if (pw.equals(cpw.getExistedpassword())) {
				try {
					String updatepassword = "update  Users u set u.password=:password where  u.login=:username";

					Query updateque = session.getCurrentSession().createQuery(
							updatepassword);
					updateque.setParameter("username", cpw.getUsername());
					updateque
							.setParameter("password", cpw.getConfirmpassword());

					String password = updateque.getQueryString();
					int res = updateque.executeUpdate();
					System.out.println("104 database value" + password + "  "
							+ res);
					passwordmessage = "Password Update Successfully ";

				} catch (Exception e) {
					System.out.println("Update" + e);
				}

			} else {

				passwordmessage = "Can Not Update Password";
				System.out.println("Password Not Matched");

			}

			return passwordmessage;

		} catch (Exception e) {
			passwordmessage = "Some error in update";
			System.out.println("Exception" + e);
			return passwordmessage + e;
		}

	}

	public List<Users> changepassword(String uname) {
		List<Users> changepasswordd = new ArrayList<Users>();

		try {

			String selectpassword = "select u.password from Users u where u.login= :username";

			Query que = session.getCurrentSession().createQuery(selectpassword);
			que.setParameter("username", "admindevice");
			List<String> changepassword = (List<String>) que.list();

			Iterator<String> ite = changepassword.iterator();
			String pw = "";

			while (ite.hasNext()) {

				pw = (String) ite.next();

				// Users users = ite.next();

			}

			System.out.println("hello" + pw);

		} catch (Exception e) {
			System.out.println("Error" + e);
			System.out.println(e);
		}
		return changepasswordd;

	}

	@Override
	public HashMap<String, String[]> deviceposition(String uname)
			throws HibernateException, HibernateQueryException {

		HashMap<String, String[]> ddetais = new HashMap<String, String[]>();
		List<String> devicelist = new ArrayList<String>();

		List<Long> did = new ArrayList<Long>();
		String devicename = "";
		Query que = session.getCurrentSession().getNamedQuery(
				"Devicelist.Byuname");
		que.setParameter("username", uname);
		devicelist = que.list();
		System.out.println("List device name" + devicelist);

		for (String dname : devicelist) {

			Query detailsfromposition = session.getCurrentSession()
					.getNamedQuery("Device.id");
			detailsfromposition.setParameter("devicename", dname);
			did = detailsfromposition.list();

			String[] latlong = new String[3];
			for (Long id : did) {
				Positions pos = (Positions) session.getCurrentSession().load(
						Positions.class, id);
				Double lat = pos.getLatitude();
				Double longitude = pos.getLongitude();
				latlong[0] = dname;
				latlong[1] = lat.toString();
				latlong[2] = longitude.toString();
/*
				System.out.println("Device name and details " + dname + " lat "
						+ lat + "longitude" + longitude + "Array" + latlong);*/

			}
			ddetais.put(dname, latlong);
		}

		return ddetais;
	}

	@Override
	public  Deviceproperties updateposition(
			Userinput devicename) {

		Deviceproperties dproperties = new Deviceproperties();
		HashMap<Userinput, Deviceproperties> udetails = new HashMap<Userinput, Deviceproperties>();
		String dname = devicename.getSelecteddevice();
		try {

			String updetails = "select p.address,p.speed,p.latitude,p.longitude from Devices d  join d.positions p where d.name =:devicename";
			String uid = "select  d.uniqueId,d.status,d.lastupdate  from Devices d where d.name=:deviceuid";

			Query que = session.getCurrentSession().createQuery(updetails);
			que.setParameter("devicename", dname);

			Query uiddue = session.getCurrentSession().createQuery(uid);
			uiddue.setParameter("deviceuid", dname);
			dproperties.setDname(dname);

			List<Object[]> details = (List<Object[]>) que.list();
			List<Object[]> uidlist = (List<Object[]>) uiddue.list();

			for (Object[] i : uidlist) {

				Timestamp t = (Timestamp) i[2];
				dproperties.setImei((String) i[0]);

				dproperties.setStatus((String) i[1]);
				dproperties.setLastupdate(t.toString());

			}

			for (Object[] a : details) {

				dproperties.setSpeed((Double) a[1]);
				dproperties.setAddress((String) a[0]);

				dproperties.setLatitude((Double) a[2]);
				dproperties.setLongitude((Double) a[3]);

			}

			udetails.put(devicename, dproperties);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dproperties;
	}

	@Override
	public Statistics mileagereport(Userinput userinput) {
		Statistics milagereport = new Statistics();

		return null;
	}
}
