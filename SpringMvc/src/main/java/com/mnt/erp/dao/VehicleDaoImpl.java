/**
copyright MNT Soft
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

import com.mnt.erp.bean.Vehicle;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anikesh
 * @version 1.0 29-10-2013
 * @build 0.0
 * 
 */
public class VehicleDaoImpl extends HibernateDaoSupport implements VehicleDao {

	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	Serializable id = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveVehicleDetails(Object object, String userId,
			String userName) {
		try {
			Vehicle vehicle = (Vehicle) object;
			id = getHibernateTemplate().save(vehicle);

			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "vehicle", "ROW",
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
	public Long duplicateVehicleCheck(String registrationNum) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Vehicle r where  r.registrationNum='"
					+ registrationNum + "'";
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
	public List<Object[]> selectVehicleTypeIds() {
		String sql = null;
		try {
			sql = "select v.vehicletypeId, v.vehicletype from VehicleType v";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	@Override
	public List<Object[]> searchVehicle() {

		try {
			String hql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution,v.vehicleTypeobj.vehicletype from Vehicle v";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchVehicleWithName(String regnum) {
		List<Object[]> objects = null;
		try {
			String hql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution from Vehicle v where v.vehicleId="
					+ regnum + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVehicleNames() {
		String sql = null;
		try {
			sql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution from Vehicle v";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchVehicle(String label, String operator,
			String searchName) {
		try {

			String hql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution,v.vehicleTypeobj.vehicletype from Vehicle v where v."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchVehicleWithId(String id) {
		List<Object[]> objects = null;
		try {
			String hql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution,v.createDate from Vehicle v where  v.vehicleId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateVehicle(Object object) {
		try {
			Vehicle vehicle = (Vehicle) object;

			getHibernateTemplate().update(vehicle);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String regnum, int vehicleid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Vehicle v where  v.registrationNum='"
					+ regnum + "' and  v.vehicleId!='" + vehicleid + "'";
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

	public String vehicleDelete(String id) {
		final List<Vehicle> listl = null;
		final String vehicleId = id;

		try {

			getHibernateTemplate().executeFind(new HibernateCallback() {

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String hql = "delete from Vehicle v where v.vehicleId='"
							+ vehicleId + "'";
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
	public List<Object[]> setVehicleAdvanceSearch(String wfstage) {
		String hql = null;
		if (wfstage.equalsIgnoreCase("ALL")) {
			hql = "select v.vehicleId, v.vehicleTypeId, v.vehicleMade, v.vehicleModel, v.driverId, v.registrationNum, v.permit, v.advetisementTax, v.roadTax, v.professionalTax, v.insurance, v.fitness, v.pollution,v.vehicleTypeobj.vehicletype from Vehicle v";
		}

		if (!wfstage.equalsIgnoreCase("ALL")) {
			hql = "select  vehicleId,  vehicleTypeId,  vehicleMade,  vehicleModel,  driverId,  registrationNum,  permit,  advetisementTax,  roadTax,  professionalTax,  insurance,  fitness,  pollution, vehicleTypeobj.vehicletype from Vehicle where "
					+ wfstage;
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}
}
