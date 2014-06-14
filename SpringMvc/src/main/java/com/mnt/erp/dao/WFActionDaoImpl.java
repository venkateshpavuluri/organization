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

import com.mnt.erp.bean.WFAction;
import com.mnt.erp.service.AuditLogService;

/**
 * @author A Nikesh
 * 
 */
public class WFActionDaoImpl extends HibernateDaoSupport implements WFActionDao {

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveWFActionDetails(Object object, String userId,
			String userName) {
		try {
			WFAction wfaction = (WFAction) object;
			Serializable id = getHibernateTemplate().save(wfaction);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Process Action",
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
	public Long duplicateWFActionCheck(String wfactionName, String wstep) {
		// TODO Auto-generated method stub
		Long i = 0l;

		try {
			sql = "select count(*) from WFAction ab where ab.wfactionStepGUID ='"
					+ wstep + "' and  ab.wfactionName='" + wfactionName + "' ";
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
	public List<Object[]> selectStepIds() {
		String sql = null;
		try {
			// System.out.println("in try of select stepids in wfaction dao impl");
			sql = "select w.wfstepid, w.wfstepName from WFStep w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> selectActionIds(){
		String sql = null;
		try {
			// System.out.println("in try of select stepids in wfaction dao impl");
			sql = "select w.wActionId, w.wAction from WAction w";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}
	@Override
	public List<Object[]> searchWFAction() {

		try {
			// System.out.println("in search of wfaction dao impl");
			String hql = "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.waction,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfstep.wfstepName from WFAction w order by w.wfactionName";
			// System.out.println("query in search of department is "+hql);
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchWFAction(String label, String operator,
			String searchName) {
		try {
			// System.out.println("in basic search of vehicle type");
			String hql = "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.wfactionName,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfstep.wfstepName from WFAction w where w."
					+ label + "" + operator + " ? order by w.wfactionName";
			// System.out.println("query in basic search is   "+hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	/*
	 * @Override public List<WFAction> searchWFAction() { List<Object[]>
	 * listl=null; List<WFAction> displays=new ArrayList<WFAction>(); WFAction
	 * wfactionsearch=null; try {
	 * 
	 * String hql=
	 * "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.wfactionName,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfstep.wfstepName from WFAction w"
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
	 * wfactionsearch=new WFAction();
	 * 
	 * wfactionsearch.setWfactionId((String)object[0]);
	 * wfactionsearch.setWfactionStepGUID((String)object[1]);
	 * wfactionsearch.setWfactionAction((String)object[2]);
	 * wfactionsearch.setWfactionName((String)object[3]);
	 * wfactionsearch.setWfactionType((String)object[4]);
	 * wfactionsearch.setWfactionCondition((String)object[5]);
	 * wfactionsearch.setWfactionDirection((String)object[6]);
	 * wfactionsearch.setWfactionGotoStep((String)object[7]);
	 * wfactionsearch.setWfactionEmail((String)object[8]);
	 * wfactionsearch.setWfactionWorkList((Integer)object[9]);
	 * wfactionsearch.setWfactionComments((String)object[9]);
	 * wfactionsearch.setWfactionMessage((String)object[10]);
	 * wfactionsearch.setWfactionMessageDetails((String)object[11]);
	 * wfactionsearch.setWfstepName((String)object[12]);
	 * 
	 * displays.add(wfactionsearch);
	 * 
	 * } } catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return displays; }
	 */
	public List<Object[]> searchWFActionWithName(String wfactionname) {
		List<Object[]> objects = null;
		try {
			// System.out.println("wfaction name in search wfaction with name  "+wfactionname);
			String hql = "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.wfactionName,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfstep.wfstepName from WFAction w where w.wfactionId='"
					+ wfactionname + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectWFActionNames() {
		String sql = null;
		try {
			sql = "select r.wfactionId, r.wfactionName from WFAction r order by r.wfactionName";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchWFActionWithId(String id) {
		List<Object[]> objects = null;
		try {
			// System.out.println("wfaction id in search wfaction with id   "+id);
			String hql = "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.wActionId,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfactionCreatedBy,w.wfactionCreateddate from WFAction w where w.wfactionId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateWFAction(Object object) {
		try {
			WFAction wfaction = (WFAction) object;
			getHibernateTemplate().update(wfaction);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String wfactionName, String wstep,
			String wfactionid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WFAction w where w.wfactionId!='"
					+ wfactionid + "' and w.wfactionStepGUID='" + wstep
					+ "' and w.wfactionName='" + wfactionName + "'";
			// System.out.println(sql);
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

	public String wfactionDelete(String id) {
		String msg = null;

		try {
			WFAction wfa = new WFAction();
			wfa.setWfactionId(id);
			getHibernateTemplate().delete(wfa);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;

	}

	@Override
	public List<Object[]> setWFActionAdvanceSearch(String wfstage) {
		String hql = null;
		if (wfstage.equalsIgnoreCase("ALL")) {
			hql = "select w.wfactionId,w.wfactionStepGUID,w.wfactionAction,w.wfactionName,w.wfactionType,w.wfactionCondition,w.wfactionDirection,w.wfactionGotoStep,w.wfactionEmail,w.wfactionComments,w.wfactionMessage,w.wfactionMessageDetails,w.wfstep.wfstepName from WFAction w";
		}

		if (!wfstage.equalsIgnoreCase("ALL")) {
			hql = "select  wfactionId, wfactionStepGUID, wfactionAction, wfactionName, wfactionType, wfactionCondition, wfactionDirection, wfactionGotoStep, wfactionEmail, wfactionComments, wfactionMessage, wfactionMessageDetails, wfstep.wfstepName from WFAction where "
					+ wfstage;
		}
		// Object[] parameters = { wfstage };
		// objects = getHibernateTemplate().find(hql, wfstage);
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}
}
