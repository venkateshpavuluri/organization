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
import com.mnt.erp.bean.EmployeeTimeSheet;
import com.mnt.erp.service.AuditLogService;

public class EmpTimeSheetDaoImpl extends HibernateDaoSupport implements EmpTimeSheetDao {
	@Autowired
	AuditLogService auditLogService;
	
	String brmessage;
	List<Object[]> list=null;
	@Override
	public String saveEmpTimeSheet(Object btObject,String userId,String userName) {
		// TODO Auto-generated method stub
		try{
			EmployeeTimeSheet eBean=(EmployeeTimeSheet)btObject;
		Serializable id=getHibernateTemplate().save(eBean);
		if(id!=null)
		{
			Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","EmpTimeSheet","ROW" ,String.valueOf(id),"1",modifiedDate,userName);		
		}
			brmessage="S";
		}catch(Exception e){
			e.printStackTrace();
			brmessage="F";
		}
		return brmessage;
	}
	@Override
public List<Object[]> selectEmpTimeSheet() {
	try{
		String hql="select s.employeeTimeSheet_Id,s.empBean from EmployeeTimeSheet s";
		list=getHibernateTemplate().find(hql);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchEmpTimeSheetWithId(int id ) {
	
		try{
			String hql="select s.employeeTimeSheet_Id,s.employee,s.timeSheetDT,s.activity,s.timeSpent from EmployeeTimeSheet s where s.employeeTimeSheet_Id="+id+"";
			list=getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchEmpTimeSheet() {
	try{
		String hql="select s.employeeTimeSheet_Id,s.empBean,s.timeSheetDT,s.activityBean,s.timeSpent from EmployeeTimeSheet s";
		list=getHibernateTemplate().find(hql);
	}catch(Exception e){
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public String updateEmpTimeSheet(Object btObject) {
		try{
			EmployeeTimeSheet btbean=(EmployeeTimeSheet)btObject;
			int id = btbean.getEmployeeTimeSheet_Id();
			EmployeeTimeSheet btime = (EmployeeTimeSheet) getHibernateTemplate().get(
					EmployeeTimeSheet.class, id);
			
			btime.setEmployeeTimeSheet_Id(btbean.getEmployeeTimeSheet_Id());
			btime.setEmployee(btbean.getEmployee());
			btime.setTimeSheetDT(btbean.getTimeSheetDT());
			btime.setActivity(btbean.getActivity());
			btime.setTimeSpent(btbean.getTimeSpent());
          				
			getHibernateTemplate().update(btime);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}

	@Override
	public String deleteEmpTimeSheet(int id) {
		
		try{
			EmployeeTimeSheet btbean=(EmployeeTimeSheet)getHibernateTemplate().get(EmployeeTimeSheet.class, id);
			getHibernateTemplate().delete(btbean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "S";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getEmpTimeSheetCount(String name) {
		Iterator<Object> iterator=null;
		Long p=1L;
		try{
		String	sql="select count(*) from EmployeeTimeSheet s where  s.employee='"+name+"'";
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
	public Long getEmpTimeSheetCountEdit(String name,int empSheetid) {
		Iterator<Object> iterator=null;
		Long count=null;
		try{
			final String	sql="select count(*) from EmployeeTimeSheet s where  s.employee ='"+name+"' and s.employeeTimeSheet_Id!='"+empSheetid+"' ";
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

		
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchEmpTimeSheet(String label, String operator,
			String searchName) {
		try {

			String hql = "select s.employeeTimeSheet_Id,s.empBean,s.timeSheetDT,s.activityBean,s.timeSpent from EmployeeTimeSheet s where s."
					+ label + "" + operator + " ?  ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getEmployeeIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select o.employee_Id,o.fName from Employee o";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getActivityIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select s.activityId,s.activity from ActivityBean s";
			list = getHibernateTemplate().find(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
