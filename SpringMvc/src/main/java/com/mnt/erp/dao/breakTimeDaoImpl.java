/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.BreakTimeBean;
import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.service.AuditLogService;


/**
 * @author devi
 *
 */
public class breakTimeDaoImpl extends HibernateDaoSupport implements breakTimeDao{
	@Autowired
	AuditLogService auditLogService;
	
	String brmessage;
	List<Object[]> list=null;
	@Override
	public String saveBreakTime(Object btObject,String userId,String userName) {
		// TODO Auto-generated method stub
		try{
			BreakTimeBean btbean=(BreakTimeBean)btObject;
		Serializable id=	getHibernateTemplate().save(btbean);
		if(id!=null)
		{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Break Time","ROW" ,String.valueOf(id),"1",modifiedDate,userName);		
		}
			brmessage="S";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@Override
public List<Object[]> selectBreakTime() {
	try{
		String hql="select s.breakTimeId,s.breakTimecode from BreakTimeBean s";
		list=getHibernateTemplate().find(hql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchBreakTimeWithId(int id ) {
	
		try{
			String hql="select s.breakTimeId,s.breakTimecode,s.starttime,s.endtime,s.length,s.shift,s.organization from BreakTimeBean s where s.breakTimeId="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchBreakTime() {
	try{
		String hql="select s.breakTimeId,s.breakTimecode,s.starttime,s.endtime,s.length,s.shiftBean,s.orgBean from BreakTimeBean s order by s.breakTimecode";
		list=getHibernateTemplate().find(hql);
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public String updateBreakTime(Object btObject) {
		try{
			BreakTimeBean btbean=(BreakTimeBean)btObject;
			int id = btbean.getBreakTimeIdEdit();
			BreakTimeBean btime = (BreakTimeBean) getHibernateTemplate().get(
					BreakTimeBean.class, id);
          
			btime.setBreakTimeId(btbean.getBreakTimeIdEdit());
			btime.setBreakTimecode(btbean.getBreakTimecodeEdit());
			btime.setStarttime(btbean.getStarttimeEdit());
			btime.setEndtime(btbean.getEndtimeEdit());
			btbean.setLength(btbean.getLengthEdit());
			btime.setShift(btbean.getShiftEdit());
			btime.setOrganization(btbean.getOrganizationEdit());
			
			getHibernateTemplate().update(btime);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "BreakTime Details Updated Successfully";
	}

	@Override
	public String deleteBreakTime(int id) {
		
		try{
			BreakTimeBean btbean=(BreakTimeBean)getHibernateTemplate().get(BreakTimeBean.class, id);
			getHibernateTemplate().delete(btbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getBreakTimeCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from BreakTimeBean s where  s.breakTimecode='"+name+"'";
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
	
	//@SuppressWarnings("unchecked")
	public Long getBreakTimeCountedit(String name,int breakTimeid) {
		Iterator<Object> iterator=null;
		Long count=null;
		try{
			final String	sql="select count(*) from BreakTimeBean s where  s.breakTimecode ='"+name+"' and s.breakTimeId!='"+breakTimeid+"' ";
		System.out.println("the sql:"+sql);
		    
		count = (Long) getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(
							org.hibernate.Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						org.hibernate.Query query = session
								.createQuery(sql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}

				});

		
		
		
			/*List<Object> list=getHibernateTemplate().find(sql);
			iterator=list.iterator();
			
			while(iterator.hasNext())
			{
				Object object=(Object)iterator.next();
				p=(Long)object;
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchBreakTime(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.breakTimeId,s.breakTimecode,s.starttime,s.endtime,s.length,s.shiftBean,s.orgBean from BreakTimeBean s where s."
					+ label + "" + operator + " ? order by s.breakTimecode ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getOrganizationIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.orgId,o.orgName from Organization o";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getShiftIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.shiftId,s.shift from ShiftBean s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
