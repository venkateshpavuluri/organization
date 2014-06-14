package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Parvathi
 * @version 1.0 04-1-2014
 */

public class CodeGroupDaoImpl extends HibernateDaoSupport implements CodeGroupDao{
	@Autowired
	AuditLogService auditLogService;
	String msg;
	List<Object[]> objects = null;

	public Long updateCheckCodeGroup(String codeGroup,int codeGroupId){

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from CodeGroup cg where cg.codeGroup ='"
					+ codeGroup + "' and cg.codeGroup_Id!='" + codeGroupId + "'";
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

	public Long checkCodeGroupCout(String codeGroup){

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from CodeGroup cg where  cg.codeGroup='"
					+ codeGroup + "'";
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

	public String saveCodeGroupDetails(Object object,String userId,String userName){
		
		try {
			CodeGroup codeGroupBean = (CodeGroup) object;
			Serializable id=getHibernateTemplate().save(codeGroupBean);
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

	public List<Object[]> searchCodeGroup() {

		try {
			String hql = "select c.codeGroup_Id,c.codeGroup from CodeGroup c order by c.codeGroup ";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchCodeGroupWithId(int id) {
		try {
			String hql = "select c.codeGroup_Id,c.codeGroup from CodeGroup c where c.codeGroup_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateCodeGroup(Object object) {
		try {
			CodeGroup updateCodeGroup = (CodeGroup) object;
			getHibernateTemplate().update(updateCodeGroup);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteCodeGroup(int id) {

		try {
			CodeGroup deleteCodeGroup = getHibernateTemplate().get(
					CodeGroup.class, id);
			getHibernateTemplate().delete(deleteCodeGroup);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectCodeGroup() {
		String sql = null;
		try {
			sql = "select c.codeGroup_Id,c.codeGroup from CodeGroup c";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> basicSearchCodeGroup(String label,String operator,String searchName) {
		try {

			String hql = "select c.codeGroup_Id,c.codeGroup from CodeGroup c where c."
					+ label + "" + operator + " ? order by c.codeGroup";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	
	
	

}
