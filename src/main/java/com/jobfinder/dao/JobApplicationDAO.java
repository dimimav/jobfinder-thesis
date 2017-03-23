package com.jobfinder.dao;

import java.util.List;

import com.jobfinder.model.JobApplication;

public interface JobApplicationDAO extends GenericDAO<JobApplication,Integer>{
	
	public int addJobApplication(JobApplication jobApp);
	
	public List<JobApplication> getApplicationsByJobId(int jobId);
	
	public JobApplication find(int id);
}
