package com.jobfinder.service;

import com.jobfinder.model.Candidate;

public interface CandidateService extends GenericService<Candidate,Integer> {
	
	public Candidate findByUserId(Integer id);

}
