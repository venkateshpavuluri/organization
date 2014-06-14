package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspectionPlan;
import com.mnt.erp.bean.InspectionPlanLine;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ProcessDetailBean;

public class InspectionPlanDaoImpl extends HibernateDaoSupport implements InspectionPlanDao{
	
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckInspectionPlan(String equipment,int id) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from InspectionPlan at where  at.materialId ='"
					+ equipment + "' and at.inspectionPlanId!='" + id + "'";
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

	public Long checkInspectionPlan(String equipment) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from InspectionPlan g where  g.materialId='"
					+ equipment + "'";
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

	public String saveInspectionPlanDetails(Object object) {
		try {
			InspectionPlan InspectionPlanBean = (InspectionPlan) object;
			Serializable id=getHibernateTemplate().save(InspectionPlanBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchInspectionPlan() {

		try {
			String hql = "select r.inspectionPlanId,r.material,r.insplotOrgin from InspectionPlan r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<InspectionPlan> searchInspectionPlanWithId(int id) {
		List<InspectionPlan> object=null;
		try {
			String hql = "from InspectionPlan r where r.inspectionPlanId="
					+ id + " ";
			object = getHibernateTemplate().find(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateInspectionPlan(Object object) {
			
		InspectionPlanLine pc = null;
		Iterator<InspectionPlanLine> iterator1 = null;
		InspectionPlanLine pLine = null;
		List<InspectionPlanLine> list2 = null;
		try {
System.out.println("this is dao");
			InspectionPlan pg = (InspectionPlan) object;
			int id = pg.getInspectionPlanId();
			System.out.println("the dao id is:"+id);
			
		
			InspectionPlan po = (InspectionPlan) getHibernateTemplate().get(
					InspectionPlan.class, id);
			list2 = po.getInspectionPlanLine();
System.out.println("the dao list size:"+list2.size());
			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (InspectionPlanLine) o;
				pc = new InspectionPlanLine();
				System.out.println("the line id:"+pLine.getInspectionPlanLineId());
				pc.setInspectionPlanLineId(pLine.getInspectionPlanLineId());
		        pc.setProcessDetailBean(new ProcessDetailBean());
		        pc.setInspectionCharacteristic(new InspCharacteristic());
		        pc.setEquipment(new EquipmentBean());
			
				//getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public String deleteInspectionPlan(int id) {
	
		InspectionPlanLine ins=null;
	List<InspectionPlanLine> list=null;
	try {
		list=new ArrayList<InspectionPlanLine>();
		InspectionPlan insBean=(InspectionPlan)getHibernateTemplate().get(InspectionPlan.class, id);
		insBean.setMaterial(new Material());
		insBean.setInsplotOrgin(new InsplotOrigin());
		
		List<InspectionPlanLine> beans=insBean.getInspectionPlanLine();
		Iterator<InspectionPlanLine> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			ins=(InspectionPlanLine)iterator.next();
			ins.setProcessDetailBean(new ProcessDetailBean());
			ins.setInspectionCharacteristic(new InspCharacteristic());
			ins.setEquipment(new EquipmentBean());
			
	
			list.add(ins);
		}
		insBean.setInspectionPlanLine(list);

	getHibernateTemplate().delete(insBean);
	msg="S";

		
	} catch (Exception e) {
		msg="F";
		e.printStackTrace();

	}
	return msg;
			}


	public List<Object[]> selectStatus() {
		String sql = null;
		try {
			sql = "select statusId,status from Status";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectEquipment() {
		String sql = null;
		try {
			sql = "select equipmentId,equipmentName from EquipmentBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectMaintenanceCategory() {
		String sql = null;
		try {
			sql = "select maintenanceCategoryId,maintenanceCategory from MaintenanceCategory";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectMaintenanceType() {
		String sql = null;
		try {
			sql = "select maintenanceTypeId,maintenanceType from maintenanceTypeBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	
	public List<Object[]> basicSearchInspectionPlan(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.inspectionPlanId,r.material,r.insplotOrgin from InspectionPlan r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteInspectionPlanDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			InspectionPlanLine line=new InspectionPlanLine();
			line.setInspectionPlanLineId(kk);
			line.setProcessDetailBean(new ProcessDetailBean());
			line.setInspectionCharacteristic(new InspCharacteristic());
			line.setEquipment(new EquipmentBean());
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
