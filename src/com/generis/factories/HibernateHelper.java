package com.generis.factories;

import org.hibernate.cfg.Configuration;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.apache.log4j.Logger;

public class HibernateHelper {
	@SuppressWarnings("deprecation")
	private static final SessionFactory sessionFactory =
	                   new Configuration().
	                   configure("com/generis/factories/hibernate.cfg.xml")
	                   	.buildSessionFactory();
	private HibernateHelper() {
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
