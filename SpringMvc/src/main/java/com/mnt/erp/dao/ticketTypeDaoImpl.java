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

import com.mnt.erp.bean.PayModeBean;
import com.mnt.erp.bean.TicketTypeBean;
import com.mnt.erp.service.AuditLogService;

/**
 * @author devi
 *
 */
public class ticketTypeDaoImpl extends HibernateDaoSupport implements ticketTypeDao{
	String success;
	List<Object[]> objects = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	public Long updateCheckTicketType(String ticketType, int ticketTypeId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from TicketTypeBean at where  at.ticketType ='"
					+ ticketType + "' and at.ticketType_Id!='" + ticketTypeId + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public Long checkTicketTypeCount(String ticketType) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from TicketTypeBean at where  at.ticketType='"
					+ ticketType + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String saveTicketTypeDetails(Object object, String userId,
			String userName) {
		try {
			TicketTypeBean tBean = (TicketTypeBean) object;
			id = getHibernateTemplate().save(tBean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "ticketType", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	public List<Object[]> searchTicketType() {

		try {
			String hql = "select q.ticketType_Id,q.ticketType from TicketTypeBean q order by q.ticketType";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchTicketTypeWithId(int id) {
		try {
			String hql = "select q.ticketType_Id,q.ticketType from TicketTypeBean q where q.ticketType_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateTicketType(Object object) {
		try {
			TicketTypeBean updatetic = (TicketTypeBean) object;
			getHibernateTemplate().update(updatetic);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "S";
	}

	public String deleteTicketType(int id) {

		try {
			TicketTypeBean deletetic = getHibernateTemplate().get(
					TicketTypeBean.class, id);
			getHibernateTemplate().delete(deletetic);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

	

	public List<Object[]> basicSearchTicketType(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.ticketType_Id,q.ticketType from TicketTypeBean q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}


}
