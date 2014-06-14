package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AssetGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @author ybusireddy
 * @version 20-09-2013
 */

public class AssetGroupDaoImpl extends HibernateDaoSupport implements
		AssetGroupDao {
	List<Object[]> list = null;
    Serializable id=null;
    @Autowired
	AuditLogService auditLogService;
	
	@Override
	public String saveAssetGroupDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String asg = null;
		try {
			id=getHibernateTemplate().save(object);
			
			asg = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return asg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchAssetGroup() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.assetGroupId,s.assetGroupType from AssetGroup s order by s.assetGroupType";
			list = getHibernateTemplate().find(q);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchAssetGroupWithId(int id) {
		// TODO Auto-generated method stub

		List<Object[]> list = null;
		try {
			String q = "select s.assetGroupId,s.assetGroupType from AssetGroup s where s.assetGroupId="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateAssetGroup(Object object) {
		// TODO Auto-generated method stub
		String s = null;

		try {
			AssetGroup assetGroup = (AssetGroup) object;
			getHibernateTemplate().update(assetGroup);
			s = "S";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String deleteAssetGroup(int id) {
		// TODO Auto-generated method stub
		String is = null;
		AssetGroup assetGroup = null;
		try {
			assetGroup = getHibernateTemplate().get(
					AssetGroup.class, id);
			getHibernateTemplate().delete(assetGroup);
			is = "S";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectAssetGroup() {
		// TODO Auto-generated method stub
	
		try {
			String q = "select s.assetGroupId,s.assetGroupType from AssetGroup s";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int checkAssetGroupType(String type) {
		// TODO Auto-generated method stub

		Long count = null;
		try {
			final String hql = "select count(*) from  AssetGroup ag where ag.assetGroupType='"
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
		return count.intValue();
	}

	public int updateCheckAssetGroupType(String type, int typeId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  AssetGroup ag where ag.assetGroupType='"
					+ type + "' and ag.assetGroupId!='" + typeId + "'";
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
	
	public List<Object[]> basicSearchAssetGroup(String label,String operator,String searchName){
		try {

			String hql = "select s.assetGroupId,s.assetGroupType from AssetGroup s where s."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
