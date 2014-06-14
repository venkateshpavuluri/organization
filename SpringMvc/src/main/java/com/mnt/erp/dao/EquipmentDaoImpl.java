/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ConditionBean;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.EquipmentDocument;

/**
 * @author madhav
 *
 */
public class EquipmentDaoImpl extends HibernateDaoSupport implements EquipmentDao{
	
	//instance variables
	String msg=null;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public List<Object[]> selectEquipment() {
		return null;
	}

	//Method for Checking Duplicates
	@Override
	public int updateCheckEquipment(String equipmentName, int equipmentId) {
		try {
			String sql = "select count(*) from EquipmentBean eb where  eb.equipmentName='"
					+ equipmentName + "' and eb.equipmentId!='" + equipmentId + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return  l.intValue();
	}

	//Method for Checking duplicates in add mode
	@Override
	public Long addCheckEquipment(String equipmentName) {
		try {
			String sql = "select count(*) from EquipmentBean eb where  eb.equipmentName='"
					+ equipmentName + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveEquipment(Object object) {
		try {
			EquipmentBean equipmentBean = (EquipmentBean) object;
			Serializable id=getHibernateTemplate().save(equipmentBean);
			if(id!=null){
				msg="S";
			}
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	//Method for Searching Equipment
	@Override
	public List<Object[]> searchEquipment() {
		try {
			String hql = "select q.equipmentId,q.equipmentName,q.equipmentCategoryChild,q.make,q.model,q.powerConsumptionInHours,q.productionCapacity,q.validFrom,q.validTo,q.workInstruction from EquipmentBean q";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchEquipmentWithId(int id) {
		try {
			String hql = "select q.equipmentId,q.equipmentName,q.equipmentCategoryId,q.make,q.model,q.powerConsumptionInHours,q.productionCapacity,q.validFrom,q.validTo,q.workInstruction from EquipmentBean q where q.equipmentId="

					+ id + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateEquipment(Object object) {
		try {
			EquipmentBean equipmentBeanUpdate = (EquipmentBean) object;
			getHibernateTemplate().update(equipmentBeanUpdate);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteEquipment(int id) {
		try {
			EquipmentBean deleteEquipment = getHibernateTemplate().get(
					EquipmentBean.class, id);
			getHibernateTemplate().delete(deleteEquipment);
			msg="S";
			
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	@Override
	public List<Object[]> selectEquipmentCategory() {
		try {
			String hql = "select ec.equipmentCategoryId,ec.equipmentCategory from EquipmentCategory ec ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchEquipment(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.equipmentId,q.equipmentName,q.equipmentCategoryChild,q.make,q.model,q.powerConsumptionInHours,q.productionCapacity,q.validFrom,q.validTo,q.workInstruction from EquipmentBean q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String saveEquipmentDocuments(Object object) {
		try {
			EquipmentDocument equipmentDocBean = (EquipmentDocument) object;
		Serializable id=getHibernateTemplate().save(equipmentDocBean);
		System.out.println("equip doc id iss==="+id);
		msg="S";

		} catch (Exception e) {
			msg="F";
			
			e.printStackTrace();

		}
		return msg;
	}

}
