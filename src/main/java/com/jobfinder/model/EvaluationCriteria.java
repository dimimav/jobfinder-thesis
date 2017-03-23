package com.jobfinder.model;

import java.util.List;

public class EvaluationCriteria {
	
	private String workExperienceOperator;
	private String workExperienceRequired;
	private float workExperienceWeight = 0;

	private String educationOperator;
	private int educationLevel;
	private float educationWeight = 0;
	
	private List<LanguageEvaluationCriteria> languages;
	
	private float minTotalScore;
	
	public EvaluationCriteria(){
		
	}

	public String getWorkExperienceOperator() {
		return workExperienceOperator;
	}

	public void setWorkExperienceOperator(String workExperienceOperator) {
		this.workExperienceOperator = workExperienceOperator;
	}

	public String getWorkExperienceRequired() {
		return workExperienceRequired;
	}

	public void setWorkExperienceRequired(String workExperienceRequired) {
		this.workExperienceRequired = workExperienceRequired;
	}

	public float getWorkExperienceWeight() {
		return workExperienceWeight;
	}

	public void setWorkExperienceWeight(float workExperienceWeight) {
		this.workExperienceWeight = workExperienceWeight;
	}

	public String getEducationOperator() {
		return educationOperator;
	}

	public void setEducationOperator(String educationOperator) {
		this.educationOperator = educationOperator;
	}

	public int getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(int educationLevel) {
		this.educationLevel = educationLevel;
	}

	public float getEducationWeight() {
		return educationWeight;
	}

	public void setEducationWeight(float educationWeight) {
		this.educationWeight = educationWeight;
	}

	public List<LanguageEvaluationCriteria> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageEvaluationCriteria> languages) {
		this.languages = languages;
	}

	public float getMinTotalScore() {
		return minTotalScore;
	}

	public void setMinTotalScore(float minTotalScore) {
		this.minTotalScore = minTotalScore;
	}
	
	public String toString(){
		String result = " Work experience : "
						+ workExperienceOperator + " "
						+ workExperienceRequired + " years"
						+ " weight "+workExperienceWeight + " , "
						+ "education: "
						+ educationOperator + " "
						+ "level: " + educationLevel + " "
						+ "weight: " + educationWeight;
		result += " Languages: ";
		for(LanguageEvaluationCriteria language : languages){
			result += "  id: " + language.getLanguageId() + " "
					 		+ language.getOperator()+" "
					 		+ "level: "+language.getLevel()
							+ " weight: "+language.getWeight();
		}						
		return result;
	}
	
}
