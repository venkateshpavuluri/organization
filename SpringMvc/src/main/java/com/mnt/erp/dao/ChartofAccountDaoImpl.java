/**
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
import com.mnt.erp.bean.ChartofAccount;
import com.mnt.erp.service.AuditLogService;






/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class ChartofAccountDaoImpl extends HibernateDaoSupport implements ChartofAccountDao
{
	String msg;
	Serializable id=null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	boolean flag=false;
	@Autowired
	AuditLogService auditLogService;
	
	@Override
	public boolean saveChartofAccount(ChartofAccount chartofAccount,String userId,String userName)
	{
	try
		{
			id=getHibernateTemplate().save(chartofAccount);

			if(id!=null)
			{
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","chart","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
			}
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
	
	
	public int duplicateCheckChartofAccount(String chartofAccount, String Id) {
		try {
			String sql = null;
			if(!Id.equals(""))
			{
			sql="select count(*) from ChartofAccount cb where  cb.coa='"
					+ chartofAccount + "' and cb.coaId!="+Id;
			
			}
			else
			{
				sql="select count(*) from ChartofAccount cb where  cb.coa='"
						+ chartofAccount + "'";
			}
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
	
	
/*For Selecting ChartofAccountGroup Id And ChartofAccountGroup  */
	
	public List<Object[]> getChartofAccountOrgId(){
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
	
	
	public List<Object[]> basicSearchChartofAccount(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		String hql="";
		try {
		
				if(label.equals("") && operator.equals("") && searchName.equals(""))
				{
					hql = "select c.coa,c.coaId,c.orgDetails from ChartofAccount c ";
					objs = getHibernateTemplate().find(hql);
				}
				else
				{
			 hql = "select c.coa,c.coaId,c.orgDetails from ChartofAccount c where c."
					+ label + "" + operator + " ? ";
			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	public List<Object> editChartofAccount(int Id) {
		try {
		//	System.out.println("editPoWith id "+Id);
			String hql = "from ChartofAccount c where c.coaId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public boolean updateChartofAccount(ChartofAccount chartofAccount) {
		//System.out.println("Came to Dao Of Purchase Update");
		boolean flag =false;
		try {
			
			
			getHibernateTemplate().update(chartofAccount);
			flag=true;

		} catch (Exception e) {
		//	System.out.println("SSSSS");
			
			
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	
	
	
	public boolean deleteChartofAccount(int id) {
		boolean flag=false;
		ChartofAccount chartofAccount = null;
		try {
			chartofAccount = new ChartofAccount();
			chartofAccount.setCoaId(id);
			//chartofAccount.setChartofAccountGroupDetails(new ChartofAccountGroup());
		    getHibernateTemplate().delete(chartofAccount);
			
		flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
			//System.out.println(message);
			return flag;
		}
		return flag;
	}
	

	
	


	
}
