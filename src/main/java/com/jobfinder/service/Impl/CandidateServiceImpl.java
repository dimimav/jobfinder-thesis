package com.jobfinder.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.CandidateDAO;
import com.jobfinder.dao.GenericDAO;
import com.jobfinder.model.Candidate;
import com.jobfinder.service.CandidateService;

@Service
public class CandidateServiceImpl extends GenericServiceImpl<Candidate,Integer> implements CandidateService {

	private CandidateDAO candidateDAO; 
	
	public CandidateServiceImpl(){		
	}
	
	@Autowired
	public CandidateServiceImpl(@Qualifier("candidateDAOImpl") GenericDAO<Candidate,Integer> genericDAO){
		super(genericDAO);
		this.candidateDAO = (CandidateDAO) genericDAO;
	}

	@Override
	@Transactional
	public Candidate findByUserId(Integer id) {
		return candidateDAO.findByUserId(id);
	}

}
