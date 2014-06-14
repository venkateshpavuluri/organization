/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ShedulingTypeBean;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class ShedulingTypeDaoImpl extends HibernateDaoSupport implements
		SchedulingTypeDao {
	List<Object[]> objects = null;
	List<Object> list = null;
	Iterator<Object> itr = null;
	Long l = 0l;
	String success = null;

	public int updateCheckScCount(String shType, int shId) {

		try {
			String sql = "select count(*) from ShedulingTypeBean stb where  stb.shedulingType='"
					+ shType + "' and stb.shedulingTypeId!='" + shId + "'";
			list = getHibernateTemplate().find(sql);
			itr = list.iterator();

			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}

	public Long checkSchedulingType(String shType) {

		try {
			String sql = "select count(*) from ShedulingTypeBean stb where  stb.shedulingType='"
					+ shType + "'";
			list = getHibernateTemplate().find(sql);
			itr = list.iterator();

			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public String saveShedulingType(Object object) {
		try {
			ShedulingTypeBean shedulBean = (ShedulingTypeBean) object;
			getHibernateTemplate().save(shedulBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Object[]> searchShedulingType() {
		try {
			String hql = "select sh.shedulingTypeId,sh.shedulingType from ShedulingTypeBean sh order by sh.shedulingType";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchShedulingTypeWithId(int sId) {
		try {
			String hql = "select sh.shedulingTypeId,sh.shedulingType from ShedulingTypeBean sh where sh.shedulingTypeId="
					+ sId + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateShedulingType(Object object) {
		try {
			ShedulingTypeBean updateshedulBean = (ShedulingTypeBean) object;
			getHibernateTemplate().update(updateshedulBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Updated";
	}

	@Override
	public String deleteShedulingType(int sId) {
		try {
			ShedulingTypeBean deleteShuling = getHibernateTemplate().get(
					ShedulingTypeBean.class, sId);
			getHibernateTemplate().delete(deleteShuling);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Deleted";
	}

	@Override
	public List<Object[]> selectShedulingType() {
		try {
			String hql = "select sh.shedulingTypeId,sh.shedulingType from ShedulingTypeBean sh";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicShedtype(String label, String operator,
			String searchName) {
		try {

			String hql = "select sh.shedulingTypeId,sh.shedulingType from ShedulingTypeBean sh where sh."
					+ label + "" + operator + " ? order by sh.shedulingType";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
