package com.jobfinder.dao;

import com.jobfinder.model.Role;

public interface RoleDAO extends GenericDAO<Role,Integer>{
	
	public Role getRoleByName(String name);

}
