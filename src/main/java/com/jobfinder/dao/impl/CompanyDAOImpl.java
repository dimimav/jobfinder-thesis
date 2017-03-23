package com.jobfinder.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.jobfinder.dao.CompanyDAO;
import com.jobfinder.model.Company;

@Repository
public class CompanyDAOImpl extends GenericDAOImpl<Company,Integer> implements CompanyDAO {

	private static Logger logger = Logger.getLogger(CompanyDAOImpl.class);

	@Override
	public void registerCompany(Company company) {
		add(company);		
	}

	@Override
	public Company findByUserId(int userId) {
		String hql = "from Company com where com.userId  = :userId ";
		return (Company) getSession().createQuery(hql).setParameter("userId",userId).uniqueResult();
		
	}
	
}
