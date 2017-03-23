package com.jobfinder.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "job_applications_education")
public class Education {

	private int id;
	private String degree;
	private String school;
	private String fieldOfStudy;
	private String description;
	private float grade;
	private Date startDate = null;
	private Date endDate = null;
	
	private JobApplication jobApplication;
	private EducationLevel educationLevel;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "field_of_study")
	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
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

	@ManyToOne
	@JoinColumn(name = "education_level_id")
	public EducationLevel getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String toString() {
		String result = "{ ";
		result += "id: " + this.id + " degree: " + this.degree + " school: " + this.school + " fieldOfStudy: "
				+ this.fieldOfStudy + " grade: " + this.grade + " startDate: " + this.startDate + " endDate: "
				+ this.endDate;
		result += " }";
		return result;
	}

}
