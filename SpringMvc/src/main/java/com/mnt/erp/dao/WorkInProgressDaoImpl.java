/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.JobCardBean;
import com.mnt.erp.bean.ShiftBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.bean.WorkInProgressBean;

/**
 * @author Naresh
 * @version 1.0 17-04-2014
 */
public class WorkInProgressDaoImpl extends HibernateDaoSupport implements
		WorkInProgressDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckWIP(String recNo, int wipId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long checkWIPCout(String wip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveWIPDetails(Object object) {
		try {
			WorkInProgressBean wipBean = (WorkInProgressBean) object;
			getHibernateTemplate().save(wipBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchWIP() {
		try {
			String hql = "select rb.wipId,rb.workDay,rb.qtyPlanned,rb.qtyManufactured,rb.shiftBean,rb.workBean,rb.eqipBean,rb.uomBean,rb.jobCardBean from WorkInProgressBean rb";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public List<Object> searchWIPWithId(int wipId) {
		try {
			String hql = "from WorkInProgressBean dn where dn.wipId='" + wipId
					+ "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateWIP(Object object) {
		try {
			WorkInProgressBean beanUp = (WorkInProgressBean) object;
			getHibernateTemplate().update(beanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteWIP(int wipId) {
		try {
			WorkInProgressBean wip = new WorkInProgressBean();
			wip.setWipId(wipId);
			wip.setEqipBean(new EquipmentBean());
			wip.setShiftBean(new ShiftBean());
			wip.setJobCardBean(new JobCardBean());
			wip.setWorkBean(new WorkCenter());
			wip.setUomBean(new Uom());
			// wip.setEmpBean(new Employee());
			getHibernateTemplate().delete(wip);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchWIP(String label, String operator,
			String searchName) {
		try {
			String hql = "select rb.wipId,rb.workDay,rb.qtyPlanned,rb.qtyManufactured,rb.shiftBean,rb.workBean,rb.eqipBean,rb.uomBean,rb.jobCardBean from WorkInProgressBean rb where rb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
