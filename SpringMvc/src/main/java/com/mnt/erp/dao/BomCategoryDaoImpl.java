package com.mnt.erp.dao;

import java.util.Iterator;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Gkiran
 */

public class BomCategoryDaoImpl extends HibernateDaoSupport implements
		BomCategoryDao {
	List<Object[]> objs = null;
	String success = null;

	@Override
	public String saveBomCategory(com.mnt.erp.bean.BomCategory mm) {

		try {
			getHibernateTemplate().save(mm);

			success = "success";
		} catch (Exception e) {
			success = "fail";
			// e.printStackTrace();
		}
		return success;

	}

	@Override
	public List<Object[]> setBomCategorySearch(String bomCategory) {
		String hql = null;
		if (bomCategory.equalsIgnoreCase("ALL")) {
			hql = "select h.bomCategoryId,h.bomCategory from BomCategory h order by h.bomCategory";

		}

		if (!bomCategory.equalsIgnoreCase("ALL")) {
			hql = "select h.bomCategoryId,h.bomCategory from BomCategory h where h.bomCategory='"
					+ bomCategory + "' order by h.bomCategory";
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public List<Object[]> setBomCategorySearch(int id) {

		String hql = "select h.bomCategoryId,h.bomCategory from BomCategory h where h.bomCategoryId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public String updateBomCategory(Object object) {
		try {
			com.mnt.erp.bean.BomCategory bomCategory = (com.mnt.erp.bean.BomCategory) object;

			int id = bomCategory.getBomCategoryIdEdit();
			String bomCategoryvalue = bomCategory.getBomCategoryEdit();

			bomCategory.setBomCategoryId(id);
			bomCategory.setBomCategory(bomCategoryvalue);

			getHibernateTemplate().update(bomCategory);
			success = "success";
		} catch (Exception e) {
			success = "fail";
			// e.printStackTrace();
		}

		return success;
	}

	public String bomCategoryDelete(int id) {
		com.mnt.erp.bean.BomCategory bomCategory = null;
		try {
			bomCategory = (com.mnt.erp.bean.BomCategory) getHibernateTemplate()
					.get(com.mnt.erp.bean.BomCategory.class, id);
			getHibernateTemplate().delete(bomCategory);
			success = "success";
		} catch (Exception e) {
			// e.printStackTrace();
			success = "fail";
		}
		return success;
	}

	public Long checkDuplicateBomCategory(String mm) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from BomCategory h where h.bomCategory='"
					+ mm + "'";
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;

			}
			// success =count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public Long checkDuplicateBomCategoryUpdate(String mm, int id) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from BomCategory h where h.bomCategory='"
					+ mm + "' AND h.bomCategoryId!=" + id;
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;

			}
			// success =count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public List<Object[]> basicSearchBomCategory(String label, String operator,
			String searchName) {
		try {

			String hql = "select h.bomCategoryId,h.bomCategory from BomCategory h where h."
					+ label + "" + operator + " ? order by h.bomCategory";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

}
