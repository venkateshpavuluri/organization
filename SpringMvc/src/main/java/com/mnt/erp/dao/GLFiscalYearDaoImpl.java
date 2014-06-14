package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AssertTypeBean;
import com.mnt.erp.bean.GLFiscalYear;
import com.mnt.erp.service.AuditLogService;

public class GLFiscalYearDaoImpl extends HibernateDaoSupport implements GLFiscalYearDao{
	String success;
	List<Object[]> objects = null;
	Serializable id=null;
	@Autowired
	AuditLogService auditLogService;
	

	public Long updateCheckGLFiscalYear(String fiscalYear,int fiscalYearId) {

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

	public Long checkGLFiscalYear(String fiscalYear) {

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

	public String saveGLFiscalYearDetails(Object object,String userId,String userName) {
		try {
			GLFiscalYear gLFiscalYearBean = (GLFiscalYear) object;
			id=getHibernateTemplate().save(gLFiscalYearBean);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","FiscalYear","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> searchGLFiscalYear() {

		try {
			String hql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchGLFiscalYearWithId(int id) {
		try {
			String hql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g where g.gLFiscalYear_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateGLFiscalYear(Object object) {
		try {
			GLFiscalYear updateGLFiscalYear = (GLFiscalYear) object;
			getHibernateTemplate().update(updateGLFiscalYear);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	public String deleteGLFiscalYear(int id) {

		try {
			GLFiscalYear deleteGLFiscalYear = getHibernateTemplate().get(
					GLFiscalYear.class, id);
			getHibernateTemplate().delete(deleteGLFiscalYear);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> selectGLFiscalYear() {
		String sql = null;
		try {
			sql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchGLFiscalYear(String label, String operator,
			String searchName) {
		try {

			String hql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g where g."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
}
