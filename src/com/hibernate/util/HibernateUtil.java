package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();		
		return configuration.buildSessionFactory(serviceRegistry);
	}
	
	/*Closing the SessionFactory Object*/
	public static void closeSessionFactory() {		
		getSessionfactory().close();
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	

}
