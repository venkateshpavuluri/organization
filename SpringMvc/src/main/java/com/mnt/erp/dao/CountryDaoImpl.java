/**
 * @Copyright MNTSOFT

 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CountryDaoImpl extends HibernateDaoSupport implements CountryDao {

	@Override
	public List<Object[]> getCountryIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;

		try {
			sql = "select c.countryId,c.countryName from  CountrysList c";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
