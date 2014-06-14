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

import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.service.AuditLogService;

/**
 * @author pvenkateswarlu
 *@version 1.0 19-09-2013
 */
public class OrganizationTypeDaoImpl extends HibernateDaoSupport implements OrganizationTypeDao {
	
	@Autowired
	AuditLogService auditLogService;
	String sql=null;
	List<Object[]> list=null;
	@Override
	public List<Object[]> getOrganizationTypeIds() {
		// TODO Auto-generated method stub
		
		List<Object[]> list=null;
		try
		{
			sql="select o.orgTypeId,o.orgType from OrganizationType o";
			 list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String saveOrganizationType(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
	OrganizationType organizationType=null;
	Serializable id=null;
	String msg=null;
		try
		{
			organizationType=(OrganizationType)object;
			id=getHibernateTemplate().save(organizationType);
			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Organization Type","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
	msg="S";
			}
		
		}
		catch(Exception e)
		{
			msg="F";
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Object[]> searchOrganizationType() {
		// TODO Auto-generated method stub
		
		
		try
		{
			sql="select o.orgTypeId,o.orgType from OrganizationType o order by o.orgType asc";
			list=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchOrganizationTypeWithId(int id) {
		// TODO Auto-generated method stub
		try
		{
			sql="select o.orgTypeId,o.orgType from OrganizationType o where o.orgTypeId="+id+"";
			list=getHibernateTemplate().find(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateOrganization(Object object) {
		// TODO Auto-generated method stub
		OrganizationType organizationType=null;
		String succ="";
		try
		{
			organizationType=(OrganizationType)object;
			getHibernateTemplate().update(organizationType);
			succ="S";
		}
		catch(Exception e)
		{
			succ="F";
			e.printStackTrace();
		}
		return succ;
	}

	@Override
	public String deleteOrganizationType(Object object) {
		// TODO Auto-generated method stub
		OrganizationType organizationType=null;
		OrganizationType type=null;
		int id=0;
		String msg;
		try
		{
			
		organizationType=(OrganizationType)object;
		getHibernateTemplate().delete(organizationType);
		/*	id=organizationType.getOrgTypeId();
			type=(OrganizationType)getHibernateTemplate().get(OrganizationType.class, id);
			getHibernateTemplate().delete(entity)*/
		msg="S";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			msg="F";
		}
		return msg;
	}

	@Override
	public Long duplicateCheck(String orgType) {
		// TODO Auto-generated method stub
		Iterator<Object> iterator = null;
		Long i = 0l;
		try {
			sql = "select count(*) from OrganizationType o where  o.orgType='" + orgType
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
	public Long updateDuplicateCheck(String orgTypeName, int orgTypeId) {
		// TODO Auto-generated method stub
		Iterator<Object> iterator = null;
		Long i = 0l;
		try {
			sql = "select count(*) from OrganizationType o where  o.orgType='" + orgTypeName
					+ "' and o.orgTypeId!="+orgTypeId+"";
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
	public List<Object[]> basicSearchOrgType(String label, String operator,
			String searchName){
		try {

			String hql = "select o.orgTypeId,o.orgType from OrganizationType o where o."
					+ label + "" + operator + " ? order by o.orgType";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
