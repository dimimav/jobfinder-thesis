package com.jobfinder.dao.impl;

import org.springframework.stereotype.Repository;

import com.jobfinder.dao.RoleDAO;
import com.jobfinder.model.Role;

@Repository
public class RoleDAOImpl extends GenericDAOImpl<Role,Integer> implements RoleDAO{

	@Override
	public Role getRoleByName(String name) {
		String hql = "from Role where name = :name ";
		return (Role) getSession().createQuery(hql).setParameter("name", name).uniqueResult();
	}
}
