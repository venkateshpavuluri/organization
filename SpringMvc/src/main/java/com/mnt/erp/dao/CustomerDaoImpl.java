/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.CustomerAccount;
import com.mnt.erp.bean.CustomerBankDept;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentTerms;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	String success;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	public int updateCheckCustomer(String custName, int custId) {
		try {
			String sql = "select count(*) from CustomerBean cb where  cb.customerName='"
					+ custName + "' and cb.customerId!='" + custId + "'";
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

	public Long checkCustomer(String custName) {

		try {
			String sql = "select count(*) from CustomerBean cb where  cb.customerName='"
					+ custName + "'";
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
	public String saveCustomerDetails(Object object) {
		try {
			CustomerBean custBean = (CustomerBean) object;
			custBean.setActive("Y");
			getHibernateTemplate().save(custBean);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return "success";
	}

	@Override
	public List<Object[]> searchCustomer(String active) {

		try {
			String hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone,cb.status from CustomerBean cb where cb.active='"
					+ active + "' order by cb.customerName";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchCustomerWithId(int cId, String active) {

		try {
			String hql = "select cb.customerId,cb.customerName,cb.customerGroupId,cb.salesAreaId,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone from CustomerBean cb where cb.customerId="
					+ cId + " and cb.active='" + active + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editCustomerWithId(int custId, String active) {
		try {
			String hql = "from CustomerBean cbd where cbd.customerId=" + custId
					+ " and cbd.active='" + active + "'";
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateCustomer(Object object) {
		try {
			CustomerBean custBeanUp = (CustomerBean) object;
			CustomerBean cBean = (CustomerBean) getHibernateTemplate().get(
					CustomerBean.class, custBeanUp.getEcustomerId());
			for (CustomerBankDept cbDelete : cBean.getCustBank()) {
				getHibernateTemplate().delete(cbDelete);
			}
			for (CustomerAccount caDelete : cBean.getCustAccount()) {
				caDelete.setAcGroup(new AccountGroupBean());
				caDelete.setRecnd(new AccountGroupBean());
				caDelete.setPaymentMethod(new PaymentMethod());
				caDelete.setPaymentTerm(new PaymentTerms());
				getHibernateTemplate().delete(caDelete);
			}
			getHibernateTemplate().update(custBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Updated";
	}

	@Override
	public String deleteCustomer(int cId) {
		try {
			CustomerBean deleteCust = getHibernateTemplate().get(
					CustomerBean.class, cId);
			deleteCust.setActive("N");
			getHibernateTemplate().update(deleteCust);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Deleted";
	}

	@Override
	public List<Object[]> selectCustomer(String active) {
		try {
			String hql = "select cb.customerId,cb.customerName,cb.customerGroupId,cb.salesAreaId,cb.companyName,cb.address,cb.city,cb.state,cb.countryId,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone,cb.status from CustomerBean cb where cb.active='"
					+ active + "'";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectCustomerGroup() {
		try {
			String sql = "select cgb.custGroupId, cgb.custGroup from  CustomerGroup cgb";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public List<Object[]> selectSalesArea() {
		try {
			String sql = "select sab.salesAreaId, sab.salesArea from  SalesAreaBean sab";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> getCustomerIds() {
		List<Object[]> list = null;
		String sql = null;

		try {
			sql = "select cb.customerId,cb.customerName from  CustomerBean cb";
			list = getHibernateTemplate().find(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> basicSearchCustomer(String label, String operator,
			String searchName) {
		try {

			String hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone,cb.status from CustomerBean cb where cb."
					+ label + "" + operator + " ? order by cb.customerName";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> setCustomerAdvanceSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone from CustomerBean cb";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone from CustomerBean cb where cb."
					+ name;

		}

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public List<Object[]> setCustomerSearch(String name) {
		String hql = null;
		if (name.equalsIgnoreCase("ALL")) {
			hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone from CustomerBean cb";

		}

		if (!name.equalsIgnoreCase("ALL")) {
			hql = "select cb.customerId,cb.customerName,cb.custGroup,cb.salesArea,cb.companyName,cb.address,cb.city,cb.state,cb.countrys,cb.zip,cb.email,cb.phone,cb.mobile,cb.fax,cb.contactPerson,cb.contactPersonPhone from CustomerBean cb where cb.customerName='"
					+ name + "'";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

	public List<Object[]> selectAccountGroupIds() {
		// TODO Auto-generated method stub
		try {
			String hql = "select ags.accountgroupid,ags.accountgroup from AccountGroupBean ags";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			String hql = "select ags.paymentTermId,ags.paymentTermName from PaymentTerms ags";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentMethodIds() {
		try {
			String hql = "select ags.paymentMethodId,ags.paymentMethodName from PaymentMethod ags";
			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteCustomerBankDet(int custId) {
		try {
			CustomerBankDept cBank = (CustomerBankDept) getHibernateTemplate()
					.get(CustomerBankDept.class, custId);
			getHibernateTemplate().delete(cBank);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";

	}

	@Override
	public String deleteCustomerAccount(int acId) {
		try {
			CustomerAccount cAccount = (CustomerAccount) getHibernateTemplate()
					.get(CustomerAccount.class, acId);
			cAccount.setAcGroup(new AccountGroupBean());
			cAccount.setPaymentMethod(new PaymentMethod());
			cAccount.setPaymentTerm(new PaymentTerms());
			cAccount.setRecnd(new AccountGroupBean());
			getHibernateTemplate().delete(cAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

}
