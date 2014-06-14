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
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.WFStage;
import com.mnt.erp.service.AuditLogService;

/**
 * @author A Nikesh
 * 
 */
public class WFStageDaoImpl extends HibernateDaoSupport implements WFStageDao {

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveWFStageDetails(Object object, String userId,
			String userName) {
		try {
			Serializable id = getHibernateTemplate().save(object);

			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Process Stage",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}
		return msg;

	}

	@Override
	public Long duplicateWFStageCheck(String wfstageName) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFStage w where  w.wfstageName='"
					+ wfstageName + "'";
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
	public List<Object[]> searchWFStage() {

		try {

			String hql = "select w.wfstageId,w.wfstageProcessGUID,w.wfstageStage,w.wfstageName,w.wfstageDescription,w.wfstageType,w.wfprocess.wfprocessName from WFStage w order by w.wfstageName";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchWFStage(String label, String operator,
			String searchName) {
		try {
			String hql = "select w.wfstageId,w.wfstageProcessGUID,w.wfstageStage,w.wfstageName,w.wfstageDescription,w.wfstageType,w.wfprocess.wfprocessName from WFStage w where w."
					+ label + "" + operator + " ? order by w.wfstageName";
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchWFStageWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select w.wfstageId,w.wfstageProcessGUID,w.wfstageStage,w.wfstageName,w.wfstageDescription,w.wfstageType,w.wfstageCreatedBy,w.wfstageCreatedDate from WFStage w where w.wfstageId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectProcessIds() {
		String sql = null;
		try {
			sql = "select w.wfprocessId, w.wfprocessName from WFProcess w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchWFStageWithName(String wfstagename) {
		List<Object[]> objects = null;
		try {

			String hql = "select w.wfstageId,w.wfstageProcessGUID,w.wfstageStage,w.wfstageName,w.wfstageDescription,w.wfstageType,w.wfprocess.wfprocessName from WFStage w where w.wfstageId='"
					+ wfstagename + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectWFStageNames() {
		String sql = null;
		try {
			sql = "select w.wfstageId,w.wfstageName from WFStage w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public String updateWFStage(Object object) {
		try {
			WFStage wfstage = (WFStage) object;

			getHibernateTemplate().update(wfstage);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String wfstageName, String wfstageid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFStage w where  w.wfstageName='"
					+ wfstageName + "' and w.wfstageId!='" + wfstageid + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;
				System.out
						.println("no of duplicates are in stage dao impl edit   with name"
								+ wfstageName
								+ " and id "
								+ wfstageid
								+ "  "
								+ i);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String wfstageDelete(String id) {

		String msg = null;

		try {
			WFStage wfs = new WFStage();
			wfs.setWfstageId(id);
			getHibernateTemplate().delete(wfs);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public List<Object[]> setWFStageAdvanceSearch(String wfstage) {
		String hql = null;
		if (wfstage.equalsIgnoreCase("ALL")) {
			hql = "select w.wfstageId,w.wfstageProcessGUID,w.wfstageStage,w.wfstageName,w.wfstageDescription,w.wfstageType,w.wfprocess.wfprocessName from WFStage w order by w.wfstageName";
		}

		if (!wfstage.equalsIgnoreCase("ALL")) {
			hql = "select wfstageId,wfstageProcessGUID,wfstageStage,wfstageName,wfstageDescription,wfstageType,wfprocess.wfprocessName from WFStage where "
					+ wfstage;
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
