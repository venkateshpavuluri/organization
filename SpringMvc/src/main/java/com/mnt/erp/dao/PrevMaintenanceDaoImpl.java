/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.MaintenanceCategory;
import com.mnt.erp.bean.PrevMaintenance;
import com.mnt.erp.bean.PrevMaintenanceSchCat;
import com.mnt.erp.bean.maintenanceTypeBean;

/**
 * @author tparvathi
 *
 */
public class PrevMaintenanceDaoImpl extends HibernateDaoSupport implements PrevMaintenanceDao {
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckPrevMaintenance(String equipment,int id) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from PrevMaintenance at where  at.equipmentId ='"
					+ equipment + "' and at.prevMaintenanceSchId!='" + id + "'";
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

	public Long checkPrevMaintenance(String equipment) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from PrevMaintenance g where  g.equipmentId='"
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

	public String savePrevMaintenanceDetails(Object object) {
		try {
			PrevMaintenance PrevMaintenanceBean = (PrevMaintenance) object;
			Serializable id=getHibernateTemplate().save(PrevMaintenanceBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchPrevMaintenance() {

		try {
			String hql = "select r.prevMaintenanceSchId,r.prevMaintenanceSchNo,r.equipmentBean from PrevMaintenance r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<PrevMaintenance> searchPrevMaintenanceWithId(int id) {
		List<PrevMaintenance> object=null;
		try {
			String hql = "from PrevMaintenance r where r.prevMaintenanceSchId="
					+ id + " ";
			object = getHibernateTemplate().find(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updatePrevMaintenance(Object object) {
			
		PrevMaintenanceSchCat pc = null;
		Iterator<PrevMaintenanceSchCat> iterator1 = null;
		PrevMaintenanceSchCat pLine = null;
		List<PrevMaintenanceSchCat> list2 = null;
		try {

			PrevMaintenance pg = (PrevMaintenance) object;
			int id = pg.getPrevMaintenanceSchId();
			System.out.println("the dao id is:"+id);
			

			PrevMaintenance po = (PrevMaintenance) getHibernateTemplate().get(
					PrevMaintenance.class, id);
			list2 = po.getPrevMaintenanceSchCat();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (PrevMaintenanceSchCat) o;
				pc = new PrevMaintenanceSchCat();
				System.out.println("fddf"+pLine.getPrevMaintenanceSchCatId());
				pc.setPrevMaintenanceSchId(pLine.getPrevMaintenanceSchId());
			
		
			pc.setMaintenanceCategory(new MaintenanceCategory());
			pc.setMaintenanceTypeDetails(new maintenanceTypeBean());
			
				
				getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public String deletePrevMaintenance(int id) {
	
		PrevMaintenanceSchCat emp=null;
	List<PrevMaintenanceSchCat> list=null;
	try {
		list=new ArrayList<PrevMaintenanceSchCat>();
		PrevMaintenance empbean=(PrevMaintenance)getHibernateTemplate().get(PrevMaintenance.class, id);
		empbean.setEquipmentBean(new EquipmentBean());
		
		List<PrevMaintenanceSchCat> beans=empbean.getPrevMaintenanceSchCat();
		Iterator<PrevMaintenanceSchCat> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			emp=(PrevMaintenanceSchCat)iterator.next();
			emp.setMaintenanceCategory(new MaintenanceCategory());
			emp.setMaintenanceTypeDetails(new maintenanceTypeBean());
	
			list.add(emp);
		}
		empbean.setPrevMaintenanceSchCat(list);

	getHibernateTemplate().delete(empbean);
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
	
	
	
	public List<Object[]> basicSearchPrevMaintenance(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.prevMaintenanceSchId,r.prevMaintenanceSchNo,r.equipmentBean from PrevMaintenance r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deletePrevMaintenanceDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			PrevMaintenanceSchCat line=new PrevMaintenanceSchCat();
			line.setPrevMaintenanceSchCatId(kk);
			line.setMaintenanceCategory(new MaintenanceCategory());
			line.setMaintenanceTypeDetails(new maintenanceTypeBean());
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
