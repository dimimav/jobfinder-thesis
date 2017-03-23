package com.jobfinder.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.RoleDAO;
import com.jobfinder.model.Role;
import com.jobfinder.service.RoleService;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role,Integer> implements RoleService{

	private RoleDAO roleDAO;
	
	public RoleServiceImpl(){
		
	} 
	
	@Autowired
	public RoleServiceImpl(@Qualifier("roleDAOImpl") GenericDAO<Role,Integer> genericDAO){
		super(genericDAO);
		this.roleDAO = (RoleDAO) genericDAO;
	}

	@Override
	@Transactional
	public Role getRoleByName(String name) {
		return roleDAO.getRoleByName(name);
	}
}
