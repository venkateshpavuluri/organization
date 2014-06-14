/**
 * @Copyright MNTSOFT

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

import com.mnt.erp.bean.Plant;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */
public class PlantDaoImpl extends HibernateDaoSupport implements PlantDao {
	@Autowired
	AuditLogService auditLogService;
	
	String sql;
	List<Object[]> list=null;
	

	@Override
	public String savePlantDetails(Object object,String userId,String UserName) {
		// TODO Auto-generated method stub
		Plant plant = null;
		String msg=null;
		Serializable id=null;
		try {
			plant = (Plant) object;
			id=getHibernateTemplate().save(plant);
			
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Plant","ROW" ,String.valueOf(id),"1",modifiedDate,UserName);
			}
			
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Object[]> getPlantIds() {
		// TODO Auto-generated method stub

		List<Object[]> list = null;
		try {
			sql = "select p.plantId,p.plantName from Plant p";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public List<Object[]> searchPlantDetails() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			sql = "select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchPlantDetails(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			sql = "select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p where p.plantId="
					+ id + "";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updatePlantDetails(Object object) {
		// TODO Auto-generated method stub
		Plant plant = null;
		String msg=null;
		try {
			plant = (Plant) object;
			getHibernateTemplate().update(plant);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deletePlantDetails(Object object) {
		// TODO Auto-generated method stub
		Plant plant = null;
		String msg=null;
		try {
			plant = (Plant) object;
			getHibernateTemplate().delete(plant);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getPlantNameCount(String name) {
		// TODO Auto-generated method stub
		Iterator<Object> iterator = null;
		Long i = 0l;
		try {
			sql = "select count(*) from Plant p where  p.plantName='" + name
					+ "'";
			List<Object> list = getHibernateTemplate().find(sql);
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
	public Long updateDuplicate(String plantName, int plantId) {
		// TODO Auto-generated method stub
		
		Iterator<Object> iterator = null;
		Long dupId = 0l;
		try {
			sql = "select count(*) from Plant p where  p.plantName='" + plantName
					+ "' and p.plantId!="+plantId+"";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				dupId = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dupId;
	}
	
	
	@Override
	public List<Object[]> selectPlantDetails() {

	try
	{
		
		String sql="select p.plantId,p.plantName from Plant p";
		list=getHibernateTemplate().find(sql);
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}
		return list;
	}
	
	public List<Object[]> basicSearchPlant(String label, String operator,
			String searchName){
		try {

			String hql = "select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p where p."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> plantAdvanceSearch(String plant) {
		// TODO Auto-generated method stub
		String hql=null;
		if(plant.equalsIgnoreCase("ALL"))
		{
			hql="select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p";
	 
		}
		
		if(!plant.equalsIgnoreCase("ALL"))
		{	
		hql="select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p where "+plant;
		
		}
		
	 List<Object[]> list=getHibernateTemplate().find(hql);
	
			return list;	
	}
	@Override
	public List<Object[]> setPlantSearch(String plant) {
		String hql = null;
		if (plant.equalsIgnoreCase("ALL")) {
			hql = "select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p";

		}
		if (!plant.equalsIgnoreCase("ALL")) {
			hql = "select p.plantId ,p.plantName,p.add1,p.add2,p.add3,p.city,p.state,p.phone,p.fax,p.mobile,p.organization,p.countrysList from Plant p where+"
					+ plant + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

}
