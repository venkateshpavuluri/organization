package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.DefectTypeBean;
import com.mnt.erp.bean.InspectionMethodBean;
import com.mnt.erp.service.AuditLogService;

public class DefectTypeDaoImpl  extends HibernateDaoSupport implements DefectTypeDao{
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list=null;
	String msg=null;
	@Override
	public String saveDefectType(Object object,String userId, String userName) {
		try{
			DefectTypeBean methodBean=(DefectTypeBean) object;
			Serializable id=getHibernateTemplate().save(methodBean);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Defect Type",
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
	public List<Object[]> searchDefectTypeWithId(int id) {
		try{
			String hql="select d.defecttypeid,d.defecttype from DefectTypeBean d where d.defecttypeid="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchDefectType() {
		try{
			String hql="select d.defecttypeid,d.defecttype from DefectTypeBean d order by d.defecttype ";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public List<Object[]> selectDefectType() {
		try{
			String hql="select d.defecttypeid,d.defecttype from DefectTypeBean d ";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateDefectType(Object object) {
		try{
			DefectTypeBean methodBean=(DefectTypeBean)object;
			getHibernateTemplate().update(methodBean);
			msg="S";
			
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteDefectType(int id) {
		try{
			DefectTypeBean methodBean=(DefectTypeBean)getHibernateTemplate().get(DefectTypeBean.class, id);
			getHibernateTemplate().delete(methodBean);
			msg="S";
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
		}
		return msg;
				}

	@Override
	public Long getDefectTypeCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from DefectTypeBean d where d.defecttype='"+name+"'";
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
	public Long getDefectTypeCountedit(String name, int dtid) {
		Iterator<Object> iterator=null;
		Long im=1L;
		try{
		String	sql="select count(*) from DefectTypeBean d where d.defecttype='"+name+"'and d.defecttypeid !='"+dtid+"'";
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

	@Override
	public List<Object[]> basicSearchDefectType(String label, String operator,
			String searchName) {
		try {

			String hql = "select d.defecttypeid,d.defecttype from DefectTypeBean d where d."
					+ label + "" + operator + " ? order by d.defecttype";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
