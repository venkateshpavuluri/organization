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
import com.mnt.erp.bean.Industry;
import com.mnt.erp.service.AuditLogService;

/**
 * @author ybusireddy
 * @version 19-09-2013
 */
public class IndustryDaoImpl extends HibernateDaoSupport implements IndustryDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	@Override
	public String saveIndustryDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub

		String isa = null;
		;
		try {
		Serializable id=getHibernateTemplate().save(object);
		if(id!=null)
		{
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
auditLogService.setAuditLogSave(userId,"A","Industry","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
		}
			isa = "IndustrySuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isa;
	}

	@Override
	public List<Object[]> searchIndustry() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.industryTypeId,s.industryType from Industry s";
			list = getHibernateTemplate().find(q);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchIndustryWithId(int id) {
		// TODO Auto-generated method stub
	
		try {
			String q = "select s.industryTypeId,s.industryType from Industry s where s.industryTypeId="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateIndustry(Object object) {
		// TODO Auto-generated method stub
		String s = "updateSuccess";

		try {
			Industry industry = (Industry) object;
			getHibernateTemplate().update(industry);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String deleteIndustry(int id) {
		// TODO Auto-generated method stub
		String is = "Industry Details Deleted Successfully";
		Industry industry = null;
		try {
			industry = (Industry) getHibernateTemplate()
					.get(Industry.class, id);
			getHibernateTemplate().delete(industry);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectIndustryId() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.industryTypeId,s.industryType from Industry s";

			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkIndustryType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  Industry ag where ag.industryType='"
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
		return count.intValue();
	}

	public int updateCheckIndustryType(String indType, int indId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  Industry ag where ag.industryType='"
					+ indType + "' and ag.industryTypeId!='" + indId + "'";
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
		return count.intValue();
	}
	public List<Object[]> basicSearchIndustryType(String label,String operator,String searchName){
		try {

			String hql = "select s.industryTypeId,s.industryType from Industry s where s."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
