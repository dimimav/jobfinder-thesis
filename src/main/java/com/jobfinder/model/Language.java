package com.jobfinder.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="languages")
public class Language {

	private int id;
	private String name;
	private List<JobApplicationLanguage> jobApplicationLanguages;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "language",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	public List<JobApplicationLanguage> getJobApplicationLanguages() {
		return jobApplicationLanguages;
	}
	public void setJobApplicationLanguages(List<JobApplicationLanguage> jobApplicationLanguages) {
		this.jobApplicationLanguages = jobApplicationLanguages;
	}
	
	public String toString(){
		String result = "id: " + id
						+ "name: " + name;
		return result;
	}


}
