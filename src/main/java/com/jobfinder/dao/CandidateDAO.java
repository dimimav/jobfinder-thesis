package com.jobfinder.dao;

import com.jobfinder.model.Candidate;

public interface CandidateDAO extends GenericDAO<Candidate,Integer>{
	
	public Candidate findByUserId(Integer id);

}
