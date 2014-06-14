package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.MaintenanceOrderType;

public class MaintenanceOrderTypeDaoImpl extends HibernateDaoSupport implements MaintenanceOrderTypeDao {

	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckMaintenanceOrderType(String maintenanceOrderType,int maintenanceOrderTypeId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenanceOrderType at where  at.maintOrderType ='"
					+ maintenanceOrderType + "' and at.maintOrderType_Id!='" + maintenanceOrderTypeId + "'";
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

	public Long checkMaintenanceOrderType(String maintenanceOrderType) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenanceOrderType m where m.maintOrderType='"
					+ maintenanceOrderType + "'";
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

	public String saveMaintenanceOrderTypeDetails(Object object) {
		try {
			MaintenanceOrderType maintenanceOrderType = (MaintenanceOrderType) object;
			Serializable id=getHibernateTemplate().save(maintenanceOrderType);
            if(id!=null){
            	msg="S";
            }
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchMaintenanceOrderType() {

		try {
			String hql = "select m.maintOrderType_Id,m.maintOrderType from MaintenanceOrderType m order by m.maintOrderType";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaintenanceOrderTypeWithId(int id) {
		try {
			String hql = "select  m.maintOrderType_Id,m.maintOrderType from MaintenanceOrderType m where m.maintOrderType_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateMaintenanceOrderType(Object object) {
		try {
			MaintenanceOrderType updateMaintenanceOrderType = (MaintenanceOrderType) object;
			getHibernateTemplate().update(updateMaintenanceOrderType);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteMaintenanceOrderType(int id) {

		try {
			MaintenanceOrderType deleteMaintenanceOrderType = getHibernateTemplate().get(
					MaintenanceOrderType.class, id);
			getHibernateTemplate().delete(deleteMaintenanceOrderType);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectMaintenanceOrderType(){
		String sql = null;
		try {
			sql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchMaintenanceOrderType(String label,String operator,String searchName){
		try {

			String hql = "select m.maintOrderType_Id,m.maintOrderType from MaintenanceOrderType m where m."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
}
