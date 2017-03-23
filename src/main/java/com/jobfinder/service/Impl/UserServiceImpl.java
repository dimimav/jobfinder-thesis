package com.jobfinder.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.UserDAO;
import com.jobfinder.service.CandidateService;
import com.jobfinder.service.CompanyService;
import com.jobfinder.service.RoleService;
import com.jobfinder.service.UserService;
import com.jobfinder.model.Candidate;
import com.jobfinder.model.Company;
import com.jobfinder.model.Consts;
import com.jobfinder.model.Role;
import com.jobfinder.model.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl extends GenericServiceImpl<User,Integer> implements UserService {

	private UserDAO userDAO;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private CandidateService candidateService;
    
    @Autowired
    private RoleService roleService;
    
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDAOImpl") GenericDAO<User,Integer> genericDAO){
		super(genericDAO);
		this.userDAO = (UserDAO) genericDAO;
	}

    @Override
    @Transactional
    public void save(User user) {
    	logger.debug("saving user: "+user.toString());
    	// encrypt password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user.getType().equals(Consts.ROLE_COMPANY)){
        	Role companyRole = roleService.getRoleByName(Consts.ROLE_COMPANY);
        	Set<Role> userRoles = new HashSet<Role>();
        	userRoles.add(companyRole);
            user.setRoles(userRoles);
            User savedUser = userDAO.save(user);

        	Company company = new Company();
        	company.setUserId(savedUser.getId());
        	logger.debug("saving new company");
        	companyService.add(company);
        }else if(user.getType().equals(Consts.ROLE_CANDIDATE)){
        	Role candidateRole = roleService.getRoleByName(Consts.ROLE_CANDIDATE);
        	Set<Role> userRoles = new HashSet<Role>();
        	userRoles.add(candidateRole);
            user.setRoles(userRoles);
            User savedUser = userDAO.save(user);
            
            Candidate candidate = new Candidate();
        	candidate.setUserId(savedUser.getId());
        	logger.debug("saving new candidate");
        	candidateService.add(candidate);
        }
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        User user = this.userDAO.findByUsername(username);
        return user;
    }

	@Override
	@Transactional
	public String getLoggedInUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		return name;
	}
	
    @Override
    @Transactional
    public User getUserFromSession() {
    	return findByUsername(getLoggedInUserName());
    }
	@Override
	@Transactional
	public User getUserById(int userId){
		return userDAO.find(userId);
	}    
    
}
