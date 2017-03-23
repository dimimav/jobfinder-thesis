package com.jobfinder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job_applications_working_experiences")
public class WorkingExperience {

	private int id;
	private String title;
	private String description;
	private String company;
	private Date startDate;
	private Date endDate;
	private String industry;

	private JobApplication jobApplication;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToOne
	@JoinColumn(name = "job_application_id")
	public JobApplication getJobApplication() {
		return jobApplication;
	}

	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String toString() {
 		String result = "id: "+this.id
				+ " ,title: "+this.title
				+ " ,company: "+this.company
				+ " ,description: "+this.description
				+ " ,startDate: "+this.startDate
				+ " ,endDate: "+this.endDate
				+ " ,industry: "+this.industry;
		return result;
	}

}
