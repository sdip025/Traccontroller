package com.gps21.DaoImpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.gps21.model.Changepassword;
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
	public List<Positions> plist() throws HibernateException,
			ClassCastException {

		List<String> list = new ArrayList<String>();
		String selectposition = " from Positions p where p.id BETWEEN  75215 and  75223";

		List<Positions> plt = session.getCurrentSession().createQuery(selectposition).list();

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
			
			
				/*
				Session se3=session.openSession();
				Long id1=(long) 22;
				Devices dee=(Devices)se3.get(Devices.class, id1);
				System.out.println("Session value2 "+dee.getName()+""+dee.getName());
				se3.close();
				Session se5=session.openSession();
				se5.beginTransaction();
				Long id5=(long) 3;
				Devices deee=(Devices)se5.get(Devices.class, id5);
				System.out.println("Session value3 "+deee.getName()+""+deee.getName());
				se5.getTransaction().commit();
				se5.close();
				Devices Deee=(Devices)se5.get(Devices.class, id5);
				System.out.println("Session value4 "+Deee.getName()+""+Deee.getName());
			*/
			

			return (Users) userlogin.uniqueResult();

		} catch (HibernateException e) {
			System.out.println("without  DAoimpl " + e + " Exception ->"
					+ e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/* Device List For Every Users. */
	@Override
	@SuppressWarnings("unchecked")
	public List<Devices> dlist(String uname) {

		
			String ldevice = " from Users u where u.login  =:username ";

			ArrayList<String> devlist = new ArrayList<String>();
			devlist.add(ldevice);
			System.out.println("  database ->");
			HashMap<String, ArrayList<String>> udevicelist = new HashMap<String, ArrayList<String>>();
			udevicelist.put(uname, devlist);

			Query que = session.getCurrentSession().createQuery(ldevice);
			que.setParameter("username", uname);

			List<Devices> devicelist = new ArrayList<Devices>();
			devicelist = que.list();
			
			for (Devices devices : devicelist) {
				
				System.out.println("devicename-->"+ devices);
			}

			return devicelist ;
			
		
		
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = { HibernateException.class,
			TransactionException.class, HibernateException.class })
	public String updatepassword(Changepassword cpw) {

		String passwordmessage = "";

		
		  System.out.println("username->" + cpw.getUsername() + "--" +
		  cpw.getConfirmpassword() + "--" + cpw.getExistedpassword());
		 
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

}
