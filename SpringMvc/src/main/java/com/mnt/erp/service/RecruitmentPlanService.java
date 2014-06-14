package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.RecruitmentPlan;

public interface RecruitmentPlanService {
	public Long updateCheckRecruitmentPlan(String fiscalYear,int fiscalYearId);

	public Long checkRecruitmentPlan(String fiscalYear);
	
	public String saveRecruitmentPlanDetails(Object object);

	public List<Object[]> searchRecruitmentPlan();

	public List<RecruitmentPlan> searchRecruitmentPlanWithId(int id);

	public String updateRecruitmentPlan(Object object);

	public String deleteRecruitmentPlan(int id);
	
	public List<Object[]> selectInterviewRound();
	
	public List<Object[]> selectVacancy();
	
	public String deleteRecruitmentPlanDetail(int kk);
	
	public List<Object[]> basicSearchRecruitmentPlan(String label,String operator,String searchName);
}
