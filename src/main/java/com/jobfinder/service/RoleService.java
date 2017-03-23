package com.jobfinder.service;

import com.jobfinder.model.Role;

public interface RoleService extends GenericService<Role,Integer> {
	
	public Role getRoleByName(String name);

}
