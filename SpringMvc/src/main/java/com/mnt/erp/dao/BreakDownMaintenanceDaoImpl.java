/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.BreakDownMaintenance;
import com.mnt.erp.bean.Department;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.MaintenanceProblemType;
import com.mnt.erp.bean.Status;

/**
 * @author Naresh
 * @version 1.0 16-04-2014
 */
public class BreakDownMaintenanceDaoImpl extends HibernateDaoSupport implements
		BreakDownMaintenanceDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckBreakDown(String recNo, int recId) {
		try {
			String sql = "select count(*) from BreakDownMaintenance db where  db.breakDownNo='"
					+ recNo
					+ "' and db.breakdownMaintenace_Id!='"
					+ recId
					+ "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Long checkBreakDownCout(String recNo) {
		try {
			String sql = "select count(*) from BreakDownMaintenance rb where  rb.breakDownNo='"
					+ recNo + "'";
			obj = getHibernateTemplate().find(sql);
			iterator = obj.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveBreakDownDetails(Object object) {
		try {
			BreakDownMaintenance breakDownBean = (BreakDownMaintenance) object;
			getHibernateTemplate().save(breakDownBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchBreakDown() {
		try {
			String hql = "select rb.breakdownMaintenace_Id,rb.problem,rb.recordedDT,rb.deptBean,rb.equiBean,rb.mptBean,rb.statusBean,rb.breakDownNo from BreakDownMaintenance rb";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchBreakDownWithId(int recId) {
		try {
			String hql = "from BreakDownMaintenance dn where dn.breakdownMaintenace_Id='"
					+ recId + "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateBreakDown(Object object) {
		try {
			BreakDownMaintenance BreakDownBeanUp = (BreakDownMaintenance) object;
			getHibernateTemplate().update(BreakDownBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteBreakDown(int recId) {
		try {
			BreakDownMaintenance bdm = new BreakDownMaintenance();
			bdm.setBreakdownMaintenace_Id(recId);
			bdm.setDeptBean(new Department());
			bdm.setEquiBean(new EquipmentBean());
			bdm.setMptBean(new MaintenanceProblemType());
			bdm.setStatusBean(new Status());
			getHibernateTemplate().delete(bdm);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchBreakDown(String label, String operator,
			String searchName) {
		try {
			String hql = "select rb.breakdownMaintenace_Id,rb.problem,rb.recordedDT,rb.deptBean,rb.equiBean,rb.mptBean,rb.statusBean,rb.breakDownNo from BreakDownMaintenance rb where rb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
