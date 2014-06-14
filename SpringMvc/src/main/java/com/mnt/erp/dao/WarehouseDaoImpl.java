/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.dao;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.mnt.erp.bean.StorageType;
import com.mnt.erp.bean.Warehouse;
import com.mnt.erp.bean.Warehouse;

/**
 * @author A Nikesh
 *@version 1.0 12-11-2013
 *@build 0.0
 *
 */
public class WarehouseDaoImpl extends HibernateDaoSupport implements WarehouseDao{
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Override
	public String saveWareHouseDetails(Object object) {
		try
		{
			System.out.println("in save of warehouse dao impl");
			Warehouse wareHouse=(Warehouse)object;
			getHibernateTemplate().save(wareHouse);
					msg ="success";
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			msg="failure";
		}
		return msg;
	}
	@Override
	public Long duplicateWareHouseCheck(String warehouse) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Warehouse w where  w.warehouse='" + warehouse+ "'";
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
	public List<Object[]> selectCountryIds() {
		String sql=null;
	try
	{
	sql="select c.countryId, c.countryName from CountrysList c";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchWareHouse() {
		
		try
		{
			System.out.println("in search of warehouse");
			String hql="select w.warehouseId,w.warehouse,w.address,w.city,w.state,w.countryId,w.zip,w.phone1,w.phone2,w.fax,w.countrylist.countryName from Warehouse w";
			System.out.println("query in search of warehouse is "+hql);
			objects = getHibernateTemplate().find(hql);
		
	 	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			return objects;
		}
	public List<Object[]> basicSearchWareHouse(String label, String operator,
			String searchName) {
		try {
System.out.println("in basic search of storage type");
			String hql = "select w.warehouseId,w.warehouse,w.address,w.city,w.state,w.countryId,w.zip,w.phone1,w.phone2,w.fax,w.countrylist.countryName from Warehouse w where w."
					+ label + "" + operator + " ? ";
System.out.println("query in basic search is   "+hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	@Override
	public List<Object[]> selectWareHouseNames() {
		String sql=null;
	try
	{
	sql="select w.warehouseId,w.warehouse,w.address,w.city,w.state,w.countryId,w.zip,w.phone1,w.phone2,w.fax from Warehouse w";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchWareHouseWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		System.out.println("warehouse id in search warehouse with id   "+id);
		String hql="select w.warehouseId,w.warehouse,w.address,w.city,w.state,w.countryId,w.zip,w.phone1,w.phone2,w.fax from Warehouse w where w.warehouseId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateWareHouse(Object object) {
		try
		{
			Warehouse warehouse=(Warehouse)object;
		
	getHibernateTemplate().update(warehouse);
			msg="Warehouse Details Updated Successfully";
		}
		catch(Exception e)
		{
			msg="Warehouse Details Did Not Updated";
			e.printStackTrace();
		}
		
		return msg ;
	}
	
	@Override
	public Long updateDuplicateCheck(String warehouse,int warehouseid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from Warehouse w where  w.warehouse='" + warehouse +"' and w.warehouseId!='"+warehouseid+"'" ;
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
	public String WareHouseDelete(int id)
	{
		//Warehouse warehousedel=null;
		final List<Warehouse> listl=null;
		final int warehouid=id;
		
		try
		{
			
			 getHibernateTemplate().executeFind(new HibernateCallback()
			 {
				 
		    

				@Override
				public Object doInHibernate(org.hibernate.Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String hql="delete from Warehouse ur where ur.warehouseId='"+warehouid+"'";
					Query query=session.createQuery(hql);
			         query.executeUpdate();
					return listl;
				}
		    });
			msg="Warehouse Details Deleted Successfully";
			
		}
		catch(Exception e)
		{
			msg="Warehouse Details Did Not Deleted";
			e.printStackTrace();
		}
		return msg;
	}
	
	@Override
	public List<Object[]> setWarehouseAdvanceSearch(String wfstage) {
		String hql=null;
		if(wfstage.equalsIgnoreCase("ALL"))
		{
			hql="select w.warehouseId,w.warehouse,w.address,w.city,w.state,w.countryId,w.zip,w.phone1,w.phone2,w.fax,w.countrylist.countryName from Warehouse w";
	   // System.out.println("vendorin Empty");
		}
		
		if(!wfstage.equalsIgnoreCase("ALL"))
		{	
		hql="select  warehouseId, warehouse, address, city, state, countryId, zip, phone1, phone2, fax, countrylist.countryName from Warehouse where "+wfstage;
		//System.out.println("Kiran Non Empty"+hql);
		}
		//Object[] parameters = { wfstage };
		//objects = getHibernateTemplate().find(hql, wfstage);
	 List<Object[]> list=getHibernateTemplate().find(hql);
		
		/*for (Object[] objects : list) {
			System.out.println("with in the dao for Material Search=="+objects);
		}*/
		//System.out.println("with in the dao for Bom Search=="+list);
			return list;	
		
		
	}


}
