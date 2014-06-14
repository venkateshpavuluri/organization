/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Voucher;
import com.mnt.erp.bean.WorkFlowList;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 * 
 * 
 */
public class VoucherDaoImpl extends HibernateDaoSupport implements VoucherDao {
	String msg;

	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;
	boolean flag = false;

	@Override
	public boolean saveVoucher(Voucher voucher) {
		try {
			Serializable id = getHibernateTemplate().save(voucher);
			if (id != null) {
				flag = true;
			} else {
				flag = false;

			}
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	public int duplicateCheckVoucher(String voucher, String Id) {
		try {
			String sql = null;

			if (!Id.equals("")) {
				sql = "select count(*) from Voucher cb where  cb.voucherNo='"
						+ voucher + "' and cb.voucherId!=" + Id;

			} else {
				sql = "select count(*) from Voucher cb where  cb.voucherNo='"
						+ voucher + "'";
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

	/* For Selecting Voucher */

	public List<Object[]> getVoucherEmployeeId() {
		List<Object[]> list = null;
		String sql = null;
		try {
			sql = "select m.employee_Id,m.fName from Employee m";
			list = getHibernateTemplate().find(sql);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> basicSearchVoucher(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		String hql = "";
		try {

			if (label.equals("") && operator.equals("")
					&& searchName.equals("")) {
				hql = "select c.voucherId,c.voucherNo,c.voucherDT,c.employeeId,c.amount,c.statusId,c.voucherTypeIdDetails,c.statusDetails from Voucher c ";
				objs = getHibernateTemplate().find(hql);
			} else {
				hql = "select c.voucherId,c.voucherNo,c.voucherDT,c.employeeId,c.amount,c.statusId,c.voucherTypeIdDetails,c.statusDetails from Voucher c where c."
						+ label + "" + operator + " ? ";
				Object[] parameters = { searchName };
				objs = getHibernateTemplate().find(hql, parameters);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	public List<Object> editVoucher(int Id) {
		try {

			String hql = "from Voucher c where c.voucherId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateVoucher(Voucher voucher) {
		boolean flag = false;
		try {
			getHibernateTemplate().update(voucher);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

	public boolean deleteVoucher(int id) {
		boolean flag = true;
		Voucher voucher = null;
		try {
			voucher = new Voucher();
			voucher.setVoucherId(id);
			getHibernateTemplate().delete(voucher);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			return flag;
		}
		return flag;
	}

	public List<Object[]> getStepUser() {
		List<Object[]> list = null;
		String sql = null;
		try {
			list = getHibernateTemplate().findByNamedQuery("StepUserForVO");

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String saveWorkFlowListDaoDetails(Object object) {

		try {
			WorkFlowList wf = (WorkFlowList) object;
			Serializable id = getHibernateTemplate().save(wf);
			msg = "success";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "fail";
			return msg;
		}

		return msg;
	}

}
