package com.jobfinder.dao.impl;

import org.springframework.stereotype.Repository;

import com.jobfinder.dao.JobCategoryDAO;
import com.jobfinder.model.JobCategory;

@Repository
public class JobCategoryDAOImpl extends GenericDAOImpl<JobCategory,Integer> implements JobCategoryDAO{

}
