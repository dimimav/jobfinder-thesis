package com.jobfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/*
 * Many to many relation with attributes
 * */
@Entity
@Table(name="job_applications_languages")
public class JobApplicationLanguage implements Serializable{
	
	private static final long serialVersionUID = -2027125152606566874L;
	
	private JobApplication jobApplication;
	private Language language;
	private int level;
	private float score;

	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="job_application_id")
	public JobApplication getJobApplication() {
		return jobApplication;
	}
	public void setJobApplication(JobApplication jobApplication) {
		this.jobApplication = jobApplication;
	}
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="language_id")
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	@Column(name="level")
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Transient
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	

}
