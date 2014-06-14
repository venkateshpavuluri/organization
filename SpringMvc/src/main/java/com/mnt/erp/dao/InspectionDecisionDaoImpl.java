/**
 * 
 */
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

import com.mnt.erp.bean.InspectionDecision;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.bean.Qualification;
import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.bean.SalesOrganizationBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class InspectionDecisionDaoImpl extends HibernateDaoSupport implements inspectionDecisionDao{
	List<Object[]> list = null;
	Serializable id=null;
    @Autowired
	AuditLogService auditLogService;
	@Override
	public String saveInspectionDecision(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			id=getHibernateTemplate().save(object);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","InspectionDecision","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

}
	@Override
	public long checkInspectionDecision(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  InspectionDecision ag where ag.decision='"
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
	public List<Object[]> searchInspectionDecision() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.inspDecision_Id,e.inspectBean,e.decision from InspectionDecision e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> searchInspectionDecisionWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.inspDecision_Id,e.inspLotOrigin,e.decision from InspectionDecision e where e.inspDecision_Id='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> basicSearchInspectionDecision(String label,String operator,String searchName){
		try {

			String hql = "select e.inspDecision_Id,e.inspectBean,e.decision from InspectionDecision e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deleteInspectionDecision(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		
		InspectionDecision iBean  = null;
		try {
			InspectionDecision insp= getHibernateTemplate().get(InspectionDecision.class, id);
			insp.setInspectBean(new InsplotOrigin());
			getHibernateTemplate().delete(insp);
			msg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public String updateInspectionDecision(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			InspectionDecision idBean=(InspectionDecision) object;
			
			getHibernateTemplate().update(idBean);
			s = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> selectInspectionDecision() {
		// TODO Auto-generated method stub
	
		try {
			String qry = "select e.inspDecision_Id,e.inspectBean,e.decision from InspectionDecision e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public long updateCheckInspectionDecision(String type, int Id) {
		Long count = null;
		try {
			final String hql = "select count(*) from  InspectionDecision ag where ag.decision='"
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
	@Override
	public List<Object[]> getInspectionLotOriginIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.insplotoriginId,s.insplotorigin from InsplotOrigin s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
