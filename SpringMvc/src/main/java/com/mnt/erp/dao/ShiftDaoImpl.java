package com.mnt.erp.dao;

/*
 @author Srinivas
 @version 1.0   
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.service.AuditLogService;

public class ShiftDaoImpl extends HibernateDaoSupport implements ShiftDao {
	@Autowired
	AuditLogService auditLogService;
	String shiftmessage;
	List<Object[]> list = null;

	@Override
	public String saveShift(Object shiftObject, String userId, String userName) {
		// TODO Auto-generated method stub
		try {
			ShiftBean shiftbean = (ShiftBean) shiftObject;
			Serializable id = getHibernateTemplate().save(shiftbean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Shift", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
				shiftmessage = "S";
			}

		} catch (Exception e) {
			shiftmessage = "F";
			e.printStackTrace();
		}
		return shiftmessage;
	}

	@Override
	public List<Object[]> selectShift() {
		try {
			String hql = "select s.shiftId,s.shiftcode from ShiftBean s";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchShiftWithId(int id) {

		try {
			String hql = "select s.shiftId,s.shiftcode,s.shift,s.starttime,s.endtime,s.workhrs from ShiftBean s where s.shiftId="
					+ id + "";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchShift() {
		try {
			String hql = "select s.shiftId,s.shiftcode,s.shift,s.starttime,s.endtime,s.workhrs  from ShiftBean s order by s.shift";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateShift(Object shiftupdate) {
		String upMsg = null;
		try {
			ShiftBean shiftBean = (ShiftBean) shiftupdate;
			getHibernateTemplate().update(shiftBean);
			upMsg = "S";

		} catch (Exception e) {
			upMsg = "F";
			e.printStackTrace();
		}
		return upMsg;
	}

	@Override
	public String deleteShift(int id) {
		String sucMsg = null;

		try {
			ShiftBean shiftBean = new ShiftBean();
			shiftBean.setShiftId(id);
			getHibernateTemplate().delete(shiftBean);
			sucMsg = "S";
		} catch (Exception e) {
			sucMsg = "F";
			e.printStackTrace();
		}
		return sucMsg;
	}

	@Override
	public Long getShiftCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from ShiftBean s where  s.shiftcode='"
					+ name + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public Long getShiftCountedit(String name, int shiftid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from ShiftBean s where  s.shiftcode ='"
					+ name + "' and s.shiftId!='" + shiftid + "' ";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Object[]> basicSearchShift(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.shiftId,s.shiftcode,s.shift,s.starttime,s.endtime,s.workhrs  from ShiftBean s where s."
					+ label + "" + operator + " ? order by s.shift";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
