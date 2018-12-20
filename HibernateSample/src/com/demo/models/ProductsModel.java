package com.demo.models;

import java.util.List;

import org.hibernate.Session;

import com.demo.pojo.*;

public class ProductsModel {
	
	public List<Products> getAllProducts()
	{
		Session session = HibernateConnection.doHibernateConnection().openSession();
		
		List<Products> allProducts =(List<Products>) session.createQuery("From Products").list();
		session.close();
		return allProducts;
	}

}
