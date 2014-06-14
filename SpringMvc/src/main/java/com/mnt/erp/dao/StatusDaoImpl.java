package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Status;
import com.mnt.erp.service.AuditLogService;

/**
 * @author ybusireddy
 * @version 23-09-2013
 */

public class StatusDaoImpl extends HibernateDaoSupport implements StatusDao {
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	@Override
	public String saveStatusDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String ss = null;
		try {
			Serializable  id=getHibernateTemplate().save(object);
			if(id!=null)
			{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
auditLogService.setAuditLogSave(userId,"A","Status","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
			ss = "StatusSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public List<Object[]> searchStatus() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.statusId,s.status from Status s";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchStatusWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.statusId,s.status from Status s where s.statusId="
					+ id + "";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateStatus(Object object) {
		// TODO Auto-generated method stub
		String ss = null;
		try {
			Status status = (Status) object;
			getHibernateTemplate().update(status);
			ss = "StatusUpdateSuccess";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ss;
	}

	@Override
	public String deleteStatus(int id) {
		// TODO Auto-generated method stub
		String is = "Status Details Deleted Successfully";
		Status status = null;
		try {
			status = (Status) getHibernateTemplate().get(Status.class, id);
			getHibernateTemplate().delete(status);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectStatusId() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			String q = "select s.statusId,s.status from Status s";
			list = getHibernateTemplate().find(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkStatus(String type) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from  Status ag where ag.status='"
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

	public int updateCheckStatus(String status, int statusId) {
		Long count = null;
		try {
			final String hql = "select count(*) from  Status ag where ag.status='"
					+ status + "' and ag.statusId!='" + statusId + "'";
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
	public List<Object[]> basicSearchStatus(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.statusId,s.status from Status s where s."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
public String getStatus(int statusId){
		
		String f=null;
		try{
		String hql="select s.status from Status s where s.statusId="+statusId+"";
		 //f=getHibernateTemplate().find(hql);
		 List<Object> list = getHibernateTemplate().find(hql);
			Iterator<Object> iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				f = (String) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

}
