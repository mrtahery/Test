package com.demo.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.pojo.Clients;

public class Login_Model {

	public String do_login_process(String username, String password) {
		try {
			Database_connectivity dc = new Database_connectivity();
			Statement statement = dc.do_db_connection();
			String sql = "select count(*) from clients where username= '" + username + "' and password = '" + password
					+ "'";
			ResultSet rs = statement.executeQuery(sql);
			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			if (count == 1) {
				return "login success";

			} else {
				return "Username or Password doesn't match";
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "Something went wrong";
		}
	}

	public String doHibernateLogin(String username, String password) {
		try {

			Session session = HibernateConnection.doHibernateConnection().openSession();
			// session.beginTransaction();
			String queryString = "from Clients where username = ? and password = ?";
			Query query = session.createQuery(queryString);
			query.setString(0, username);
			query.setString(1, password);

			List<Clients> clients = (List<Clients>) query.list();
			session.close();
			if (clients.size() == 1) {
				return "login success";

			} else {
				return "Username or Password doesn't match";
			}

		} catch (Exception e) {
			System.err.println("error is :" + e.getMessage());
			return "Something went wrong";
		}
	}

}
