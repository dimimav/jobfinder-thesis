package com.jobfinder.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jobfinder.model.Education;
import com.jobfinder.model.EvaluationCriteria;
import com.jobfinder.model.Job;
import com.jobfinder.model.JobApplication;
import com.jobfinder.model.JobApplicationLanguage;
import com.jobfinder.model.Language;
import com.jobfinder.model.WorkingExperience;
import com.jobfinder.service.JobApplicationService;
import com.jobfinder.service.JobService;
import com.jobfinder.service.LanguageService;

@Controller
public class JobApplicationController {

	private static Logger logger = Logger.getLogger(JobApplicationController.class);

	@Autowired
	private JobService jobService;

	@Autowired
	private JobApplicationService jobApplicationService;

	@Autowired
	private LanguageService languageService;

	/*  View Job application  */
	@RequestMapping(value = "/jobApplication/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") int id, Model model, @ModelAttribute("msg") final String msg,
	        final BindingResult bindingResult) {
		JobApplication jobApp = jobApplicationService.find(id);
		
		model.addAttribute("jobApplication", jobApp);
		if(!msg.isEmpty()){
			model.addAttribute("msg",msg);
		}
		return "job/application/show";
	}

	/* Apply for job */
	@RequestMapping(value = "/job/{jobId}/apply", method = RequestMethod.GET)
	public String prepareApply(@PathVariable("jobId") int jobId, Model model) {

		Job job = jobService.find(jobId);
		JobApplication jobApp = new JobApplication();
		List<Language> languages = languageService.getAll();
		model.addAttribute("job", job);
		model.addAttribute("jobApplicationForm", jobApp);
		model.addAttribute("languages", languages);

		return "job/apply";
	}

	@RequestMapping(value = "/job/{jobId}/apply", method = RequestMethod.POST)
	public String apply(@ModelAttribute("jobApplicationForm") JobApplication jobApp,
			@PathVariable("jobId") int jobId, BindingResult result, Model model,final RedirectAttributes redirectAttributes, HttpServletRequest request) {
		logger.debug("INSERTING NEW JOB APPLICATION ");
		logger.debug("fname: "+ request.getParameter("fname"));
		jobApp.setJob(jobService.find(jobId));
		
		// remove empty entities
		List<WorkingExperience> workingExperience = jobApp.getWorkingExperience();
		for (Iterator<WorkingExperience> iter = workingExperience.listIterator(); iter.hasNext();) {
			WorkingExperience we = iter.next();
			if (we.getCompany() == null || we.getCompany().isEmpty()) {
				iter.remove();
			}
		}
		jobApp.setWorkingExperience(workingExperience);

		// remove empty entities
		List<Education> education = jobApp.getEducation();
		for (Iterator<Education> iter = education.listIterator(); iter.hasNext();) {
			Education eduction = iter.next();
			if (eduction.getSchool() == null || eduction.getSchool().isEmpty()) {
				iter.remove();
			}
		}
		jobApp.setEducation(education);
		
		// remove empty entities
		List<JobApplicationLanguage> languages = jobApp.getLanguages();
		for (Iterator<JobApplicationLanguage> iter = languages.listIterator(); iter.hasNext();){
			JobApplicationLanguage lang = iter.next();
			if(lang.getLevel() == 0){
				iter.remove();
			}
		}
		jobApp.setLanguages(languages);
		
		jobApp.setCreatedAt(new Date());
		
		//Submit job application 
		jobApplicationService.addJobApplication(jobApp);
		String msg = "You application submitted successfully!"; 		
 	    redirectAttributes.addFlashAttribute("msg",msg);
 		return "redirect:/jobApplication/"+jobApp.getId();
	}

	@RequestMapping(value = "/job/{jobId}/applications", method = RequestMethod.GET)
	public String showJobApplications(@PathVariable("jobId") int jobId, Model model) {
		Job job = jobService.find(jobId);
		List<JobApplication> jobApplications = jobApplicationService.getApplicationsByJobId(jobId);

		model.addAttribute("job", job);
		model.addAttribute("criteria", new EvaluationCriteria());
		model.addAttribute("jobApplications", jobApplications);
		model.addAttribute("availableLanguages", languageService.getAll());
		return "job/applications";
	}

	/* APPLICATIONS EVALUATION */
	@RequestMapping(value = "/job/{jobId}/applications", method = RequestMethod.POST)
	public String evaluateApplications(@PathVariable("jobId") int jobId, @ModelAttribute("criteria") EvaluationCriteria criteria, Model model){
		Job job = jobService.find(jobId);
		
		/* GET ALL JOB APPLICATIONS */
		List<JobApplication> jobApplications = jobApplicationService.getApplicationsByJobId(jobId);
		
		/* THEN EVALUATE THEM */
		jobApplications = jobApplicationService.evaluateJobApplications(jobApplications, criteria);

		model.addAttribute("job", job);
		model.addAttribute("jobApplications", jobApplications);
		model.addAttribute("availableLanguages", languageService.getAll());
		return "job/applications";
	}

}
