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

import com.mnt.erp.bean.Function;
import com.mnt.erp.bean.WFStage;
import com.mnt.erp.service.AuditLogService;

/**
 * @author anFunction
 */
public class FunctionDaoImpl extends HibernateDaoSupport implements FunctionDao {
	String msg;
	String sql;
	List<Object> list = null;
	List<Object[]> objects;
	Iterator<Object> iterator = null;
	@Autowired
	AuditLogService auditLogService;

	@Override
	public String saveFunctionDetails(Object object, String userId,
			String userName) {
		try {
			// System.out.println("in save of function dao impl");
			Function function = (Function) object;

			Serializable id = getHibernateTemplate().save(function);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Function", "ROW",
						String.valueOf(id), "1", modifiedDate, userName);
			}

			msg = "S";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public Long duplicateFunctionCheck(String functionName) {
		// TODO Auto-generated method sub
		Long i = 0l;
		try {
			System.out.println("function name in function dao impl  is     "
					+ functionName);
			sql = "select count(*) from Function f where  f.functionName='"
					+ functionName + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Object[]> searchFunction() {

		try {
			System.out.println("in search of user group");
			String hql = "select r.functionId,r.functionName from Function r";
			System.out.println("query in search of vehilce type is " + hql);
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> searchFunctionWithName(String functionname) {
		List<Object[]> objects = null;
		try {
			System.out.println("function name in search function with name  "
					+ functionname);
			String hql = "select r.functionId,r.functionName from Function r where r.functionId="
					+ functionname + "";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectFunctionNames() {
		String sql = null;
		try {
			sql = "select r.functionId, r.functionName from Function r";
			objects = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objects;
	}

	public List<Object[]> basicSearchFunction(String label, String operator,
			String searchName) {
		try {
			System.out.println("in basic search of user group");
			String hql = "select r.functionId,r.functionName from Function r where r."
					+ label + "" + operator + " ? ";
			System.out.println("query in basic search is   " + hql);
			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> searchFunctionWithId(String id) {
		List<Object[]> objects = null;
		try {
			System.out
					.println("function id in search function with id   " + id);
			String hql = "select r.functionId,r.functionName from Function r where r.functionId='"
					+ id + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateFunction(Object object) {
		try {
			Function function = (Function) object;

			getHibernateTemplate().update(function);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public Long updateDuplicateCheck(String functionName, int functionid) {
		// TODO Auto-generated method stub
		Long i = 0l;
		try {
			sql = "select count(*) from Function r where  r.functionName='"
					+ functionName + "' and r.functionId!='" + functionid + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				i = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String functionDelete(int id) {
		String msg = null;

		try {
			Function function = new Function();
			function.setFunctionId(id);

			getHibernateTemplate().delete(function);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}
}
