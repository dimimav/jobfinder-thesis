package com.jobfinder.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.jobfinder.dao.JobApplicationDAO;
import com.jobfinder.model.Education; 
import com.jobfinder.model.JobApplication;
import com.jobfinder.model.JobApplicationLanguage;
import com.jobfinder.model.WorkingExperience;

@Repository
public class JobApplicationDAOImpl extends GenericDAOImpl<JobApplication,Integer> implements JobApplicationDAO {
	
	private static Logger logger = Logger.getLogger(JobApplicationDAOImpl.class);
	
	public int addJobApplication(JobApplication jobApp) { 
		
		logger.debug("JobApplicationDAOImpl - addJobApplication: "+jobApp.toString());
		
		for (WorkingExperience workExperience : jobApp.getWorkingExperience()) {
			workExperience.setJobApplication(jobApp);
		}
		for (Education education : jobApp.getEducation()) {
			education.setJobApplication(jobApp);
		}		
		for(JobApplicationLanguage lang : jobApp.getLanguages()){
			lang.setJobApplication(jobApp);
		}

		 getSession().save(jobApp);
		 
		 logger.debug("JOB APPLICATION SAVED. ID: "+jobApp.getId());
		 
		 return jobApp.getId();
	}

	@SuppressWarnings("unchecked")
	public List<JobApplication> getApplicationsByJobId(int jobId) {
		String hql = "from JobApplication WHERE job.id = :jobId";
		List<JobApplication> jobApplications = getSession().createQuery(hql).setParameter("jobId", jobId).list();
		for (JobApplication jobApp : jobApplications) { 
			Hibernate.initialize(jobApp.getLanguages());
		}
		return jobApplications;
	}

	@Override
	public JobApplication find(int id) {
		JobApplication jobApp = (JobApplication) getSession().get(JobApplication.class, id);
		Hibernate.initialize(jobApp.getLanguages());
		return jobApp;
	}

}
