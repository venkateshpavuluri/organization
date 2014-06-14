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

import com.mnt.erp.bean.Code;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.service.AuditLogService;




/**
 * @author kirangangone	
 * @version 1.0
   @build 0.0
 * 
 *
 */
public class CodeDaoImpl extends HibernateDaoSupport implements CodeDao
{
	
	@Autowired
	AuditLogService auditLogService;
	String msg;
	
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	boolean flag=false;

	@Override
	public String saveCode(Code code,String userId,String userName)
	{
	try
		{
			Serializable id=getHibernateTemplate().save(code);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Code",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		}
		catch(Exception e)
		{
			msg="F";
			
			e.printStackTrace();
			
		}
		return msg;
	}
	
	
	public Long duplicateCheckCode(String code, String codeGroupId) {
		
		Long count = null;
		try {
			final String hql = "select count(*) from Code cb where  cb.code='"
					+ code + "' or cb.codeGroupId!="+codeGroupId;
			
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
						
							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (long) count.intValue();
	}
	

	public Long duplicateCheckCodeUpdate(String code, String codeGroupId,int id) {
		
		Long count = null;
		try {
			final String hql = "select count(*) from Code cb where  cb.code='"
					+ code + "' or cb.codeGroupId!='"+codeGroupId+ "' and cb.codeId!='" + id
					+ "'";
		
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(
								org.hibernate.Session session)
								throws HibernateException, SQLException {
						
							org.hibernate.Query query = session
									.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}

					});

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (long) count.intValue();
	}
	
/*For Selecting CodeGroup Id And CodeGroup  */
	
	public List<Object[]> getCodeGroupId(){
		List<Object[]> list=null;
		String sql=null;  
		try
		{
			sql="select k.codeGroup_Id,k.codeGroup from CodeGroup k "; 
			list=getHibernateTemplate().find(sql);
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<Object[]> basicSearchCode(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		String hql="";
		try {
				if(label.equals("") && operator.equals("") && searchName.equals(""))
				{
					hql = "select c.code,c.codeGroupId,c.codeId,c.codeGroupDetails from Code c order by c.code";
					objs = getHibernateTemplate().find(hql);
				}
				else
				{
			 hql = "select c.code,c.codeGroupId,c.codeId,c.codeGroupDetails from Code c where c."
					+ label + "" + operator + " ? order by c.code ";
			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}
	
	
	public List<Object> editCode(int Id) {
		try {
		
			String hql = "from Code c where c.codeId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	
	@Override
	public String updateCode(Code code) {
		
		try {
			
			
			getHibernateTemplate().update(code);
		msg="S";

		} catch (Exception e) {
				msg="F";
			e.printStackTrace();
		
		}
		return msg;
	}
	
	
	
	public String deleteCode(int id) {
		
		Code code = null;
		try {
			code = (Code) getHibernateTemplate().get(Code.class, id);
			code.setCodeGroupDetails(new CodeGroup());
		    getHibernateTemplate().delete(code);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		
		}
		return msg;
	}
	

	
	
	

	
}
