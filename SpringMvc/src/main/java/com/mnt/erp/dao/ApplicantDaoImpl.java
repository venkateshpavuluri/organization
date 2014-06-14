/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class ApplicantDaoImpl extends HibernateDaoSupport implements ApplicantDao {
	private String msg;
	private String sql;
	List<Object[]> list=null;
	 @Autowired
		AuditLogService auditLogService;
		
	@Override
	public String saveApplicantDetails(Object object,String userId,String userName ) {
		// TODO Auto-generated method stub
		
		ApplicantBean applicant= (ApplicantBean) object;
		
		try {

			Serializable id = getHibernateTemplate().save(applicant);
		
			if(id!=null)
			{

				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Applicant","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
		
				msg = "S";
			}	
						

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getApplicantIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.applicant_Id,o.fname from ApplicantBean o";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ApplicantBean> searchApplicants() {
		// TODO Auto-generated method stu
		List<Object[]> list = null;
		List<ApplicantBean> applicants = new ArrayList<ApplicantBean>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		ApplicantBean applicant = null;
		VacancyDetailLine vDetail = null;
		CountrysList countrysList = null;
		try {
			sql = "select o.applicant_Id,o.fname,o.lname,o.mname,o.phoneNo,o.email,o.vacancyDetail,o.refNo,o.docPath,o.shortListed,o.selected,o.joined from ApplicantBean o ";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				applicant = new ApplicantBean();
				applicant.setApplicant_Id((Integer) objects[0]);
				applicant.setFname((String) objects[1]);
				applicant.setLname((String) objects[2]);
				applicant.setMname((String) objects[3]);
				applicant.setPhoneNo((String) objects[4]);
				applicant.setEmail((String) objects[5]);
				vDetail= (VacancyDetailLine) objects[6];
				applicant.setVacancyDetailNo(vDetail.getVacancyDetailNo());
				applicant.setRefNo((String) objects[7]);
				applicant.setShortListed((Boolean) objects[9]);
				applicant.setSelected((Boolean) objects[10]);
				applicant.setJoined((Boolean) objects[11]);
				
				applicants.add(applicant);
											
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicants;
	}

	@Override
	public List<ApplicantBean> searchApplicantWithId(int id) {

		List<Object[]> list = null;
		List<ApplicantBean> applicants = new ArrayList<ApplicantBean>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		ApplicantBean applicant = null;
		VacancyDetailLine vDetail = null;
		CountrysList countrysList = null;
		try {
			sql = "select o.applicant_Id,o.fname,o.lname,o.mname,o.phoneNo,o.email,o.vacancyDetail,o.refNo,o.docPath,o.shortListed,o.selected,o.joined from ApplicantBean o  where o.applicant_Id="
					+ id + " order by o.fname";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				
				applicant = new ApplicantBean();
				applicant.setApplicant_Id((Integer) objects[0]);
				applicant.setFname((String) objects[1]);
				applicant.setLname((String) objects[2]);
				applicant.setMname((String) objects[3]);
				applicant.setPhoneNo((String) objects[4]);
				applicant.setEmail((String) objects[5]);
				vDetail= (VacancyDetailLine) objects[6];
			    applicant.setVacancyDetail_Id(String.valueOf(vDetail.getVacancyDetailLineId()));
				//applicant.setVacancyDetailNo(vDetail.getVacancyDetailNo()));
				applicant.setRefNo((String) objects[7]);
				applicant.setDocPath((String) objects[8]);
				applicant.setShortListed((Boolean) objects[9]);
				applicant.setSelected((Boolean) objects[10]);
				applicant.setJoined((Boolean) objects[11]);
				applicants.add(applicant);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicants;
	}

	@Override
	public String updateApplicants(Object object) {
String msg=null;
		try {
			ApplicantBean applicant = (ApplicantBean) object;
			getHibernateTemplate().update(applicant);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteApplicants(int id) {
		// TODO Auto-generated method stub
		ApplicantBean applicant = null;
		String msg=null;
		try {
			applicant = (ApplicantBean) getHibernateTemplate().get(
					ApplicantBean.class, id);
			applicant.setVacancyDetail(new VacancyDetailLine());
			getHibernateTemplate().delete(applicant);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}
	
	public Long duplicateCheck(String fname)
	{
		Long duid=0l;
		List<Object> list=null;
		Iterator<Object> iterator=null;
		Object object=null;
		try
		{
			sql="select count(*) from ApplicantBean o where  o.applicant_Id='" + fname
					+ "'";
			list=getHibernateTemplate().find(sql);
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			object=(Object)iterator.next();
			duid=(Long)object;
		}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
		
	}
	public Long updateDuplicateCheck(String fname,int aid)
	{
		Long duid=0l;
		List<Object> list=null;
		Iterator<Object> iterator=null;
		Object object=null;
		try
		{
			sql="select count(*) from ApplicantBean o where  o.fname='" + fname
					+ "' and o.applicant_Id!="+aid+"";
			list=getHibernateTemplate().find(sql);
		iterator=list.iterator();
		while(iterator.hasNext())
		{
			object=(Object)iterator.next();
			duid=(Long)object;
		}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duid;
		
	}
	@Override
	public List<Object[]> selectApplicantDetails() {
		
		String sql=null;
	try
	{
	  
		 sql="select o.applicant_Id,o.fname from ApplicantBean o";
		 
		
		list=getHibernateTemplate().find(sql);
		
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}
		return list;
	}
	public List<ApplicantBean> basicSearchApplicants(String label, String operator,
			String searchName){
		List<ApplicantBean> applicants = new ArrayList<ApplicantBean>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		ApplicantBean applicant = null;
		VacancyDetailLine vDetail = null;
		
		try {

			String hql = "select o.applicant_Id,o.fname,o.lname,o.mname,o.phoneNo,o.email,o.vacancyDetail,o.refNo,o.docPath,o.shortListed,o.selected,o.joined from ApplicantBean o where o."
					+ label + "" + operator + " ? order by o.fname ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
			
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				applicant = new ApplicantBean();
				applicant.setApplicant_Id((Integer) objects[0]);
				applicant.setFname((String) objects[1]);
				applicant.setLname((String) objects[2]);
				applicant.setMname((String) objects[3]);
				applicant.setPhoneNo((String) objects[4]);
				applicant.setEmail((String) objects[5]);
				vDetail= (VacancyDetailLine) objects[6];
				applicant.setVacancyDetailNo((vDetail.getVacancyDetailNo()));
				applicant.setRefNo((String) objects[7]);
				applicant.setShortListed((Boolean) objects[9]);
				applicant.setSelected((Boolean) objects[10]);
				applicant.setJoined((Boolean) objects[11]);
				applicants.add(applicant);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicants;
	}

	
	

	

}
