/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.WFProcess;
import com.mnt.erp.service.AuditLogService;

/**
 * @author A Nikesh
 * 
 */
public class WFProcessDaoImpl extends HibernateDaoSupport implements
		WFProcessDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveWFProcessDetails(Object object, String userId,
			String userName) {
		try {

			WFProcess wfprocess = (WFProcess) object;
			Serializable id = getHibernateTemplate().save(wfprocess);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Bussiness Process", "ROW", String.valueOf(id), "1",
						modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateWFProcessCheck(String wfprocessName) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFProcess m where  m.wfprocessName='"
					+ wfprocessName + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Object[]> searchWFProcess() {

		try {

			String hql = "select r.wfprocessId,r.wfprocessName,r.wfprocessVersionNo from WFProcess r order by r.wfprocessName";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchWFProcess(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.wfprocessId,r.wfprocessName,r.wfprocessVersionNo from WFProcess r where r."
					+ label + "" + operator + " ? order by r.wfprocessName";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchWFProcessWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.wfprocessId,r.wfprocessName,r.wfprocessVersionNo from WFProcess r where r.wfprocessId='"
					+ id + "' order by r.wfprocessName";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchWFProcessWithName(String wfprocessname) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.wfprocessId,r.wfprocessName,r.wfprocessVersionNo from WFProcess r where r.wfprocessId='"
					+ wfprocessname + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectWFProcessNames() {
		String sql = null;
		try {
			sql = "select r.wfprocessId, r.wfprocessName from WFProcess r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public String updateWFProcess(Object object) {
		try {
			WFProcess wfprocess = (WFProcess) object;

			getHibernateTemplate().update(wfprocess);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String wfprocessname, String wfprocessid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFProcess r where  r.wfprocessName='"
					+ wfprocessname + "' and r.wfprocessId!='" + wfprocessid
					+ "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String wfprocessDelete(String id) {
		WFProcess wfprocess = null;
		try {
			wfprocess = (WFProcess) getHibernateTemplate().get(WFProcess.class,
					id);
			getHibernateTemplate().delete(wfprocess);
			msg = "S";
		} catch (DataIntegrityViolationException de) {
			msg = "F";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

}
