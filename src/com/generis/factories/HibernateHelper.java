package com.generis.factories;

import org.hibernate.cfg.Configuration;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.apache.log4j.Logger;

public class HibernateHelper {

//	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
//	private static final ThreadLocal transaction = new ThreadLocal();
	@SuppressWarnings("deprecation")
	private static final SessionFactory sessionFactory =
	                   new Configuration().
	                   configure("com/factories/hibernate.cfg.xml")
	                   	.buildSessionFactory();

	//inaccessible constructor
	private HibernateHelper() {
	}

//	public static Session getSession() {
//		Session session = HibernateHelper.session.get();
//		if (session == null) {
//			session = sessionFactory.openSession();
//			HibernateHelper.session.set(session);
//		}
//		return session;
//	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
