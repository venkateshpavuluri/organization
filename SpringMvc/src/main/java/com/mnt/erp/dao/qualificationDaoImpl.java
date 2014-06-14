package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Qualification;
import com.mnt.erp.service.AuditLogService;


public class qualificationDaoImpl extends HibernateDaoSupport implements qualificationDao {

	List<Object[]> list = null;
	Serializable id=null;
    @Autowired
	AuditLogService auditLogService;
	@Override
	public String saveQualification(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			id=getHibernateTemplate().save(object);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Qualification","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkQualification(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  Qualification ag where ag.qualification='"
					+ type + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchQualification() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.qualification_Id,e.qualification from Qualification e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchQualificationWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.qualification_Id,e.qualification from Qualification e where e.qualification_Id='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchQualification(String label,String operator,String searchName){
		try {

			String hql = "select e.qualification_Id,e.qualification from Qualification e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteQualification(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		Qualification qBean  = null;
		try {
			qBean= (Qualification) getHibernateTemplate().get(Qualification.class, id);
			getHibernateTemplate().delete(qBean);
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String updateQualification(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			Qualification quBean=(Qualification) object;
			
			getHibernateTemplate().update(quBean);
			s = "Qualification Details Updated Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectQualification() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.qualification_Id,e.qualification from Qualification e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckQualification(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  Qualification ag where ag.qualification='"
					+ type + "' and ag.qualification_Id!='" + Id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}


}
