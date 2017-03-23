package com.jobfinder.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobfinder.model.Candidate;
import com.jobfinder.model.Company;
import com.jobfinder.model.Consts;
import com.jobfinder.model.User;
import com.jobfinder.service.CandidateService;
import com.jobfinder.service.CompanyService;
import com.jobfinder.service.SecurityService;
import com.jobfinder.service.UserService;
import com.jobfinder.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
    @Autowired(required = true)
	private CompanyService companyService;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
	private static Logger logger = Logger.getLogger(UserController.class);


	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		logger.debug("registration - validate userFrom");
		userValidator.validate(userForm, bindingResult);
		logger.debug("check if result has errors");
		if (bindingResult.hasErrors()) {
			return "registration";
		}
		logger.debug("registration - saving new user");
		userService.save(userForm);
		logger.debug("registration - autologin");
		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
		logger.debug("redirecting to dashboard");
		return "redirect:/user/dashboard";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = "/user/dashboard")
	public String showDashboard(Model model){
		User loggedUsr =  userService.getUserFromSession();
		if(loggedUsr != null){
			model.addAttribute("user", loggedUsr);
			if(loggedUsr.hasRole(Consts.ROLE_COMPANY)){
				Company company = companyService.findByUserId(loggedUsr.getId());
				model.addAttribute("company", company);
			}else if(loggedUsr.hasRole(Consts.ROLE_CANDIDATE)){
				Candidate candidate = candidateService.findByUserId(loggedUsr.getId());
				model.addAttribute("candidate", candidate);
			}
		}
		
		return "user/dashboard";
	}
	
}
