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

import com.mnt.erp.bean.WFStep;
import com.mnt.erp.service.AuditLogService;

/**
 * @author A Nikesh
 * 
 */
public class WFStepDaoImpl extends HibernateDaoSupport implements WFStepDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveWFStepDetails(Object object, String userId,
			String userName) {
		try {

			WFStep wfstep = (WFStep) object;
			Serializable id = getHibernateTemplate().save(wfstep);

			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Process Step",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
			}
			msg = "S";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateWFStepCheck(String wfstepid,String wfstepName) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFStep r where  r.wfstepName='"
					+ wfstepName + "'and r.wfstepStageGUID='" + wfstepid + "'";
			
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
	public List<Object[]> selectStageIds() {
		String sql = null;
		try {
			sql = "select w.wfstageId, w.wfstageName from WFStage w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> selectRoleIds() {
		String sql = null;
		try {
			sql = "select r.roleid, r.role from Role r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> searchWFStep() {

		try {

			String hql = "select r.wfstepid,r.wfstepStageGUID, r.wfstepStep, r.wfstepName, r.wfstepType, r.wfstepStatus, r.wfstepAssignedTo,r.wfstage.wfstageName,r.rolebean.role from WFStep r order by r.wfstepName";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchWFStep(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.wfstepid,r.wfstepStageGUID, r.wfstepStep, r.wfstepName, r.wfstepType, r.wfstepStatus, r.wfstepAssignedTo,r.wfstage.wfstageName,r.rolebean.role from WFStep r where r."
					+ label + "" + operator + " ? order by r.wfstepName";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	/*
	 * @Override public List<WFStep> searchWFStep() { List<Object[]> listl=null;
	 * List<WFStep> displays=new ArrayList<WFStep>(); WFStep wfstepsearch=null;
	 * try {
	 * 
	 * String hql=
	 * "select r.wfstepid,r.wfstepStageGUID, r.wfstepStep, r.wfstepName, r.wfstepType, r.wfstepStatus, r.wfstepAssignedTo,r.wfstage.wfstageName,r.rolebean.role from WFStep r"
	 * ;
	 * 
	 * listl=getHibernateTemplate().find(hql);
	 * 
	 * Iterator<Object[]> iterator=listl.iterator();
	 * 
	 * while(iterator.hasNext()) {
	 * 
	 * Object[] object=(Object[])iterator.next();
	 * 
	 * wfstepsearch=new WFStep();
	 * 
	 * wfstepsearch.setWfstepid((String)object[0]);
	 * wfstepsearch.setWfstepStageGUID((String)object[1]);
	 * wfstepsearch.setWfstepStep((String)object[2]);
	 * wfstepsearch.setWfstepName((String)object[3]);
	 * wfstepsearch.setWfstepType((String)object[4]);
	 * wfstepsearch.setWfstepStatus((String)object[5]);
	 * wfstepsearch.setWfstepAssignedTo((String)object[6]);
	 * wfstepsearch.setWfstageName((String)object[7]);
	 * wfstepsearch.setRole((String)object[8]);
	 * 
	 * 
	 * displays.add(wfstepsearch);
	 * 
	 * } } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return displays; }
	 */
	public List<Object[]> searchWFStepWithName(String wfstepname) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.wfstepid,r.wfstepStageGUID, r.wfstepStep, r.wfstepName, r.wfstepType, r.wfstepStatus, r.wfstepAssignedTo,r.wfstage.wfstageName,r.rolebean.role from WFStep r where r.wfstepid='"
					+ wfstepname + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectWFStepNames() {
		String sql = null;
		try {
			sql = "select w.wfstepid, w.wfstepName from WFStep w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchWFStepWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.wfstepid,r.wfstepStageGUID, r.wfstepStep, r.wfstepName, r.wfstepType, r.wfstepStatus, r.wfstepAssignedTo, r.wfstepCreatedBy, r.wfstepCreatedDate,r.wfstage.wfstageName,r.rolebean.role from WFStep r where r.wfstepid='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateWFStep(Object object) {
		try {
			WFStep wfstep = (WFStep) object;
			getHibernateTemplate().update(wfstep);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String wfstepName, String wfstepid, String wfstageid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFStep w where  w.wfstepName='"
					+ wfstepName + "' and w.wfstepid!='" + wfstepid + "'and wfstepStageGUID='"+wfstageid+"'";
			
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

	public String wfstepDelete(String id) {

		String msg = null;

		try {
			WFStep wfs = new WFStep();
			wfs.setWfstepid(id);
			getHibernateTemplate().delete(wfs);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public List<Object[]> setWFStepAdvanceSearch(String wfstage) {
		String hql = null;
		if (wfstage.equalsIgnoreCase("ALL")) {
			hql = "select w.wfstepid,w.wfstepStageGUID, w.wfstepStep, w.wfstepName, w.wfstepType, w.wfstepStatus, w.wfstepAssignedTo,w.wfstage.wfstageName,w.rolebean.role from WFStep w order by w.wfstepName";

		}

		if (!wfstage.equalsIgnoreCase("ALL")) {
			hql = "select  wfstepid, wfstepStageGUID,  wfstepStep,  wfstepName,  wfstepType,  wfstepStatus,  wfstepAssignedTo, wfstage.wfstageName,rolebean.role from WFStep  where "
					+ wfstage;

		}

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}
}
