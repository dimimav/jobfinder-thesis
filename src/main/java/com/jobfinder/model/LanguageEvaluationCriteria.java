package com.jobfinder.model;

public class LanguageEvaluationCriteria {
	
	private int languageId;
	private String operator; 
	private int level;
	private float weight = 0;
	
	public LanguageEvaluationCriteria(){
		
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

}
