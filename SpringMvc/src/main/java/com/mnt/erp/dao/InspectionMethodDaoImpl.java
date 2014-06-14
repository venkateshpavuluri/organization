package com.mnt.erp.dao;
/*
@author Srinivas
@version 1.0   
*/
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.InspectionMethodBean;
import com.mnt.erp.bean.ProcessBean;
import com.mnt.erp.service.AuditLogService;

public class InspectionMethodDaoImpl extends HibernateDaoSupport implements InspectionMethodDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> list=null;
	@Override
	public String saveInspectionMethod(Object object,String userId,String userName) {
		try{
			InspectionMethodBean methodBean=(InspectionMethodBean) object;
			Serializable id=getHibernateTemplate().save(methodBean);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Agreement Type",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}

	@Override
	public List<Object[]> searchInspectionMethodWithId(int id) {
		try{
			String hql="select i.inspectionmethodid,i.inspectionmethod from InspectionMethodBean i where i.inspectionmethodid="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	public List<Object[]> searchInspectionMethod() {
		try{
			String hql="select i.inspectionmethodid,i.inspectionmethod from InspectionMethodBean i order by i.inspectionmethod ";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public List<Object[]> selectInspectionMethod() {
		try{
			String hql="select i.inspectionmethodid,i.inspectionmethod from InspectionMethodBean i";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateInspectionMethod(Object object) {
		try{
			InspectionMethodBean methodBean=(InspectionMethodBean)object;
			getHibernateTemplate().update(methodBean);
			msg="S";
			
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteInspectionMethod(int id) {
		try{
			InspectionMethodBean methodBean=(InspectionMethodBean)getHibernateTemplate().get(InspectionMethodBean.class, id);
			getHibernateTemplate().delete(methodBean);
			msg="S";
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getInspectionMethodCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from InspectionMethodBean i where i.inspectionmethod='"+name+"'";
			List<Object> list=getHibernateTemplate().find(sql);
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				p=(Long)object;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public Long getInspectionMethodCountedit(String name, int imid) {
		Iterator<Object> iterator=null;
		Long im=1L;
		try{
		String	sql="select count(*) from InspectionMethodBean i where i.inspectionmethod='"+name+"'and i.inspectionmethodid !='"+imid+"'";
			List<Object> list=getHibernateTemplate().find(sql);
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				im=(Long)object;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return im;
	}
	public List<Object[]> basicSearchInspectionMethod(String label,String operator,String searchName){
		try {

			String hql = "select i.inspectionmethodid,i.inspectionmethod from InspectionMethodBean i where i."
					+ label + "" + operator + " ? order by i.inspectionmethod ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
