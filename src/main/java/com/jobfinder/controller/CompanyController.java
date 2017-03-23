package com.jobfinder.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobfinder.dao.impl.CompanyDAOImpl;
import com.jobfinder.model.Company;
import com.jobfinder.service.CompanyService;
import com.jobfinder.service.UserService;

@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(CompanyController.class);

	
	@RequestMapping(value="/companies")
	public String getCompanies(Model model){
		List<Company> companies = companyService.getAll();
		model.addAttribute("companies",companies);
		return "company/list";
	}
	
	@RequestMapping(value="/company/{id}")
	public String getCompany(@PathVariable("id") int id, Model model){
		Company company = companyService.find(id);
		model.addAttribute("company",company);
		return "company/show";
	}

	@RequestMapping(value="/company/register",method=RequestMethod.GET)
	public String prepareCompanyRegistration(Model model){
		model.addAttribute("company",new Company());
		return "company/register";
	}
	
	@RequestMapping(value="/company/register",method=RequestMethod.POST)
	public String companyRegistration(@ModelAttribute("company") Company company,BindingResult bindingResult, Model model){
		logger.debug("CompanyController - companyRegistration() : "+company.toString());
		model.addAttribute("company",company);
		companyService.registerCompany(company);
		return "company/register";
	}
	
	@RequestMapping(value="/company/login",method=RequestMethod.GET)
	public String prepareLogin(){	
		return "company/login";
	}
	
	@RequestMapping(value="/company/dashboard",method=RequestMethod.GET)
	public String showDashboard(){	
		return "company/dashboard";
	}
	
	@RequestMapping(value="/company/{id}/edit",method=RequestMethod.GET)
	public String prepareEditCompany(@PathVariable("id") int id, Model model ){
		Company company = companyService.find(id);
		model.addAttribute("company",company);
		return "company/edit";
	}
	
	@RequestMapping(value="/company/{id}/edit",method=RequestMethod.POST)
	public String editCompany(@ModelAttribute("company") Company company,BindingResult bindingResult, Model model ){
		company.setUserId(userService.getUserFromSession().getId());
		companyService.update(company);
		return "company/edit";
	}
	
	@RequestMapping(value="/company/{id}/delete")
	public String deleteCompany(@PathVariable("id") int id){
		Company company = companyService.find(id);
		companyService.delete(company);
		return "redirect:/";
	}
}
