package com.jobfinder.service;

import java.util.List;

import com.jobfinder.model.Company;
import com.jobfinder.model.Job;

public interface JobService extends GenericService<Job,Integer>{
	
	public List<Job> listJobsByCompany(Company company);
	
	public void addJob(Job job);
	
	public Job find(int userId);

}
