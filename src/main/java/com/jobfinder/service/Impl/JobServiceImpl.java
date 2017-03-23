package com.jobfinder.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.JobDAO;
import com.jobfinder.model.Company;
import com.jobfinder.model.Job;
import com.jobfinder.model.User;
import com.jobfinder.service.CompanyService;
import com.jobfinder.service.JobService;
import com.jobfinder.service.UserService;

@Service
public class JobServiceImpl extends GenericServiceImpl<Job,Integer>  implements JobService{


	private JobDAO jobDAO;
	
	public JobServiceImpl(){
		
	}
	@Autowired
	public JobServiceImpl(@Qualifier("jobDAOImpl") GenericDAO<Job,Integer> genericDAO){
		super(genericDAO);
		this.jobDAO = (JobDAO) genericDAO;
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService companyService;

	@Transactional
	public void addJob(Job job) {
		User user = userService.getUserFromSession();
		Company company = companyService.findByUserId(user.getId());
		job.setCompany(company);
		job.setDatePosted(new Date());
		jobDAO.addJob(job);
	}


	@Override
	@Transactional
	public Job find(int userId) {
		return jobDAO.find(userId);
	}
	
	@Override
	@Transactional
	public List<Job> listJobsByCompany(Company company) {
		return jobDAO.listJobsByCompany(company);
	}
	
}
