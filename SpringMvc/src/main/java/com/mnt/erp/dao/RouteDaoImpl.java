/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Route;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 * 
 */
public class RouteDaoImpl extends HibernateDaoSupport implements RouteDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveRouteDetails(Object object, String userId, String userName) {
		try {
			Route route = (Route) object;
			id = getHibernateTemplate().save(route);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "route", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}
			msg = "S";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateRouteCheck(String routeCode) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Route r where  r.routeCode='"
					+ routeCode + "'";
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
	public List<Object[]> selectOrganizationIds() {
		String sql = null;
		try {
			sql = "select o.orgId, o.orgName from Organization o";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> selectUomIds() {
		String sql = null;
		try {
			sql = "select u.uom_Id, u.uom from Uom u";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> searchRoute() {

		try {

			String hql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId, r.organizationBean.orgName,r.uomBean.uom, r.timeuomBean.uom from Route r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchRouteWithName(String regnum) {
		List<Object[]> objects = null;
		try {
			String hql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId from Route r where r.routeId="
					+ regnum + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectRouteNames() {
		String sql = null;
		try {
			sql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId from Route r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchRoute(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId, r.organizationBean.orgName,r.uomBean.uom, r.timeuomBean.uom from Route r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchRouteWithId(String id) {
		List<Object[]> objects = null;
		try {
			String hql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId from Route r where  r.routeId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateRoute(Object object) {
		try {
			Route route = (Route) object;

			getHibernateTemplate().update(route);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String rotCode, int routeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Route r where  r.routeCode='" + rotCode
					+ "' and  r.routeId!='" + routeid + "'";
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

	public String routeDelete(String id) {
		final List<Route> listl = null;
		final String routeId = id;

		try {

			getHibernateTemplate().executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String hql = "delete from Route v where v.routeId='"
							+ routeId + "'";
					Query query = session.createQuery(hql);
					query.executeUpdate();
					return listl;
				}
			});
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> setRouteAdvanceSearch(String route) {
		String hql = null;
		if (route.equalsIgnoreCase("ALL")) {
			hql = "select r.routeId, r.routeCode, r.organizationId, r.fromPlace, r.toPlace, r.distance, r.uomId,r.approxTime,r.timeUomId, r.organizationBean.orgName,r.uomBean.uom, r.timeuomBean.uom from Route r";
		}

		if (!route.equalsIgnoreCase("ALL")) {
			hql = "select  routeId,  routeCode,  organizationId,  fromPlace,  toPlace,  distance,  uomId,  approxTime,timeUomId, organizationBean.orgName, uomBean.uom,  timeuomBean.uom from Route  where "
					+ route;
		}
		// Object[] parameters = { wfstage };
		// objects = getHibernateTemplate().find(hql, wfstage);
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
