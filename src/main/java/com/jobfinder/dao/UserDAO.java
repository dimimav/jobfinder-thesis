package com.jobfinder.dao;

import com.jobfinder.model.User;

public interface UserDAO extends GenericDAO<User,Integer>{
	 
	public User findByUsername(String uname); 
	
	public User save(User user);

}
