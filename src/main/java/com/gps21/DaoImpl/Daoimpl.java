package com.gps21.DaoImpl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gps21.model.Changepassword;
import com.gps21.model.Devicedetails;
import com.gps21.model.Devices;
import com.gps21.model.Users;
import com.gps21.Services.Devicedetls;
import com.gps21.dao.Userdao;
import com.gps21.model.Positions;

@Repository
public class Daoimpl implements Userdao {

	@Autowired
	private SessionFactory session;

	@Override
	@Transactional
	public List<Positions> plist() throws HibernateException,
			ClassCastException {

		List<String> list = new ArrayList<String>();
		String selectposition = " from Positions p where p.id BETWEEN  75215 and  75223";

		List<Positions> plt = session.getCurrentSession()
				.createQuery(selectposition).list();

		System.out.println("Position" + selectposition);

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
	public List<Devices> dlist(String uname) {

		/*
		 * String ldevice =
		 * "select d.name from Users u join u.deviceses_1 d  where u.login  =:username "
		 * ;
		 */

		Query que = session.getCurrentSession().getNamedQuery(
				"Devicelist.Byuname");
		que.setParameter("username", uname);
		que.setCacheable(true);

		List<Devices> devicelist = new ArrayList<Devices>();
		devicelist = que.list();

		return devicelist;

	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = { HibernateException.class,
			TransactionException.class, HibernateException.class })
	public String updatepassword(Changepassword cpw) {

		String passwordmessage = "";

		System.out.println("username->" + cpw.getUsername() + "--"
				+ cpw.getConfirmpassword() + "--" + cpw.getExistedpassword());

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

			// System.out.println("hello->  " +
			// pw+"  "+cpw.getExistedpassword());
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
	public HashMap<String, Devicedetails> devicedetails(String uname) {

		HashMap<String, Devicedetails> ddetais = new HashMap<String, Devicedetails>();
		List<String> devicelist = new ArrayList<String>();
		List<String> ddetails = new ArrayList<String>();
		List<String> deviceposition = new ArrayList<String>();
		String devicename = "";
		Query que = session.getCurrentSession().getNamedQuery(
				"Devicelist.Byuname");
		que.setParameter("username", uname);

		devicelist = que.list();

		for (String dname : devicelist) {

			String detailsposition = "select p.latitude,p.longitude from Devices d  join d.positions p where d.name =:devicename";
			Query detailsfromposition = session.getCurrentSession()
					.createQuery(detailsposition);

			detailsfromposition.setParameter("devicename", dname);
			devicename = dname;
			ddetails = detailsfromposition.list();
			deviceposition = ddetails;

		}

		System.out.println("List Value" + devicelist + "Device Details"
				+ ddetails);

		Devicedetails devdetails = new Devicedetails(uname, uname, uname,
				uname, uname, uname, uname, null, null, null, null);

		ddetais.put(devicename, devdetails);

		return ddetais;

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

				System.out.println("Device name and details " + dname + " lat "
						+ lat + "longitude" + longitude + "Array" + latlong);

			}
			ddetais.put(dname, latlong);
		}

		return ddetais;
	}

	@Override
	public HashMap<String, String[]> updateposition(String devicename) {

		HashMap<String, String[]> udetails = new HashMap<String, String[]>();

		String uddetails[] = new String[7];

		/* try { */

		String updetails = "select p.address,p.speed,p.latitude,p.longitude from Devices d  join d.positions p where d.name =:devicename";
		String uid = "select  d.uniqueId,d.status,d.lastupdate  from Devices d where d.name=:deviceuid";

		Query que = session.getCurrentSession().createQuery(updetails);

		Query uiddue = session.getCurrentSession().createQuery(uid);

		que.setParameter("devicename", devicename);
		uiddue.setParameter("deviceuid", devicename);

		List<Object[]> details = (List<Object[]>) que.list();
		List<Object[]> uidlist = (List<Object[]>) uiddue.list();

		for (Object[] i : uidlist) {
               
			String uniqueid=(String)i[0];
			String status=(String)i[1];
			Timestamp t=(Timestamp)i[2];
			String lastupdate=t.toString();
			uddetails[0]=uniqueid;
			uddetails[2]=status;
			uddetails[4]=lastupdate;
		}

		for (Object[] a : details) {
			Double d = (Double) a[1];
			String speed = d.toString();
			String address = (String) a[0];

			Double lat = (Double) a[2];
			Double lng = (Double) a[3];
			String lati = lat.toString();
			String lngi = lng.toString();

			uddetails[1] = address;
			uddetails[3] = speed;
			
			uddetails[5] = lati;
			uddetails[6] = lngi;
		}

		udetails.put(devicename, uddetails);
		return udetails;

		/*
		 * } catch (Exception e) { // TODO: handle exception return udetails; }
		 */

	}
}
