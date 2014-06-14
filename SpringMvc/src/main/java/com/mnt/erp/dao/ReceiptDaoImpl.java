/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentType;
import com.mnt.erp.bean.ReceiptBean;
import com.mnt.erp.bean.ReceiptWithHold;
import com.mnt.erp.bean.Status;

/**
 * @author Naresh
 * @version 1.0 21-01-2014
 */
public class ReceiptDaoImpl extends HibernateDaoSupport implements ReceiptDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckReceipt(String recNo, int recId) {
		try {
			String sql = "select count(*) from ReceiptBean db where  db.receiptNo='"
					+ recNo + "' and db.receiptId!='" + recId + "'";
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
	public Long checkReceiptCout(String recNo) {
		try {
			String sql = "select count(*) from ReceiptBean rb where  rb.receiptNo='"
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
	public boolean saveReceiptDetails(Object object) {
		try {
			ReceiptBean receiptBean = (ReceiptBean) object;
			getHibernateTemplate().save(receiptBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchReceipt() {
		try {
			String hql = "select rb.receiptId,rb.accNo,rb.postingDate,rb.receiptNo,rb.amount,rb.chequeNo,rb.chequeDate,rb.desc,rb.status,rb.currency,rb.paymentType,rb.paymentMethod,rb.organization,rb.cust,rb.custInvoice,rb.bank,rb.chequeIssuedDate,rb.chequeClearanceDate,rb.chequeClearanceStatus from ReceiptBean rb order by rb.receiptNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchReceiptWithId(int recId) {
		try {
			String hql = "from ReceiptBean dn where dn.receiptId='" + recId
					+ "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateReceipt(Object object) {
		try {
			ReceiptBean receiptBeanUp = (ReceiptBean) object;
			ReceiptBean rwHold = (ReceiptBean) getHibernateTemplate().get(
					ReceiptBean.class, receiptBeanUp.getReceiptId());
			for (ReceiptWithHold rwh : rwHold.getRecWithHold()) {
				getHibernateTemplate().delete(rwh);
			}
			getHibernateTemplate().update(receiptBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteReceipt(int recId) {
		try {
			ReceiptBean rb = new ReceiptBean();
			rb.setReceiptId(recId);
			rb.setReceiptId(recId);
			rb.setCust(new CustomerBean());
			rb.setCustInvoice(new CustomerInvoice());
			rb.setStatus(new Status());
			rb.setPaymentMethod(new PaymentMethod());
			rb.setPaymentType(new PaymentType());
			rb.setOrganization(new Organization());
			rb.setBank(new HouseBankBean());
			rb.setCurrency(new Currency());
			ReceiptBean rwHold = (ReceiptBean) getHibernateTemplate().get(
					ReceiptBean.class, rb.getReceiptId());
			for (ReceiptWithHold rwh : rwHold.getRecWithHold()) {
				getHibernateTemplate().delete(rwh);
			}

			getHibernateTemplate().delete(rb);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchReceipt(String label, String operator,
			String searchName) {
		try {
			String hql = "select rb.receiptId,rb.accNo,rb.postingDate,rb.receiptNo,rb.amount,rb.chequeNo,rb.chequeDate,rb.desc,rb.status,rb.currency,rb.paymentType,rb.paymentMethod,rb.organization,rb.cust,rb.custInvoice,rb.bank,rb.chequeIssuedDate,rb.chequeClearanceDate,rb.chequeClearanceStatus from ReceiptBean rb where rb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchReceipt(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select rb.receiptId,rb.accNo,rb.postingDate,rb.receiptNo,rb.amount,rb.chequeNo,rb.chequeDate,rb.desc,rb.status,rb.currency,rb.paymentType,rb.paymentMethod,rb.organization,rb.cust,rb.custInvoice,rb.bank,rb.chequeIssuedDate,rb.chequeClearanceDate,rb.chequeClearanceStatus from ReceiptBean rb where rb."
					+ advSearch + " order by rb.receiptNo";

		} else {
			hql = "select rb.receiptId,rb.accNo,rb.postingDate,rb.receiptNo,rb.amount,rb.chequeNo,rb.chequeDate,rb.desc,rb.status,rb.currency,rb.paymentType,rb.paymentMethod,rb.organization,rb.cust,rb.custInvoice,rb.bank,rb.chequeIssuedDate,rb.chequeClearanceDate,rb.chequeClearanceStatus from ReceiptBean rb order by rb.receiptNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
