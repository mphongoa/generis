package com.generis.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.generis.factories.HibernateHelper;
import com.generis.model.User;

public class UserDAO {
	
	private Session session = HibernateHelper.getSession();
	private Logger logger = LogManager.getLogger(this.getClass());

	public void save(User user) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} 
		catch(HibernateException ex){
			try {
				tx.rollback();
			} catch (Exception e) {
				logger.error("Unable to rollback transaction: ", e);
			}
			logger.error("Error Saving User object: ", ex);
		}
		catch (Exception ex) {
			logger.error("Error Saving User object: ", ex);
		}
	}
	
	public User get(int id) {
		User user = null;
		Session session = HibernateHelper.getSession();
		try{
			String strQuery = "from User user" +
					" where user.id = :id";
			Query query = session.createQuery(strQuery);
			query.setInteger("id", id);
			user = (User) query.list().get(0);
		}
		catch(Exception ex){
			logger.error("Error retrieving User object: "+ ex);
		}
		finally{
			session.close();
		}

		return user;
	}

	public User get(String email){
		User user = null;
		try {
			String queryString = "from User";
			Query query = session.createQuery(queryString);
			user = (User) query.list().get(0);
		}
		catch(Exception ex){
			logger.error("Error retrieving User object: "+ ex);
		}
		finally{
			session.close();
		}

		return user;
	}

	
	public void update(User user) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} 
		catch(HibernateException ex){
			try {
				tx.rollback();
			} catch (Exception e) {
				logger.error("Unable to rollback transaction: ", e);
			}
			logger.error("Error Saving User object: ", ex);
		}
		catch (Exception ex) {
			logger.error("Error Saving User object: ", ex);
		}
	}
	
	public void delete(User user) {
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
		}
		catch(HibernateException ex){
			try {
				tx.rollback();
			} catch (Exception e) {
				logger.error("Unable to rollback transaction: "+ e);
			}
			logger.error("Error deleting User object: "+ ex);
		}
		catch (Exception ex) {
			logger.error("Error deleting User object: "+ ex);
		}
		finally{
			session.close();
		}
	}
	
	public List<User> list(){
		try {
			Query query = session.createQuery("from User");
			return query.list();
		}
		catch(Exception ex){
			logger.error("Error retrieving User object: "+ ex);
		}
		finally{
			session.close();
		}

		return null;
	}
}
