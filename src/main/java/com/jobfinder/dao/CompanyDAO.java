package com.jobfinder.dao;

import com.jobfinder.model.Company;

public interface CompanyDAO extends GenericDAO<Company,Integer>{

	public void registerCompany(Company company);
	
	public Company findByUserId(int userId);
	
}
