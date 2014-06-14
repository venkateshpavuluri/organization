package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.RecruitmentPlan;
import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.dao.RecruitmentPlanDao;
import com.mnt.erp.dao.ResourceRequestDao;

public class RecruitmentPlanServiceImpl implements RecruitmentPlanService {
	List<Object[]> objects = null;
	String sus=null;
	
	private RecruitmentPlanDao recruitmentPlanDao;
	
	public RecruitmentPlanDao getRecruitmentPlanDao() {
		return recruitmentPlanDao;
	}
	public void setRecruitmentPlanDao(RecruitmentPlanDao recruitmentPlanDao) {
		this.recruitmentPlanDao = recruitmentPlanDao;
	}
	
	
	public Long checkRecruitmentPlan(String fiscalYear){
		Long l = recruitmentPlanDao.checkRecruitmentPlan(fiscalYear);
		return l;
	}
	public Long updateCheckRecruitmentPlan(String fiscalYear,int fiscalYearId) {
		Long l = recruitmentPlanDao.updateCheckRecruitmentPlan(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveRecruitmentPlanDetails(Object object) {
		try {
			sus = recruitmentPlanDao.saveRecruitmentPlanDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchRecruitmentPlan() {
		
		try {
			objects = recruitmentPlanDao.searchRecruitmentPlan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<RecruitmentPlan> searchRecruitmentPlanWithId(int id) {
		List<RecruitmentPlan> list = null;
		try {
			list = recruitmentPlanDao.searchRecruitmentPlanWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateRecruitmentPlan(Object object) {
		try {
			sus = recruitmentPlanDao.updateRecruitmentPlan(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteRecruitmentPlan(int id) {
		try {
			sus = recruitmentPlanDao.deleteRecruitmentPlan(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectVacancy() {
		
		try {
			objects = recruitmentPlanDao.selectVacancy();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectInterviewRound() {
		
		try {
			objects = recruitmentPlanDao.selectInterviewRound();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

	public List<Object[]> basicSearchRecruitmentPlan(String label,String operator,String searchName){
		try {
			objects = recruitmentPlanDao.basicSearchRecruitmentPlan(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteRecruitmentPlanDetail(int kk){
		String msg = null;
		try {
			msg = recruitmentPlanDao.deleteRecruitmentPlanDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	
}
