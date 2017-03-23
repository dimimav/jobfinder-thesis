package com.jobfinder.service.Impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobfinder.dao.GenericDAO;
import com.jobfinder.dao.JobApplicationDAO;
import com.jobfinder.model.Education;
import com.jobfinder.model.EvaluationCriteria;
import com.jobfinder.model.JobApplication;
import com.jobfinder.model.JobApplicationLanguage;
import com.jobfinder.model.LanguageEvaluationCriteria;
import com.jobfinder.model.WorkingExperience;
import com.jobfinder.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl extends GenericServiceImpl<JobApplication, Integer>
		implements JobApplicationService {

	private static Logger logger = Logger.getLogger(JobApplicationServiceImpl.class);

	private JobApplicationDAO jobApplicationDAO;

	public JobApplicationServiceImpl() {

	}

	@Autowired
	public JobApplicationServiceImpl(
			@Qualifier("jobApplicationDAOImpl") GenericDAO<JobApplication, Integer> genericDAO) {
		super(genericDAO);
		this.jobApplicationDAO = (JobApplicationDAO) genericDAO;
	}

	@Transactional
	public void addJobApplication(JobApplication jobApp) {
		jobApplicationDAO.addJobApplication(jobApp);
	}

	@Transactional
	public List<JobApplication> getApplicationsByJobId(int jobId) {
		return jobApplicationDAO.getApplicationsByJobId(jobId);
	}

	@Transactional
	public JobApplication find(int id) {
		return jobApplicationDAO.find(id);
	}
	
	/*
	 * Evaluates Job Applications based on input criteria 
	 */
	@Transactional
	public List<JobApplication> evaluateJobApplications(List<JobApplication> jobApplications, EvaluationCriteria criteria) {
		logger.debug("APPLICATIONS EVALUATION. CRITERIA: " + criteria.toString());
		for (JobApplication jobApp : jobApplications) {
			float workExperienceBonusScore = 0;
			float educationScoreBonus = 0;
			float totalWorkExp = 0;

			/* CALCULATE TOTAL WORK EXPERIENCE IN YEARS */
			for (WorkingExperience workExp : jobApp.getWorkingExperience()) {
	
				Calendar startCalendar = new GregorianCalendar();
				startCalendar.setTime(workExp.getStartDate());
				Calendar endCalendar = new GregorianCalendar();
				endCalendar.setTime(workExp.getEndDate());

				int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
				int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

				float workExpInYears = (float) diffMonth / 12;
				logger.debug("Work experience with id: "+workExp.getId()+", from "+workExp.getStartDate()+" to "+workExp.getEndDate()+". Duration in years: " + workExpInYears);
				totalWorkExp += workExpInYears;
				
			}
			logger.debug("Total work experience in application with id " + jobApp.getId() + ": " + totalWorkExp);

			/* WORK EXPERIENCE EVALUATION */
			if (!criteria.getWorkExperienceRequired().isEmpty()) {
				switch(criteria.getWorkExperienceOperator()){
					case "exacly":
						if (totalWorkExp >= Float.parseFloat(criteria.getWorkExperienceRequired())) {
							jobApp.setWorkingExperienceScore(100);
						}
						break;
					case "min":
						if (totalWorkExp < Float.parseFloat(criteria.getWorkExperienceRequired())) {
							jobApp.setWorkingExperienceScore(0);
						} else {
							jobApp.setWorkingExperienceScore(100);
							workExperienceBonusScore += totalWorkExp/ Float.parseFloat(criteria.getWorkExperienceRequired()) * 100 - 100;
						}
						break;
					case "max":
						if (totalWorkExp >= Float.parseFloat(criteria.getWorkExperienceRequired())) {
							jobApp.setWorkingExperienceScore(100);
						} else {
							jobApp.setWorkingExperienceScore(totalWorkExp / Float.parseFloat(criteria.getWorkExperienceRequired()) * (float) 100);
						}
						break;											
				}
			}
			jobApp.setTotalWorkExperience(totalWorkExp);
			jobApp.setWorkExperienceBonusScore(workExperienceBonusScore);
			logger.debug("Work experience score: "+jobApp.getWorkingExperienceScore()+" bonus score: "+jobApp.getWorkExperienceBonusScore());

			/* EDUCATION EVALUATION */
			if (criteria.getEducationWeight() > 0) {
				for (Education education : jobApp.getEducation()) {
					if (criteria.getEducationOperator().equals("exacly")) {
						if (education.getEducationLevel().getRanking() >= criteria.getEducationLevel()) {
							jobApp.setEducationScore(100);
							break;
						}
					} else if (criteria.getEducationOperator().equals("min")) {
						if (education.getEducationLevel().getRanking() >= criteria.getEducationLevel()) {
							jobApp.setEducationScore(100);
							educationScoreBonus = (education.getEducationLevel().getRanking()
									- criteria.getEducationLevel()) * 100;
							break;
						}
					} else if (criteria.getEducationOperator().equals("max")) {
						if (education.getEducationLevel().getRanking() >= criteria.getEducationLevel()) {
							jobApp.setEducationScore(100);
							break;
						} else {
							jobApp.setEducationScore(((float) education.getEducationLevel().getRanking()
									/ (float) criteria.getEducationLevel()) * 100);
							break;
						}
					}

				}
			}
			jobApp.setEducationBonusScore(educationScoreBonus);
			logger.debug("Education score: "+jobApp.getEducationScore() + " bonus score: "+jobApp.getEducationBonusScore());
			
			/* LANGUAGES EVALUATION */
			for (JobApplicationLanguage candidatelanguage : jobApp.getLanguages()) {
				for (LanguageEvaluationCriteria languageCriterio : criteria.getLanguages()) {
					if (candidatelanguage.getLanguage().getId() == languageCriterio.getLanguageId()) {
						if (languageCriterio.getOperator().equals("exacly")) {
							if (candidatelanguage.getLevel() >= languageCriterio.getLevel()) {
								candidatelanguage.setScore(100);
							}
						} else if (languageCriterio.getOperator().equals("min")) {
							if (candidatelanguage.getLevel() < languageCriterio.getLevel()) {
								candidatelanguage.setScore(0);
							} else {
								candidatelanguage.setScore(100);
							}
						} else if (languageCriterio.getOperator().equals("max")) {
							if (candidatelanguage.getLevel() >= languageCriterio.getLevel()) {
								candidatelanguage.setScore(100);
							} else {
								float languageScore = (float) (candidatelanguage.getLevel())
										/ languageCriterio.getLevel() * 100;
								candidatelanguage.setScore(languageScore);
							}
						}
					}
				}
			}

			/* CALCULATE APPLICATION'S TOTAL SCORE */
			float totalScore = 0;
			String strEvaluationResult = "EVALUATION FOR APPLICATION " + jobApp.getId();

			if (criteria.getWorkExperienceWeight() > 0) {
				totalScore += jobApp.getWorkingExperienceScore() * criteria.getWorkExperienceWeight();
				strEvaluationResult += "\n work experience weight: " + criteria.getWorkExperienceWeight() + " score: "
						+ jobApp.getWorkingExperienceScore() + " w*s="
						+ (jobApp.getWorkingExperienceScore() * criteria.getWorkExperienceWeight());
			}
			if (criteria.getEducationWeight() > 0) {
				totalScore += jobApp.getEducationScore() * criteria.getEducationWeight();
				strEvaluationResult += "\n education weight: " + criteria.getEducationWeight() + " score: "
						+ jobApp.getEducationScore() + " w*s="
						+ (jobApp.getEducationScore() * criteria.getEducationWeight());
			}
			for (LanguageEvaluationCriteria languageCriterio : criteria.getLanguages()) {
				if (languageCriterio.getWeight() > 0) {
					float languageScore = 0;
					for (JobApplicationLanguage lang : jobApp.getLanguages()) {
						if (lang.getLanguage().getId() == languageCriterio.getLanguageId()) {
							languageScore = lang.getScore();
						}
					}
					totalScore += languageScore * languageCriterio.getWeight();
					strEvaluationResult += "\n language id: " + languageCriterio.getLanguageId() + " weight: "
							+ languageCriterio.getWeight() + " score:" + languageScore + " w*s="
							+ languageScore * languageCriterio.getWeight();
				}
			}
			jobApp.setTotalScore(totalScore);
			strEvaluationResult += "\n total score:" + totalScore;

			/* QUALIFICATION */
			if (totalScore >= criteria.getMinTotalScore()) {
				jobApp.setQualified("Yes");
			} else {
				jobApp.setQualified("No");
			}

			logger.debug(strEvaluationResult);
		}
		
		/* bubble sort applications by score */
		for (int i = 0; i < jobApplications.size() - 1; i++) {
			for (int j = 1; j < jobApplications.size() - i; j++) {
				if (jobApplications.get(j - 1).getTotalScore() < jobApplications.get(j).getTotalScore()) {
					JobApplication temp = jobApplications.get(j - 1);
					jobApplications.set(j - 1, jobApplications.get(j));
					jobApplications.set(j, temp);
				}

			}
		}
		
		return jobApplications;
	}

}
