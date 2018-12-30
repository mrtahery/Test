package com.demo.models;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.demo.pojo.Clients;
import com.demo.pojo.Products;

public class HibernateConnection {

	public static SessionFactory sessionFactory;

	public static SessionFactory doHibernateConnection() {
		if (sessionFactory == null) {
			Properties database = new Properties();
			database.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			database.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@127.0.0.1:1521:xe");
			database.setProperty("hibernate.connection.username", "env01");
			database.setProperty("hibernate.connection.password", "env01");
			database.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
			database.setProperty("hibernate.connection.default_schema", "env01");

			database.setProperty("hibernate.connection.pool_size", "5");
			database.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
			database.setProperty("hibernate.show_sql", "true");
			database.setProperty("hibernate.hbm2ddl.auto", "update"); 

			Configuration cfg = new Configuration().setProperties(database).addPackage("com.demo.pojo")
					.addAnnotatedClass(Clients.class).addAnnotatedClass(Products.class);

			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());

			sessionFactory = cfg.buildSessionFactory(ssrb.build());
	
		}
		return sessionFactory;


	}

}
