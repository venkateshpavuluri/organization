/**
copyright MNTSoft
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

import com.mnt.erp.bean.VehicleType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 * @version 1.0 28-10-2013
 * @build 0.0
 * 
 */
public class VehicleTypeDaoImpl extends HibernateDaoSupport implements
		VehicleTypeDao {

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveVehicleTypeDetails(Object object, String userId,
			String userName) {
		try {
			VehicleType vehicletype = (VehicleType) object;
			id = getHibernateTemplate().save(vehicletype);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Vehicle Type",
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
	public Long duplicateVehicleTypeCheck(String vehicletype) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from VehicleType r where  r.vehicletype='"
					+ vehicletype + "'";
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
	public List<Object[]> searchVehicleType() {

		try {

			String hql = "select r.vehicletypeId,r.vehicletype from VehicleType r order by r.vehicletype";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchVehicleTypeWithName(String vehicletypename) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.vehicletypeId,r.vehicletype from VehicleType r where r.vehicletypeId="
					+ vehicletypename + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVehicleTypeNames() {
		String sql = null;
		try {
			sql = "select r.vehicletypeId, r.vehicletype from VehicleType r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchVehicleTypeWithId(String id) {
		List<Object[]> objects = null;
		try {

			String hql = "select r.vehicletypeId,r.vehicletype from VehicleType r where r.vehicletypeId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateVehicleType(Object object) {
		try {
			VehicleType vehicletype = (VehicleType) object;

			getHibernateTemplate().update(vehicletype);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String vehicletype, int vehicletypeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from VehicleType r where  r.vehicletype='"
					+ vehicletype + "' and r.vehicletypeId!='" + vehicletypeid
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

	public String vehicletypeDelete(int id) {
		VehicleType vehicletype = null;
		try {

			vehicletype = new VehicleType();
			vehicletype.setVehicletypeId(id);

			getHibernateTemplate().delete(vehicletype);

			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object[]> basicSearchVehicleType(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.vehicletypeId,r.vehicletype from VehicleType r where r."
					+ label + "" + operator + " ? order by r.vehicletype";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

}
