/**
 * 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.WorkCenter;





/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao
{
	String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	boolean flag=false;

	@Override
	public boolean saveProject(Project project)
	{
	try
		{
			getHibernateTemplate().save(project);
		    flag=true;
		}
		catch(Exception e)
		{
			flag=false;
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	
	public int duplicateCheckProject(String project, String Id) {
		try {
			String sql = null;
			if(!Id.equals(""))
			{
			sql="select count(*) from Project cb where  cb.projectName='"
					+ project + "' and cb.projectId!="+Id;
			
			}
			else
			{
				sql="select count(*) from Project cb where  cb.projectName='"
						+ project + "'";
			}
			//System.out.println("sql"+sql);
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l.intValue();

	}
	
	
/*For Selecting Org Id And ProjectGroup  */
	
	public List<Object[]> getOrgId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select o.orgId,o.orgName from Organization o "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
/*For Selecting Project Id And ProjectGroup  */
	
	public List<Object[]> getProjectId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select p.projectId,p.projectName from Project p "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
/*For Selecting Status Id And ProjectGroup  */
	
	public List<Object[]> getStatusId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select s.statusId,s.status from Status s "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
/*For Selecting Sales Order Id And Sales Order Number  */
	
	public List<Object[]> getSalesOrder(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select s.salesOrderId,s.salesOrderNo from SalesOrderBean s "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
/*For Selecting Manager Id And ProjectGroup  */
	
	public List<Object[]> getManagerId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select e.employee_Id,e.fName from Employee e "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> basicSearchProject(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		String hql="";
		try {
				if(label.equals("") && operator.equals("") && searchName.equals(""))
				{
					//hql = "select   c.projectName, c.orgId ,c.projectId,c.orgDetails,c.startDT,c.finishDT,c.managerDetails,c.statusDetails from Project c ";
					hql = "select   c.projectName, c.orgId ,c.projectId,c.orgDetails,c.startDT,c.finishDT from Project c order by c.projectName";
					objs = getHibernateTemplate().find(hql);
				}
				else
				{
			 //hql = "select c.projectName, c.orgId ,c.projectId,c.orgDetails,c.startDT,c.finishDT,c.managerDetails,c.statusDetails from Project c where c."
					hql = "select c.projectName, c.orgId ,c.projectId,c.orgDetails,c.startDT,c.finishDT from Project c where c."
					+ label + "" + operator + " ? ";
			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	public List<Object> editProject(int Id) {
		try {
		//	System.out.println("editPoWith id "+Id);
			String hql = "from Project c where c.projectId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public boolean updateProject(Project project) {
		//System.out.println("Came to Dao Of Purchase Update");
		boolean flag =false;
		try {
			/*int id = workCenter.getWorkCenter_IdEdit();

			WorkCenter wtype = (WorkCenter) getHibernateTemplate().get(
					WorkCenter.class, id);*/
			
			getHibernateTemplate().update(project);
			flag=true;

		} catch (Exception e) {
		//	System.out.println("SSSSS");
			
			
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	
	
	public boolean deleteProject(int id) {
		boolean flag=false;
		Project project = null;
		try {
			project=new Project();
			project.setProjectId(id);
			/*project = (Project) getHibernateTemplate().get(Project.class, id);
			project.setOrgDetails(new Organization());
			project.setManagerDetails(new Employee());
			
			project.setStatusDetails(new Status());*/
		    getHibernateTemplate().delete(project);
			
		flag=true;
		} catch (Exception e) {
			//e.printStackTrace();
			flag=false;
			
		}
		return flag;
	}
	

	
	
	
	

	
}
