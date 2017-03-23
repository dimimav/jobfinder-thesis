package com.jobfinder.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "job_applications")
public class JobApplication {

	private int id;
	private String fname;
	private String lname;
	private String email;
	private String address;
	private String phone;
	private String coverLetter;
	private Date createdAt;
	
	private Job job;
	private List<WorkingExperience> workingExperience;
	private List<Education> education;
	private List<JobApplicationLanguage> languages;

	private float totalScore;
	private float totalWorkExperience;

	private float workingExperienceScore;
	private float workExperienceBonusScore;

	private float educationScore;
	private float educationBonusScore;

	private String qualified;
	private String ownerComments;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Transient
	public float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}
	@Transient
	public float getTotalWorkExperience() {
		return totalWorkExperience;
	}

	public void setTotalWorkExperience(float totalWorkExperience) {
		this.totalWorkExperience = totalWorkExperience;
	}

	@ManyToOne
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@OneToMany(mappedBy = "jobApplication", fetch=FetchType.EAGER,cascade = CascadeType.ALL) 
	public List<WorkingExperience> getWorkingExperience() {
		return workingExperience;
	}

	public void setWorkingExperience(List<WorkingExperience> workingExperience) {
		this.workingExperience = workingExperience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "cover_letter")
	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	@Column(name = "created_at")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@OneToMany(mappedBy = "jobApplication",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Education> getEducation() {
		return education;
	}

	public void setEducation(List<Education> education) {
		this.education = education;
	}

	@Transient
	public float getWorkingExperienceScore() {
		return workingExperienceScore;
	}

	public void setWorkingExperienceScore(float workingExperienceScore) {
		this.workingExperienceScore = workingExperienceScore;
	}

	@Transient
	public float getWorkExperienceBonusScore() {
		return workExperienceBonusScore;
	}

	public void setWorkExperienceBonusScore(float workExperienceBonusScore) {
		this.workExperienceBonusScore = workExperienceBonusScore;
	}

	@Transient
	public float getEducationScore() {
		return educationScore;
	}

	public void setEducationScore(float educationScore) {
		this.educationScore = educationScore;
	}

	@Transient
	public float getEducationBonusScore() {
		return educationBonusScore;
	}

	public void setEducationBonusScore(float educationBonusScore) {
		this.educationBonusScore = educationBonusScore;
	}

	public String getQualified() {
		return qualified;
	}

	public void setQualified(String qualified) {
		this.qualified = qualified;
	}

	@Transient
	public String getOwnerComments() {
		return ownerComments;
	}

	public void setOwnerComments(String ownerComments) {
		this.ownerComments = ownerComments;
	}
	@OneToMany(mappedBy = "jobApplication",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<JobApplicationLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<JobApplicationLanguage> languages) {
		this.languages = languages;
	}
	public String toString(){
		String result = " id: " + id+
				",fname: " + fname+
				",lname: " + lname+
				",email: " + email+
				",address: " + address+
				",phone: " + phone+
				",coverLetter: "+coverLetter +
				",created at:"+createdAt;
		return result;
	}

}
