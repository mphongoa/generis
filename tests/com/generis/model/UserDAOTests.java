package com.generis.model;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTests {

	UserDAO userDAO = new UserDAO();
	final int ID = 1;
	
	@Test
	public void test1Save() {
		User user = new User();
		user.setDisplayName("Thabo Lebese");
		user.setEmail("thabo@gmail.com");
		user.setPassword("111111");
		userDAO.save(user);
		assertTrue(user.getId() > 0);
	}

	@Test
	public void test2GetByID() {
		User user = userDAO.get(ID);
		assertEquals(user.getId(), ID);
	}

	@Test
	public void test3GetByEmail() {
		String email = "thabo@gmail.com";
		User user = userDAO.get(email);
		assertEquals(user.getEmail(), email);
	}

	@Test
	public void test4Update() {
		User user = userDAO.get(ID);
		assertEquals("1st ensure that user is Thabo Lebese", 
				"Thabo Lebese", user.getDisplayName());
		String newName = "Lerato Lebese";
		user.setDisplayName(newName);
		assertEquals(newName, user.getDisplayName());
	}

	@Test
	public void test5List() {
		List<User> users = userDAO.list();
		assertTrue(users.size() >= 1);
	}
	
	@Test
	public void test6Delete() {
		
	}

}
