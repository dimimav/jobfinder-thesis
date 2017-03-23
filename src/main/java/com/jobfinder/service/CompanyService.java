package com.jobfinder.service;

import com.jobfinder.model.Company;

public interface CompanyService extends GenericService<Company,Integer>{
	/*
	void save(Company company);

	Company getCompany(long id);

	List<Company> getCompanies();
*/
	public void registerCompany(Company company);
	
	public Company findByUserId(int userId);
	
}
