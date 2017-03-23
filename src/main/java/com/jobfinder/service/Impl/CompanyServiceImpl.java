package com.jobfinder.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.CompanyDAO;
import com.jobfinder.dao.GenericDAO;
import com.jobfinder.model.Company;
import com.jobfinder.service.CompanyService;

@Service
public class CompanyServiceImpl extends GenericServiceImpl<Company,Integer> implements CompanyService{

	private CompanyDAO companyDAO;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	private static Logger logger = Logger.getLogger(CompanyServiceImpl.class);

	public CompanyServiceImpl(){
		
	}
	@Autowired
	public CompanyServiceImpl(@Qualifier("companyDAOImpl") GenericDAO<Company,Integer> genericDAO){
		super(genericDAO);
		this.companyDAO = (CompanyDAO) genericDAO;
	}

	@Transactional
	public void registerCompany(Company company) {
		this.add(company);				
	}
	
	@Override
	@Transactional
	public Company findByUserId(int userId){
		return companyDAO.findByUserId(userId);
	}


}
