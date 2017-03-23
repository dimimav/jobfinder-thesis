package com.jobfinder.service;

import java.text.ParseException;
import java.util.List;

import com.jobfinder.model.EvaluationCriteria;
import com.jobfinder.model.JobApplication;

public interface JobApplicationService extends GenericService<JobApplication,Integer> {
	
	public void addJobApplication(JobApplication jobApp);
	
	public List<JobApplication> getApplicationsByJobId(int jobId);
	
	public JobApplication find(int id);
	
	public List<JobApplication> evaluateJobApplications(List<JobApplication> jobApplications, EvaluationCriteria criteria);
		
}
