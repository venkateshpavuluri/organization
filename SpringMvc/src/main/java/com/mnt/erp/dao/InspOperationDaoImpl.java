/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.InspOperationBean;
import com.mnt.erp.bean.InspOperationStep;
import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.bean.Material;

/**
 * @author Naresh
 * @version 1.0 05-02-2014
 * 
 */
public class InspOperationDaoImpl extends HibernateDaoSupport implements
		InspOperationDao {
	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckInspOperation(String inspNo, int inspId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long checkInspOperationCout(String inspNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveInspOperationDetails(Object object) {
		try {
			InspOperationBean inspOprBean = (InspOperationBean) object;
			getHibernateTemplate().save(inspOprBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchInspOperation() {
		try {
			String hql = "select dn.inspOperationId,dn.operationNo,dn.inspType,dn.material from InspOperationBean dn order by dn.operationNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchInspOperationWithId(int inspId) {
		try {
			String hql = "from InspOperationBean dn where dn.inspOperationId='"
					+ inspId + "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateInspOperation(Object object) {
		try {
			InspOperationBean inspBeanUp = (InspOperationBean) object;
			InspOperationBean delBean = (InspOperationBean) getHibernateTemplate()
					.get(InspOperationBean.class,
							inspBeanUp.getInspOperationId());
			for (InspOperationStep step : delBean.getInspOprStep()) {
				getHibernateTemplate().delete(step);
			}

			getHibernateTemplate().update(inspBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteInspOperation(int inspId) {
		try {
			InspOperationBean dnb = new InspOperationBean();
			dnb.setInspOperationId(inspId);
			dnb.setInspType(new InspectionType());
			dnb.setMaterial(new Material());
			InspOperationBean deleteDebit = (InspOperationBean) getHibernateTemplate()
					.get(InspOperationBean.class, inspId);
			for (InspOperationStep step : deleteDebit.getInspOprStep()) {
				getHibernateTemplate().delete(step);

			}

			getHibernateTemplate().delete(dnb);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	public boolean deleteInspOperStep(int stepId) {

		try {
			InspOperationStep deleteDebit = (InspOperationStep) getHibernateTemplate()
					.get(InspOperationStep.class, stepId);
			getHibernateTemplate().delete(deleteDebit);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;

	}

	@Override
	public List<Object[]> basicSearchInspOperation(String label,
			String operator, String searchName) {
		try {
			String hql = "select dn.inspOperationId,dn.operationNo,dn.inspType,dn.material from InspOperationBean dn where dn."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchInspOperation(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select dn.inspOperationId,dn.operationNo,dn.inspType,dn.material from InspOperationBean dn where dn."
					+ advSearch + " order by dn.operationNo";

		} else {
			hql = "select dn.inspOperationId,dn.operationNo,dn.inspType,dn.material from InspOperationBean dn order by dn.operationNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
