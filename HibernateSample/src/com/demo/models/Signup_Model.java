package com.demo.models;

import java.sql.Statement;

import org.hibernate.Session;

import com.demo.pojo.Clients;

public class Signup_Model {

	public String doSignUp(String username, String password, String gender, String vehicle, String country,
			String image) {
		try {
			Database_connectivity dc = new Database_connectivity();
			Statement statement = dc.do_db_connection();
			String sql = "insert into clients values('" + username + "' , '" + password + "' ,'" + gender + "' , '"
					+ vehicle + "' , '" + country + "' , '" + image + "')";
			statement.executeQuery(sql);

			return "Sing up successfully ...";
		} catch (Exception e) {
			System.err.println(e);
			return "Something went wrong";
		}
	}
	
	public String doHibernateSignUp(Clients clients)
	{
		try {
			
			HibernateConnection.doHibernateConnection();
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			session.save(clients);
			session.getTransaction().commit();

			session.close();
			return "Sing up successfully ...";
			
			
		} catch (Exception e) {
			System.err.println("doHibernateSignUp error :" + e);
			return "Something went wrong";
		}
		
	}

}
