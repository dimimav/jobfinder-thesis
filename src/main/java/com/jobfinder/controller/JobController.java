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

import com.jobfinder.model.Company;
import com.jobfinder.model.Job;
import com.jobfinder.model.JobCategory;
import com.jobfinder.model.User;
import com.jobfinder.service.CompanyService;
import com.jobfinder.service.JobCategoryService;
import com.jobfinder.service.JobService;
import com.jobfinder.service.UserService;

@Controller
public class JobController {

	private static Logger logger = Logger.getLogger(JobController.class);

	@Autowired
	private JobService jobService;
	
	@Autowired
	private JobCategoryService jobCategoryService;
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/listJobs")
	public String listJobs(Model model) {
		List<Job> jobs = jobService.getAll();
		model.addAttribute("jobList",jobs);
		return "/job/listJobs";
	}
	
	@RequestMapping(value = "/job/add", method = RequestMethod.GET)
	public String prepareAddJob(Model model) {
		Job job = new Job();
		model.addAttribute("jobForm", job);
		model.addAttribute("jobCategories", jobCategoryService.getAll());
		return "job/add";
	}
	
	@RequestMapping(value = "/job/add", method = RequestMethod.POST)
	public String addJob(@ModelAttribute("jobForm") Job job, BindingResult result, Model model) {
		model.addAttribute("job",job);		
		jobService.addJob(job);
		return "redirect:/user/dashboard";
	}
	
	@RequestMapping(value="/job/{jobId}")
	public String showJob(@PathVariable("jobId") int jobId, Model model){
		Job job = jobService.find(jobId);
		model.addAttribute("job",job);
		return "job/showDetails";
	}
	
	@RequestMapping(value="/job/edit/{jobId}", method=RequestMethod.GET)
	public String prepareEditJob(@PathVariable("jobId") int jobId, Model model){
		Job job = jobService.find(jobId);
		model.addAttribute("job",job);
		return "job/edit";
	}
	
	
	@RequestMapping(value="/job/edit/{jobId}", method=RequestMethod.POST)
	public String editJob(@ModelAttribute("job") Job job,BindingResult bindingResult, Model model){
		jobService.update(job);
		model.addAttribute("job",job);
		return "job/edit";
	}
	
	/* TODO */
	@RequestMapping(value="/job/delete/{id}")
	public String deleteJob(@PathVariable("id") int id){
		Job job = jobService.find(id);
		jobService.delete(job);
		return "redirect:/user/dashboard";
	}
	
	@RequestMapping(value="/company/{id}/jobs")
	public String showJobsByCompany(@PathVariable("id") int companyId, Model model){
		Company company = companyService.find(companyId);
		List<Job> jobList = jobService.listJobsByCompany(company);
		model.addAttribute("jobList",jobList);
		return "job/listJobs";
	}

}
