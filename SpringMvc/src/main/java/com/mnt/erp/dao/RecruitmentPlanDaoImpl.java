package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.InterviewRound;
import com.mnt.erp.bean.RecruitmentPlan;
import com.mnt.erp.bean.RecruitmentPlanLine;
import com.mnt.erp.bean.ResourceReqDetail;
import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Vacancy;

public class RecruitmentPlanDaoImpl extends HibernateDaoSupport implements RecruitmentPlanDao{
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckRecruitmentPlan(String fiscalYear,int fiscalYearId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from GLFiscalYear at where  at.fiscalYear ='"
					+ fiscalYear + "' and at.gLFiscalYear_Id!='" + fiscalYearId + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public Long checkRecruitmentPlan(String fiscalYear) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from GLFiscalYear g where  g.fiscalYear='"
					+ fiscalYear + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String saveRecruitmentPlanDetails(Object object) {
		try {
			RecruitmentPlan recruitmentPlanBean = (RecruitmentPlan) object;
			Serializable id=getHibernateTemplate().save(recruitmentPlanBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchRecruitmentPlan() {

		try {
			String hql = "select r.recruitmentPlanId,r.vacancy,r.recruitmentPlanDT from RecruitmentPlan r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<RecruitmentPlan> searchRecruitmentPlanWithId(int id) {
		List<RecruitmentPlan> object=null;
		try {
			String hql = "from RecruitmentPlan r where r.recruitmentPlanId="
					+ id + " ";
			System.out.println("the Query is:"+hql);

			object = getHibernateTemplate().find(hql);
			System.out.println("the object is:"+object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateRecruitmentPlan(Object object) {
			
		RecruitmentPlanLine pc = null;
		Iterator<RecruitmentPlanLine> iterator1 = null;
		RecruitmentPlanLine pLine = null;
		List<RecruitmentPlanLine> list2 = null;
		try {

			RecruitmentPlan pg = (RecruitmentPlan) object;
			int id = pg.getRecruitmentPlanId();
			

			RecruitmentPlan po = (RecruitmentPlan) getHibernateTemplate().get(
					RecruitmentPlan.class, id);
			list2 = po.getRecruitmentPlanLine();
			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (RecruitmentPlanLine) o;
				pc = new RecruitmentPlanLine();
				pc.setRecruitmentPlanLineId(pLine.getRecruitmentPlanLineId());
		
				pc.setInterviewRound(new InterviewRound());
			
				
				getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public String deleteRecruitmentPlan(int id) {
	
	RecruitmentPlanLine emp=null;
	List<RecruitmentPlanLine> list=null;
	try {
		list=new ArrayList<RecruitmentPlanLine>();
		RecruitmentPlan empbean=(RecruitmentPlan)getHibernateTemplate().get(RecruitmentPlan.class, id);
		empbean.setVacancy(new Vacancy());
		List<RecruitmentPlanLine> beans=empbean.getRecruitmentPlanLine();
		Iterator<RecruitmentPlanLine> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			emp=(RecruitmentPlanLine)iterator.next();
			emp.setInterviewRound(new InterviewRound());
	
			list.add(emp);
		}
		empbean.setRecruitmentPlanLine(list);

	getHibernateTemplate().delete(empbean);
	msg="S";

		
	} catch (Exception e) {
		msg="F";
		e.printStackTrace();

	}
	return msg;
			}


	public List<Object[]> selectVacancy() {
		String sql = null;
		try {
			sql = "select vacancyId,vacancyNo from Vacancy";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectInterviewRound() {
		String sql = null;
		try {
			sql = "select interviewRoundId,interviewRound from InterviewRound";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	public List<Object[]> basicSearchRecruitmentPlan(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.recruitmentPlanId,r.vacancy,r.recruitmentPlanDT from RecruitmentPlan r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteRecruitmentPlanDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			RecruitmentPlanLine line=new RecruitmentPlanLine();
			line.setRecruitmentPlanLineId(kk);
			line.setInterviewRound(new InterviewRound());
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
