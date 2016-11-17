package com.generis.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTests {

	UserDAO userDAO = new UserDAO();
	
	@Test
	public void testSave() {
		User user = new User();
		user.setDisplayName("Thabo Lebese");
		user.setEmail("thabo@gmail.com");
		user.setPassword("111111");
		userDAO.save(user);
		assertEquals(user.getId(), 1);
	}

	@Test
	public void testGetByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testList() {
		fail("Not yet implemented");
	}

}
