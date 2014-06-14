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

import com.mnt.erp.bean.GoodsReceiptType;
import com.mnt.erp.service.AuditLogService;

public class GoodsReceiptTypeDaoImpl extends HibernateDaoSupport implements
		GoodsReceiptTypeDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;

	@Override
	public String saveGoodsReceiptTypeDetails(Object object, String userId,
			String userName) {
		// TODO Auto-generated method stub
		String gr = null;
		try {
			Serializable id = getHibernateTemplate().save(object);
			if (id != null) {
				gr = "S";
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Goods Reciept Type", "ROW", String.valueOf(id), "1",
						modifiedDate, userName);
			}

		} catch (Exception e) {
			gr = "F";
			e.printStackTrace();
		}
		return gr;
	}

	@Override
	public List<Object[]> searchGoodsReceiptType() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.goodsReceiptTypeId,s.goodsReceiptType from GoodsReceiptType s order by s.goodsReceiptType";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchGoodsReceiptTypeWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.goodsReceiptTypeId,s.goodsReceiptType from GoodsReceiptType s where s.goodsReceiptTypeId="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateGoodsReceiptType(Object object) {
		// TODO Auto-generated method stub
		String gr = null;
		try {
			GoodsReceiptType goodsReceiptType = (GoodsReceiptType) object;
			getHibernateTemplate().update(goodsReceiptType);
			gr = "S";

		} catch (Exception e) {
			gr = "F";
			e.printStackTrace();
		}
		return gr;
	}

	@Override
	public String deleteGoodsReceiptType(int id) {
		// TODO Auto-generated method stub
		String is = "F";
		GoodsReceiptType goodsReceiptType = null;
		try {
			goodsReceiptType = (GoodsReceiptType) getHibernateTemplate().get(
					GoodsReceiptType.class, id);
			getHibernateTemplate().delete(goodsReceiptType);
			is = "S";

		} catch (Exception e) {
			is = "F";
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectGoodsReceiptType() {
		// TODO Auto-generated method stub

		try {
			String q = "select g.goodsReceiptTypeId,g.goodsReceiptType from GoodsReceiptType g";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkGoodsReceiptType(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  GoodsReceiptType ag where ag.goodsReceiptType='"
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

	public int updateCheckGoodsReceiptType(String type, int gdtId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  GoodsReceiptType ag where ag.goodsReceiptType='"
					+ type + "' and ag.goodsReceiptTypeId!='" + gdtId + "'";
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

	public List<Object[]> basicSearchGoodsReceipt(String label,
			String operator, String searchName) {
		try {

			String hql = "select g.goodsReceiptTypeId,g.goodsReceiptType from GoodsReceiptType g where g."
					+ label + "" + operator + " ? ORDER BY g.goodsReceiptType";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> goodsReceiptIdsGet() {

		// TODO Auto-generated method stub
		String hql = "select g.goodsReceiptTypeId,g.goodsReceiptType from GoodsReceiptType g";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}
}
