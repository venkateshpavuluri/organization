/**
 * 
 */
package com.mnt.erp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.VacancyDetailLine;


/**
 * @author devi
 *
 */
public class shortListDaoImpl extends HibernateDaoSupport implements shortListDao{
	List<Object[]> objects = null;
	List<Object[]> list=null;
	@Override
	public List<Object[]> selectVacancyIds() {
		try {
			String hql = "select v.vacancyId,v.vacancyNo from Vacancy v ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	
	public List<ApplicantBean> basicSearchApplicants(int vid){
		List<ApplicantBean> applicants = new ArrayList<ApplicantBean>();
		String sql = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		List<ApplicantBean> appl=null;
		VacancyDetailLine vDetail = null;
		
		try {

			String hql = "from ApplicantBean where vacancyDetail_Id=? and shortListed=0";

			Object[] parameters = { String.valueOf(vid) };
			appl = getHibernateTemplate().find(hql, parameters);
			
			Iterator<ApplicantBean> iterat = appl.iterator();
			while (iterat.hasNext()) {
				Object obje = (Object) iterat.next();
				ApplicantBean	bean =(ApplicantBean)obje;
				applicants.add(bean);
				
			}
			/*getHibernateTemplate().execute(new org.springframework.orm.hibernate3.HibernateCallback() {
			
				public Object doInHibernate(org.hibernate.Session session) throws org.hibernate.HibernateException {
			org.hibernate.Query query = session.createQuery("update AttOptionGroup g set g.sortOrder = (g.sortOrder - 1) where sortOrder > ?");
			
				return "";
				}

				});*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicants;
	}


	@Override
	public String shortListSave(String[] appId) {
		String msg=null;
		try
		{
			for(String u:appId)
			{
				final int k=Integer.parseInt(u);
			//getHibernateTemplate().findByNamedQueryAndNamedParam("shortList","apllicantId",Integer.parseInt(u));
			getHibernateTemplate().execute(new org.springframework.orm.hibernate3.HibernateCallback() {
				
				public Object doInHibernate(org.hibernate.Session session) throws org.hibernate.HibernateException {
			org.hibernate.Query query = session.createQuery("update com.mnt.erp.bean.ApplicantBean a set a.shortListed=1 where a.applicant_Id="+k);
			session.beginTransaction();
			query.executeUpdate();
			session.beginTransaction().commit();
				return "S";
				}

				});
			msg="S";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			msg="F";
		}
		
		return msg;
	}

	

}
