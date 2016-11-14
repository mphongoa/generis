/**
 * 
 */
package com.generis.factories;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Geeflash
 *
 */
public class EmailHelper {

	private static Logger logger = LogManager.getLogger(EmailHelper.class);
	
	private EmailHelper(){
	}
	
	public static Session getSenderSession(){
		return getSenderSession("smtp.gmail.com", "campaign.g@gmail.com", "i love java more");
	}
	
	public static Store getEmailStore(String host, final String user, final String password) throws MessagingException{
		Session session = getReceiverSession(host, user, password);
		Store store = session.getStore("imaps");
		store.connect(host, user, password);
		return store;
	}
	
	public static Session getSenderSession(String host, final String user, final String password){
		Session session = null;
		logger.info("Creating email session for sending, host: "+ host +", user: "+ user+ ", password: ******");
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		return session;
	}
	
	private static Session getReceiverSession(String host, final String user, final String password){
		Session session = null;
		logger.info("Creating email session for receiving, host: "+ host +", user: "+ user+ ", password: ******");
		Properties props = new Properties();
		
		props.setProperty("mail.host", "imap.gmail.com");
		props.setProperty("mail.port", "993");
		props.setProperty("mail.transport.protocol", "imaps");

		session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		return session;
	}
}
