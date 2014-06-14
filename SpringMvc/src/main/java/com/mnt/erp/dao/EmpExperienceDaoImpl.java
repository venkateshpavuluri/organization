
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.EmpExperience;


/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 */

public class EmpExperienceDaoImpl extends HibernateDaoSupport implements EmpExperienceDao
{
	String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Override
	public String saveEmpExperience(EmpExperience empExperience)
	{
	try
		{
			Serializable id=getHibernateTemplate().save(empExperience);
			if(id!=null){
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
	
	
	public int duplicateCheckEmpExperience(String empExperience,String designation_Id,String company, String Id) {
		try {
			String sql = null;
			if(!Id.equals(""))
			{
			sql="select count(*) from EmpExperience cb where  cb.employee_Id='"
					+ empExperience + "' and cb.experience_Id!="+Id+" and cb.designation_Id='"+designation_Id+"' and cb.company='"+company+"'" ;
			
			}
			else
			{
				sql="select count(*) from EmpExperience cb where  cb.employee_Id='"
						+ empExperience + "' and cb.designation_Id='"+designation_Id+"' and cb.company='"+company+"'";
			}
			System.out.println("sql"+sql);
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
	
	
/*For Selecting  */
	
	public List<Object[]> getEmpExperienceId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select m.orgId,m.orgName from Organization m";
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Object[]> basicSearchEmpExperience(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		String hql="";
		try {
			
		
		
				if(label.equals("") && operator.equals("") && searchName.equals(""))
				{
					hql = "select c.experience_Id,c.employee_Id,c.fromDT,c.todate,c.designation_Id,c.company,c.compPhone,c.referenceName,c.redDesigntion_Id,c.email,c.empDetails,c.desDetails,c.redDesDetails from EmpExperience c ";
					System.out.println("hql"+hql);
					objs = getHibernateTemplate().find(hql);
				}
				else
				{
					
			 hql = "select c.experience_Id,c.employee_Id,c.fromDT,c.todate,c.designation_Id,c.company,c.compPhone,c.referenceName,c.redDesigntion_Id,c.email,c.empDetails,c.desDetails,c.redDesDetails from EmpExperience c where c."
					+ label + "" + operator + " ? ";
			 System.out.println("hql"+hql);
			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	public List<Object> editEmpExperience(int Id) {
		try {
		//	System.out.println("editPoWith id "+Id);
			String hql = "from EmpExperience c where c.experience_Id=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public String updateEmpExperience(EmpExperience empExperience) {
		
		try {
			getHibernateTemplate().update(empExperience);
			msg="S";

		} catch (Exception e) {
			//msg="F";
			e.printStackTrace();

		}
		return msg;
	}
	
	
	
	public String deleteEmpExperience(int id) {
	
		try {
			EmpExperience empExperience=new EmpExperience();
			empExperience.setExperience_Id(id);
		    getHibernateTemplate().delete(empExperience);
		    msg="S";
	
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
					}
		return msg;
	}
	

	
	


	
}
