package com.jobfinder.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.jobfinder.dao.JobDAO;
import com.jobfinder.model.Company;
import com.jobfinder.model.Job;

@Repository
public class JobDAOImpl extends GenericDAOImpl<Job,Integer> implements JobDAO{

	@Override
	public void addJob(Job job) {
		getSession().merge(job);
	}
	
	@Override
	public Job find(int id){
		Job job = (Job) getSession().get(Job.class,id);
		Hibernate.initialize(job.getApplications());
		return job;
	}

	@SuppressWarnings("unchecked")
	public List<Job> listJobsByCompany(Company company) {
		String hql = "from Job where company = :company ";
		return getSession().createQuery(hql).setParameter("company", company).list();
	}


}
