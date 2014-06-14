/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.WorkCenter;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class WorkCenterDaoImpl extends HibernateDaoSupport implements
		WorkCenterDao {

	String msg;
	List<Object[]> objects = null;

	public String saveWorkCenterDetails(Object object) {
		try {
			WorkCenter wc = (WorkCenter) object;
			getHibernateTemplate().save(wc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	public List<Object[]> searchWorkCenter() {
		List<Object[]> list = null;
		try {
			/*String sql = "select w.workCenter_Id,w.workCenterName,p.plantName,c.capcategory,wc.workCenterCategory from WorkCenter w,Plant p,CapacityCategory c,WorkCenterCategory wc where wc.workCenterCategoryId=w.workCeterCategory_Id and p.plantId=w.plant_Id and c.capcategoryId=w.capacityCategory_Id";*/
			String sql="select w.workCenter_Id,w.workCenterName,w.plant,w.capacityCategory,w.workCenterCategory from WorkCenter w order by w.workCenterName";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> searchWorkCenterWithId(int id) {
		List<Object[]> list = null;
		try {
			String sql = "select workCenter_Id,workCenterName,plant_Id,shop_Id,capacityCategory_Id,workCeterCategory_Id from WorkCenter where workCenter_Id="
					+ id + "";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	@Override
	public List<Object[]> getShopIds() {
		// TODO Auto-generated method stub

		List<Object[]> list = null;
		try {
		
			String sql = "select p.shop_Id,p.shopName from Shop p";
			list = getHibernateTemplate().find(sql);

		} catch (Exception e) {

		}
		return list;
	}
	public String updateWorkCenter(Object object) {
		try {
			WorkCenter workCenter = (WorkCenter) object;
			int id = workCenter.getWorkCenter_IdEdit();

			WorkCenter wtype = (WorkCenter) getHibernateTemplate().get(
					WorkCenter.class, id);

			wtype.setWorkCenterName(workCenter.getWorkCenterNameEdit());

			wtype.setPlant_Id(workCenter.getPlant_IdEdit());
			wtype.setShop_Id(workCenter.getShop_IdEdit());
			wtype.setCapacityCategory_Id(workCenter
					.getCapacityCategory_IdEdit());

			wtype.setWorkCeterCategory_Id(workCenter
					.getWorkCeterCategory_IdEdit());

			getHibernateTemplate().update(wtype);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "S";
	}

	public String deleteWorkCenter(int id) {
		String o=null;
		try {

			WorkCenter center=new WorkCenter();
			
			center.setWorkCenter_Id(id);
			center.setPlant(null);
			getHibernateTemplate().delete(center);
		
			o="S";
		

		} catch (Exception e) {
			o="F";
			e.printStackTrace();

		}
		return o;
	}

	public int checkWorkCenter(String wname) {
		Long count = null;
		try {
			final String hql = "select count(*) from WorkCenter d where d.workCenterName='"
					+ wname + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	public int updateCheckWorkCenter(String wname, int id) {

		Long count = null;
		try {
			final String hql = "select count(*) from WorkCenter d where d.workCenterName='"
					+ wname + "' and d.workCenter_Id!='" + id + "'";

			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							org.hibernate.Query query = session
									.createQuery(hql);
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
	public List<Object[]> basicSearchWorkCenter(String label, String operator,
			String searchName) {
		try {

			String hql = "select w.workCenter_Id,w.workCenterName,w.plant,w.capacityCategory,w.workCenterCategory from WorkCenter w where w."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	

}
