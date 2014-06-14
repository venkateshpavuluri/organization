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

import com.mnt.erp.bean.MaterialType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
public class MaterialTypeDaoImpl extends HibernateDaoSupport implements
		MaterialTypeDao {
	List<Object[]> list = null;
	@Autowired
	AuditLogService auditLogService;
	/*
	 * =============================Select Material Type
	 * Method===================================
	 */
	@Override
	public List<Object[]> selectMaterialType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String sql = "select mt.materialType,mt.materialTypeName from MaterialType mt";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	String msg;

	/*
	 * =============================Add
	 * Method===================================
	 */
	@Override
	public String addMaterialTypeDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try {
			MaterialType materialtype = (MaterialType) object;
			Serializable id=getHibernateTemplate().save(materialtype);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Material Type",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Search(All)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchMaterialType() {
		// TODO Auto-generated method stub

		List<Object[]> objs = null;
		try {
			String searchQuery = "select mt.materialType,mt.materialTypeName,mt.MaterialTypeCode from MaterialType mt order by materialTypeName";
			objs = getHibernateTemplate().find(searchQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	/*
	 * =============================Search(With Id)
	 * Method===================================
	 */
	@Override
	public List<Object[]> searchMaterialTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> objects = null;
		try {
			String searchQuery1 = "select mt.materialType,mt.materialTypeName,mt.MaterialTypeCode from MaterialType mt where mt.materialType="
					+ id + "";
			objects = getHibernateTemplate().find(searchQuery1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	/*
	 * =====================================Update
	 * Method===================================
	 */
	@Override
	public String updateMaterialType(Object object) {
		// TODO Auto-generated method stub
		try {
			MaterialType materialtype = (MaterialType) object;
			int id = materialtype.getMaterialType();
			MaterialType materialtypevalues = (MaterialType) getHibernateTemplate()
					.get(MaterialType.class, id);
			materialtypevalues.setMaterialType(materialtype.getMaterialType());
			materialtypevalues.setMaterialTypeName(materialtype
					.getMaterialTypeName());
			materialtypevalues.setMaterialTypeCode(materialtype
					.getMaterialTypeCode());
			getHibernateTemplate().update(materialtype);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}

		return msg;
	}

	/*
	 * =============================Delete
	 * Method===================================
	 */
	@Override
	public String materialTypeDelete(int id) {
		// TODO Auto-generated method stub
		MaterialType materialtype = null;
		try {
			materialtype = (MaterialType) getHibernateTemplate().get(
					MaterialType.class, id);
			getHibernateTemplate().delete(materialtype);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	/*
	 * =============================Add Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkDuplicate(String checkMTType, String checkMTTypeCode) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from MaterialType mt where mt.materialTypeName='"
					+ checkMTType
					+ "' or mt.MaterialTypeCode='"
					+ checkMTTypeCode + "'";
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

	/*
	 * =============================Edit Duplicate Checking
	 * Method===================================
	 */
	@Override
	public int checkEditDuplicate(String checkMTType, String checkMTTypeCode,
			int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from MaterialType mt where mt.materialTypeName='"
					+ checkMTType
					+ "' or mt.MaterialTypeCode='"
					+ checkMTTypeCode + "' and mt.materialType!='" + id + "'";

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

	@Override
	public List<Object[]> basicSearchMaterialType(String label,
			String operator, String searchName) {
		try {

			String hql = "select mt.materialType,mt.materialTypeName,mt.MaterialTypeCode from MaterialType mt where mt."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
