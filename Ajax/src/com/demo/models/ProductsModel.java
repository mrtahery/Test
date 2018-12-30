package com.demo.models;

import java.util.List;

import org.hibernate.Session;

import com.demo.pojo.*;

public class ProductsModel {

	public List<Products> getAllProducts() {
		Session session = HibernateConnection.doHibernateConnection().openSession();

		List<Products> allProducts = (List<Products>) session.createQuery("From Products").list();
		session.close();
		return allProducts;
	}

	public boolean deleteProductById(String id) {
		try {
			Session session = HibernateConnection.doHibernateConnection().openSession();
			session.beginTransaction();
			Products product = (Products) session.get(Products.class, Integer.parseInt(id));
			
			if (product != null)
			{
				session.delete(product);
				session.getTransaction().commit();
				
			}
			else
			{
				System.err.print("There is no product with this id : " + Integer.parseInt(id));
				return false;
			}
			session.close();
			return true;
		}

		catch (Exception e) {
			System.err.print("Error : " + e.getMessage());
			return false;
		}
	}

}
