/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProdOrderProcessBean;
import com.mnt.erp.bean.ProdOrderProcessEqp;
import com.mnt.erp.bean.ProdProcessEmpBean;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkCenter;

/**
 * @author Naresh
 * @version 1.0 14-05-2014
 */

@Repository("popDao")
public class ProdOrderProcessDaoImpl extends CustomHibernateDaoSupport implements
		ProdOrderProcessDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public boolean saveProdOdrProcess(Object object) {
		try {
			ProdOrderProcessBean popBean = (ProdOrderProcessBean) object;
			getHibernateTemplate().save(popBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchProdOdrProcess() {
		try {
			String hql = "select cb.popId,cb.startDate,cb.endDate,cb.processDetail,cb.productionOrder,cb.workCenter,cb.inspPoint from ProdOrderProcessBean cb";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchProdOdrProcessWithId(int popId) {
		try {
			String hql = "from ProdOrderProcessBean cbd where cbd.popId="
					+ popId + " ";
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateProdOdrProcess(Object object) {
		try {
			ProdOrderProcessBean popBeanUp = (ProdOrderProcessBean) object;
			ProdOrderProcessBean cBean = (ProdOrderProcessBean) getHibernateTemplate()
					.get(ProdOrderProcessBean.class, popBeanUp.getPopId());
			for (ProdProcessEmpBean cbDelete : cBean.getPopEmp()) {
				cbDelete.setEmployee(new Employee());
				getHibernateTemplate().delete(cbDelete);
			}
			for (ProdOrderProcessEqp caDelete : cBean.getPopEqp()) {
				caDelete.setEquipment(new EquipmentBean());
				caDelete.setUom(new Uom());
				getHibernateTemplate().delete(caDelete);
			}
			getHibernateTemplate().update(popBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcess(int popId) {
		try {
			ProdOrderProcessBean pop = new ProdOrderProcessBean();
			pop.setPopId(popId);
			ProdOrderProcessBean deletePop = (ProdOrderProcessBean) getHibernateTemplate()
					.get(ProdOrderProcessBean.class, popId);
			deletePop.setProcessDetail(new ProcessDetailBean());
			deletePop.setProductionOrder(new ProductionOrderBean());
			deletePop.setWorkCenter(new WorkCenter());
			for (ProdProcessEmpBean cbDelete : deletePop.getPopEmp()) {
				cbDelete.setEmployee(new Employee());
				getHibernateTemplate().delete(cbDelete);
			}
			for (ProdOrderProcessEqp caDelete : deletePop.getPopEqp()) {
				caDelete.setEquipment(new EquipmentBean());
				caDelete.setUom(new Uom());
				getHibernateTemplate().delete(caDelete);
			}
			getHibernateTemplate().delete(pop);

		} catch (Exception e) {

			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcessEmp(int popEmpId) {
		try {
			ProdProcessEmpBean popEmpBean = (ProdProcessEmpBean) getHibernateTemplate()
					.get(ProdProcessEmpBean.class, popEmpId);
			popEmpBean.setEmployee(new Employee());
			getHibernateTemplate().delete(popEmpBean);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOdrProcessEqp(int popEqpId) {
		try {
			ProdOrderProcessEqp popEqpBean = (ProdOrderProcessEqp) getHibernateTemplate()
					.get(ProdOrderProcessEqp.class, popEqpId);
			popEqpBean.setEquipment(new EquipmentBean());
			popEqpBean.setUom(new Uom());
			getHibernateTemplate().delete(popEqpBean);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchProdOdrProcess(String label,
			String operator, String searchName) {
		try {

			String hql = "select cb.popId,cb.startDate,cb.endDate,cb.processDetail,cb.productionOrder,cb.workCenter,cb.inspPoint from ProdOrderProcessBean cb where cb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
