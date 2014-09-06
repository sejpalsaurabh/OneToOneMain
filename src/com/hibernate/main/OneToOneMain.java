package com.hibernate.main;

import org.hibernate.Session;

import com.hibernate.model.User;
import com.hibernate.model.UserDetails;
import com.hibernate.util.HibernateUtil;

public class OneToOneMain {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		
		session.beginTransaction();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setAddress("150ft Ring Road");
		userDetails.setCity("Rajkot");
		userDetails.setState("Gujarat");
		
		User user = new User();
		user.setFirstName("Saurabh");
		user.setLastName("Sejpal");
		user.setUserDetails(userDetails);
		
		userDetails.setUser(user);
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();

	}

}
