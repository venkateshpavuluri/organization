package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.service.AuditLogService;

/**
 * @author Gkiran
 */

public class MaterialCategoryImpl extends HibernateDaoSupport implements
		MaterialCategory {
	@Autowired
	AuditLogService auditLogService;
	String success = null;
	List<Object[]> list = null;

	@Override
	public List<Object[]> selectMaterialCategoryDetails() {
		try {
			String sql = "select m.materialCategoryId,m.materialCategory,m.materialCategoryCode from MaterialCategory m";

			list = getHibernateTemplate().find(sql);
		} catch (Exception e)

		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String setMaterialCategory(com.mnt.erp.bean.MaterialCategory mm,
			String userId, String userName) {

		try {

			Serializable id = getHibernateTemplate().save(mm);

			if (id != null) {
				success = "S";
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Material Category", "ROW", String.valueOf(id), "1",
						modifiedDate, userName);
			}

		} catch (Exception e) {
			return "F";
			// e.printStackTrace();
		}
		return success;

	}

	@Override
	public List<Object[]> setMaterialCategorySearch(String materialCategoryName) {
		String hql = null;
		if (materialCategoryName.equalsIgnoreCase("All")) {
			hql = "select h.materialCategoryId,h.materialCategory,h.materialCategoryCode from MaterialCategory h ORDER BY h.materialCategory";

		}

		if (!materialCategoryName.equalsIgnoreCase("ALL")) {
			hql = "select h.materialCategoryId,h.materialCategory,h.materialCategoryCode from MaterialCategory h where h.materialCategory='"
					+ materialCategoryName + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public List<Object[]> setMaterialCategorySearch(int id) {

		String hql = "select h.materialCategoryId,h.materialCategory,h.materialCategoryCode from MaterialCategory h  where h.materialCategoryId="
				+ id+" ORDER BY h.materialCategory";

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public String updateMaterialCategory(Object object) {

		try {
			com.mnt.erp.bean.MaterialCategory materialCategory = (com.mnt.erp.bean.MaterialCategory) object;

			int id = materialCategory.getMaterialCategoryIdEdit();
			String materialCategoryvalue = materialCategory
					.getMaterialCategoryEdit();
			String materialCategoryCodevalue = materialCategory
					.getMaterialCategoryCodeEdit();

			materialCategory.setMaterialCategoryId(id);
			materialCategory.setMaterialCategory(materialCategoryvalue);
			materialCategory.setMaterialCategoryCode(materialCategoryCodevalue);
			getHibernateTemplate().update(materialCategory);
			success = "S";

		} catch (Exception e) {
			success = "F";
			// e.printStackTrace();
		}

		return success;
	}

	public String materialCategoryDelete(int id) {
		com.mnt.erp.bean.MaterialCategory materialCategory = null;
		try {

			materialCategory = (com.mnt.erp.bean.MaterialCategory) getHibernateTemplate()
					.get(com.mnt.erp.bean.MaterialCategory.class, id);
			getHibernateTemplate().delete(materialCategory);
			success = "S";
		} catch (Exception e) {
			success = "F";
			// e.printStackTrace();
		}
		return success;
	}

	public Long checkDuplicateMaterial(String name) {

		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from MaterialCategory h where h.materialCategory='"
					+ name + "'";
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

	public Long checkDuplicateMaterialUpdate(String name, int id) {

		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from MaterialCategory h where h.materialCategory='"
					+ name + "'AND h.materialCategoryId!=" + id;
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

	public List<Object[]> basicSearchMaterialCategory(String label,
			String operator, String searchName) {
		try {

			String hql = "select h.materialCategoryId,h.materialCategory,h.materialCategoryCode from MaterialCategory h where h."
					+ label + "" + operator + " ? ORDER BY h.materialCategory";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

}
