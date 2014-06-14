package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.MaintenancePlan;


public class MaintenancePlanDaoImpl extends HibernateDaoSupport implements MaintenancePlanDao {

	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckMaintenancePlan(String equipment,String planedDate,int maintenancePlanId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenancePlan m where m.equipment_Id='"
					+ equipment + "' and m.plannedDT!='" + planedDate + "' and m.maintenancePlan_Id!='" + maintenancePlanId + "'";
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

	public Long checkMaintenancePlanCout(String equipment,String planedDate){

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenancePlan m where m.equipment_Id='"
					+ equipment + "' and m.plannedDT!='" + planedDate + "'";
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

	public String saveMaintenancePlanDetails(Object object) {
		try {
			MaintenancePlan maintenancePlan = (MaintenancePlan) object;
			Serializable id=getHibernateTemplate().save(maintenancePlan);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchMaintenancePlan() {

		try {
			String hql = "select q.maintenancePlan_Id,q.mainTypeBean,q.plant,q.equipmentBean,q.plannedDT,q.shift,q.description,q.status from MaintenancePlan q";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchMaintenancePlanWithId(int id) {
		try {
			String hql = "select q.maintenancePlan_Id,q.maintenanceType_Id,q.plant_Id,q.equipment_Id,q.plannedDT,q.shift_Id,q.description,q.status_Id from MaintenancePlan q where q.maintenancePlan_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateMaintenancePlan(Object object) {
		try {
			MaintenancePlan updateMaintenancePlan = (MaintenancePlan) object;
			getHibernateTemplate().update(updateMaintenancePlan);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteMaintenancePlan(int id) {

		try {
			MaintenancePlan maintenancePlan=new MaintenancePlan();
			maintenancePlan.setMaintenancePlan_Id(id);
			getHibernateTemplate().delete(maintenancePlan);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectMaintenancePlan() {
		String sql = null;
		try {
			sql = "select atb.assertTypeId, atb.assertTypeName from  AssertTypeBean atb";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectMaintenanceType() {
		String sql = null;
		try {
			sql = "select m.maintenanceTypeId, m.maintenanceType from  maintenanceTypeBean m";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public List<Object[]> selectEquipment() {
		String sql = null;
		try {
			sql = "select e.equipmentId, e.equipmentName from EquipmentBean e";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public List<Object[]> selectShift() {
		
		String sql = null;
		try {
			sql = "select s.shiftId, s.shift from ShiftBean s";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchMaintenancePlan(String label,String operator,String searchName) {
		try {

			String hql = "select q.maintenancePlan_Id,q.mainTypeBean,q.plant,q.equipmentBean,q.plannedDT,q.shift,q.description,q.status from MaintenancePlan q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	
	
}
