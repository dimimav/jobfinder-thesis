package com.jobfinder.dao;

import java.util.List;

import com.jobfinder.model.Company;
import com.jobfinder.model.Job;

public interface JobDAO extends GenericDAO<Job,Integer>{
	
	public List<Job> listJobsByCompany(Company company);

	void addJob(Job job);
		
	public Job find(int id);

}
