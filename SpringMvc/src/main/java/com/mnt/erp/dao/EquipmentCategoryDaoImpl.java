package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AssetGroup;
import com.mnt.erp.bean.EquipmentCategory;

public class EquipmentCategoryDaoImpl extends HibernateDaoSupport implements
		EquipmentCategoryDao {
String msg=null;
	@Override
	public String saveEquipmentCategoryDetails(Object object) {
		// TODO Auto-generated method stub
		String ec = null;
		try {
			Serializable id=getHibernateTemplate().save(object);
			if(id!=null){
				msg="S";
			}
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchEquipmentCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.equipmentCategoryId,e.equipmentCategory from EquipmentCategory e";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchEquipmentCategoryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select e.equipmentCategoryId,e.equipmentCategory from EquipmentCategory e where e.equipmentCategoryId='"
					+ id + "'";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateEquipmentCategory(Object object) {


		try {
			EquipmentCategory equipmentCategory = (EquipmentCategory) object;
			getHibernateTemplate().update(equipmentCategory);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public String deleteEquipmentCategory(int id) {
		// TODO Auto-generated method stub
		String ec = null;
		EquipmentCategory equipmentCategory = null;
		try {
			equipmentCategory = (EquipmentCategory) getHibernateTemplate().get(
					EquipmentCategory.class, id);
			getHibernateTemplate().delete(equipmentCategory);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> selectEquipmentCategory() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String qry = "select e.equipmentCategoryId,e.equipmentCategory from EquipmentCategory e";
			list = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public long checkEquipmentCategory(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  EquipmentCategory ag where ag.equipmentCategory='"
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

	public long updateCheckEquipmentCategory(String type, int eqpId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  EquipmentCategory ag where ag.equipmentCategory='"
					+ type + "' and ag.equipmentCategoryId!='" + eqpId + "'";
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
	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName){
		List<Object[]> list = null;
		try {
			String hql = "select e.equipmentCategoryId,e.equipmentCategory from EquipmentCategory e where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
