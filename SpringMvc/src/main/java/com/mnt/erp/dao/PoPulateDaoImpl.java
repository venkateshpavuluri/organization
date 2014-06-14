/**
 * Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author pvenkateswarlu
 * @version 1.0 09-10-2013
 */
public class PoPulateDaoImpl extends HibernateDaoSupport implements PoPulateDao {

	@Override
	public List<Object[]> poPulate(String sql) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object> DuplicateCheck(String hql) {
		List<Object> obj = null;
		try {
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}
