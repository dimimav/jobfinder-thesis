package com.jobfinder.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.LanguageDAO;
import com.jobfinder.model.Language;
import com.jobfinder.service.LanguageService;

@Service
public class LanguageServiceImpl extends GenericServiceImpl<Language,Integer> implements LanguageService{
	
	private LanguageDAO languageDAO;
	
	public LanguageServiceImpl(){
		
	}
	@Autowired
	public LanguageServiceImpl(@Qualifier("languageDAOImpl") GenericDAO<Language,Integer> genericDAO){
		super(genericDAO);
		this.languageDAO = (LanguageDAO) genericDAO;
	}
}
