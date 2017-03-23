package com.jobfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jobfinder.model.Candidate;
import com.jobfinder.service.CandidateService;
import com.jobfinder.service.UserService;

@Controller
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/candidates")
	public String showCandidates(Model model) {
		List<Candidate> candidates = candidateService.getAll();
		model.addAttribute("candidates", candidates);
		return "candidate/list";
	}

	@RequestMapping(value = "/candidate/{id}")
	public String showCandidate(@PathVariable("id") int id, Model model) {
		Candidate candidate = candidateService.find(id);
		model.addAttribute("candidate", candidate);
		return "candidate/show";
	}

	@RequestMapping(value = "/candidate/{id}/edit", method = RequestMethod.GET)
	public String prepareEditCandidate(@PathVariable("id") int id, Model model) {
		Candidate candidate = candidateService.find(id);
		model.addAttribute("candidate", candidate);
		return "candidate/edit";
	}

	@RequestMapping(value = "/candidate/edit", method = RequestMethod.POST)
	public String editCandidate(@ModelAttribute("candidate") Candidate candidate, BindingResult result, Model model) {
		candidate.setUserId(userService.getUserFromSession().getId());
		candidateService.update(candidate);
		model.addAttribute("candidate", candidate);
		return "candidate/edit";
	}

}
