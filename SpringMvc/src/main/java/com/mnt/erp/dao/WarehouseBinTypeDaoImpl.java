/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.WarehouseBinType;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class WarehouseBinTypeDaoImpl extends HibernateDaoSupport implements WarehouseBinTypeDao{
	String msg;
	String sql;
	List<Object> list=null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Override
	public String saveWarehouseBinTypeDetails(Object object) {
		try
		{
			//System.out.println("in save of warehousebintype dao impl");
			WarehouseBinType warehousebintype=(WarehouseBinType)object;
			getHibernateTemplate().save(warehousebintype);
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
	public Long duplicateWarehouseBinTypeCheck(String warehousebintype) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from WarehouseBinType r where  r.warehousebintype='" + warehousebintype+ "'";
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
	public List<Object[]> searchWarehouseBinType() {
	
	try
	{
		System.out.println("in search of warehousebin type");
		String hql="select r.warehousebintypeId,r.warehousebintype from WarehouseBinType r";
		System.out.println("query in search of vehilce type is "+hql);
		objects = getHibernateTemplate().find(hql);
	
 	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	
	public List<Object[]> searchWarehouseBinTypeWithName(String warehousebintypename) {
		List<Object[]> objects=null;
	try
	{
		System.out.println("warehousebintype name in search warehousebintype with name  "+warehousebintypename);
		String hql="select r.warehousebintypeId,r.warehousebintype from WarehouseBinType r where r.warehousebintypeId="+warehousebintypename+"";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	
	@Override
	public List<Object[]> selectWarehouseBinTypeNames() {
		String sql=null;
	try
	{
	sql="select r.warehousebintypeId, r.warehousebintype from WarehouseBinType r";
	objects=getHibernateTemplate().find(sql);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
		return objects;
	}
	public List<Object[]> searchWarehouseBinTypeWithId(String id) {
		List<Object[]> objects=null;
	try
	{
		System.out.println("warehousebintype id in search warehousebintype with id   "+id);
		String hql="select r.warehousebintypeId,r.warehousebintype from WarehouseBinType r where r.warehousebintypeId='"+id+"'";
		objects=getHibernateTemplate().find(hql);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return objects;
	}
	@Override
	public String updateWarehouseBinType(Object object) {
		try
		{
			WarehouseBinType warehousebintype=(WarehouseBinType)object;
		
	getHibernateTemplate().update(warehousebintype);
			msg="WarehouseBinType Details Updated Successfully";
		}
		catch(Exception e)
		{
			msg="WarehouseBinType Details Did Not Updated";
			e.printStackTrace();
		}
		
		return msg ;
	}
	
	@Override
	public Long updateDuplicateCheck(String warehousebintype,int warehousebintypeid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try
		{
			sql="select count(*) from WarehouseBinType r where  r.warehousebintype='" + warehousebintype +"' and r.warehousebintypeId!='"+warehousebintypeid+"'" ;
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
	public String warehousebintypeDelete(int id)
	{
		WarehouseBinType warehousebintype=null;
		try
		{
			warehousebintype=(WarehouseBinType)getHibernateTemplate().get(WarehouseBinType.class,id);
		
			getHibernateTemplate().delete(warehousebintype);
			warehousebintype.getWarehousebintype();
			System.out.println(	"warehousebintype deleted    "+warehousebintype.getWarehousebintype());
			msg="WarehouseBinType Details Deleted Successfully";
		}
		catch(Exception e)
		{
			msg="WarehouseBinTypes Details Did Not Deleted";
			e.printStackTrace();
		}
		return msg+","+warehousebintype.getWarehousebintype();
	}
	public List<Object[]> basicSearchWarehouseBinType(String label, String operator,
			String searchName) {
		try {
System.out.println("in basic search of warehousebin type");
			String hql = "select r.warehousebintypeId,r.warehousebintype from WarehouseBinType r where r."
					+ label + "" + operator + " ? ";
System.out.println("query in basic search is   "+hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}



}
