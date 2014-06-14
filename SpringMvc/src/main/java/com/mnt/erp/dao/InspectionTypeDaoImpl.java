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

import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.service.AuditLogService;

public class InspectionTypeDaoImpl extends HibernateDaoSupport implements
		InspectionTypeDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	String msg=null;
	@Override
	public String saveInspectionTypeDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
	
		try {
			Serializable id=getHibernateTemplate().save(object);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Inspection Type",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchInspectionType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.inspectionTypeId,e.inspectionType from InspectionType e order by e.inspectionType";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchInspectionTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.inspectionTypeId,e.inspectionType from InspectionType e where e.inspectionTypeId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateInspectionType(Object object) {
		// TODO Auto-generated method stub

		try {
			InspectionType inspectionType = (InspectionType) object;
			getHibernateTemplate().update(inspectionType);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteInspectionType(int id) {
		// TODO Auto-generated method stub
	
		InspectionType inspectionType = null;
		try {
			inspectionType = (InspectionType) getHibernateTemplate().get(
					InspectionType.class, id);
			getHibernateTemplate().delete(inspectionType);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> selectInspectionType() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.inspectionTypeId,e.inspectionType from InspectionType e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long checkInspectionType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  InspectionType ag where ag.inspectionType='"
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

	public long updateCheckInspectionType(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  InspectionType ag where ag.inspectionType='"
					+ type + "' and ag.inspectionTypeId!='" + Id + "'";
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
	public List<Object[]> basicSearchInspectionType(String label,String operator,String searchName){
		try {

			String hql = "select e.inspectionTypeId,e.inspectionType from InspectionType e where e."
					+ label + "" + operator + " ? order by e.inspectionType ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
