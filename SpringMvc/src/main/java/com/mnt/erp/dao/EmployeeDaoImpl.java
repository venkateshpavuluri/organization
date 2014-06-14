/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeManager;
import com.mnt.erp.bean.EmployeeProject;
import com.mnt.erp.bean.ItemCategory;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.PurchaseGroup;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.RFQLineBean;
import com.mnt.erp.bean.RFQType;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

/**
 * This is Employee Dao implementation.
 * 
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> objects = null;
	List<Employee> obj=null;
	public Long updateCheckEmployee(String fName,int Id) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Employee at where  at.fName ='"
					+ fName + "' and at.employee_Id!='" + Id + "'";
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

	public Long checkEmployee(String fName) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from Employee at where  at.fName='"
					+ fName + "'";
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

	public String saveEmployeeDetails(Object object,String userId,String userName) {
		try {
			Employee empBean = (Employee) object;
			Serializable id=getHibernateTemplate().save(empBean);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code Group",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchEmployee() {
		Iterator<Object[]> iterator = null;
		try {
			String hql = " from Employee e";
			objects = getHibernateTemplate().find(hql);
			while (iterator.hasNext()) {
				
				Object[] obj = (Object[]) iterator.next();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Employee> searchEmployeeWithId(int id) {
		
		try {
			String hql = "from Employee q where q.employee_Id="
					+ id + " ";

           obj = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String updateEmployee(Object object) {
		try {
			Employee bean = (Employee) object;
			getHibernateTemplate().update(bean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
	
		return msg;
	}

	public String deleteEmployee(int id) {

		
		EmployeeManager emp=null;
			Set<EmployeeManager> list=null;
			try {
				list=new HashSet<EmployeeManager>();
				Employee empbean=(Employee)getHibernateTemplate().get(Employee.class, id);
				//List<EmployeeManager> beans=empbean.getEmployeeManager();
			/*	Iterator<EmployeeManager> iterator;
=======
				Set<EmployeeManager> beans=empbean.getEmployeeManager();
				Iterator<EmployeeManager> iterator=beans.iterator();
>>>>>>> .r7729
				while(iterator.hasNext())

				{
					
					emp=(EmployeeManager)iterator.next();
					emp.setManagerDetails(new Employee());
					emp.setProjectDetails(new Project());
					list.add(emp);
				}
			//	empbean.setEmployeeManager(list);
*/		
			getHibernateTemplate().delete(empbean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
		
	}

	public List<Object[]> selectEmployee() {
		String sql = null;
		List<Object[]> objects=null;
		try
		{
			String hql="select employee_Id,employeeNo,fName ,lName,dOB,dOJ,mobile,eMail from Employee order by fName";
	        objects=getHibernateTemplate().find(hql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchEmployee(String label, String operator,
			String searchName) {
		List<Object[]> objects = null;
		try {

			String hql = " select q.employee_Id,q.employeeNo,q.fName ,q.lName,q.dOB,q.dOJ,q.mobile,q.eMail from Employee q where q."
					+ label + "" + operator + " ? order by q.fName";
  			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
     
	public List<Object[]> selectDepartmentDetails(){
		List<Object[]> list = null;
		String sql=null;
		try
		{
		  
			 sql="select departmentId,department from Department";
			 
			
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	public List<Object[]> selectEmployeeGroupDetails(){
		List<Object[]> list = null;
		String sql=null;
		try
		{
		  
			 sql="select employeeGroupId,employeeGroup from EmployeeGroup";
			 
			
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}
	
	
public List<Object[]> selectEmployees(){
	List<Object[]> list = null;
	String sql=null;
	try
	{
	  
		 sql="select employee_Id,fName from Employee";
		 
		
		list=getHibernateTemplate().find(sql);
		
	}
	catch(Exception e)

	{
		e.printStackTrace();
	}
		return list;
	
}
	
	public List<Object[]> selectProjects(){
		List<Object[]> list = null;
		String sql=null;
		try
		{
		  
			 sql="select projectId,projectName from Project";
			 
			
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
}
	public String deleteEmployeeManager(int kk){
		// TODO Auto-generated method stub
		try {
			
			EmployeeManager line=new EmployeeManager();
			line.setEmployeeManager_Id(kk);
			
			
			line.setManagerDetails(new Employee());
			line.setProjectDetails(new Project());
			
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Employee Manager Deleted Successfully";
	}
	
	public List<Object[]> selecDesignations(){
		List<Object[]> list = null;
		String sql=null;
		try
		{
		  
			 sql="select designationId,designation from Designation";
			 
			
			list=getHibernateTemplate().find(sql);
			
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
			return list;
	}

	@Override
	public String deleteEmployeeProject(int pid) {
try {
			
			EmployeeProject line=new EmployeeProject();
			line.setEmployeeProject_Id(pid);
			line.setProjectbean(new Project());
			
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Employee Project Deleted Successfully";
	}
	
}
