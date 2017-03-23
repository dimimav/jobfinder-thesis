package com.jobfinder.dao.impl;


import org.springframework.stereotype.Repository;

import com.jobfinder.dao.CandidateDAO;
import com.jobfinder.model.Candidate;

@Repository
public class CandidateDAOImpl extends GenericDAOImpl<Candidate,Integer> implements CandidateDAO{

	@Override
	public Candidate findByUserId(Integer id) {
		String hql = "from Candidate cand where cand.userId = :userId ";
		return (Candidate) getSession().createQuery(hql).setParameter("userId", id).uniqueResult();
	}

}
