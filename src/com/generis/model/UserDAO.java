package com.generis.model;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private List<User> users = new ArrayList<>();
	
	public void save(User user){
		users.add(user);
	}
	
	public User get(int id){
		return users.get(id);
	}
	
	public void update(User user){
		users.set(user.getId(), user);
	}
	
	public void delete(User user){
		users.remove(user.getId());
	}
	
	public List<User> list(){
		return users;
	}
}
