package com.jobfinder.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.JobCategoryDAO;
import com.jobfinder.model.JobCategory;
import com.jobfinder.service.JobCategoryService;

@Service
public class JobCategoryServiceImpl extends GenericServiceImpl<JobCategory,Integer> implements JobCategoryService{

	private JobCategoryDAO jobCategoryDAO;
	
	@Autowired
	public JobCategoryServiceImpl(@Qualifier("jobCategoryDAOImpl") GenericDAO<JobCategory,Integer> genericDAO){
		super(genericDAO);
		this.jobCategoryDAO = (JobCategoryDAO) genericDAO;
	}
	
}
