/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.DebitNoteBean;
import com.mnt.erp.bean.DebitNoteDetail;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorInvoice;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */
public class DebitNoteDaoImpl extends HibernateDaoSupport implements
		DebitNoteDao {

	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public int updateCheckDebitNote(String debNo, int dnId) {
		try {
			String sql = "select count(*) from DebitNoteBean db where  db.debitNoteNo='"
					+ debNo + "' and db.debitNoteId!='" + dnId + "'";
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

	@Override
	public Long checkDebitNote(String debNo) {
		try {
			String sql = "select count(*) from DebitNoteBean dn where  dn.debitNoteNo='"
					+ debNo + "'";
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
	public boolean saveDebitNote(Object object) {
		try {
			DebitNoteBean debitBean = (DebitNoteBean) object;
			getHibernateTemplate().save(debitBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchDebitNote() {
		try {
			String hql = "select dn.debitNoteId,dn.debitNoteNo,dn.debitNoteDT,dn.custInvoiceId,dn.vendorInvoiceId,dn.custInvoice,dn.vendorInvoice from DebitNoteBean dn order by dn.debitNoteNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchDebitNoteWithId(int dnId) {
		try {
			String hql = "from DebitNoteBean dn where dn.debitNoteId='" + dnId
					+ "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateDebitNote(Object object) {
		try {
			DebitNoteBean debitBeanUp = (DebitNoteBean) object;
			DebitNoteBean dBean = (DebitNoteBean) getHibernateTemplate().get(
					DebitNoteBean.class, debitBeanUp.getDebitNoteId());
			for (DebitNoteDetail dnDelete : dBean.getDebitNoteDetail()) {
				dnDelete.setMaterial(new Material());
				dnDelete.setUom(new Uom());
				getHibernateTemplate().delete(dnDelete);
			}
			getHibernateTemplate().update(debitBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteDebitNote(int dnId) {
		try {
			DebitNoteBean dnb = new DebitNoteBean();
			dnb.setDebitNoteId(dnId);
			DebitNoteBean deleteDebit = (DebitNoteBean) getHibernateTemplate()
					.get(DebitNoteBean.class, dnId);
			deleteDebit.setCustInvoice(new CustomerInvoice());
			deleteDebit.setVendorInvoice(new VendorInvoice());
			for (DebitNoteDetail dnDelete : deleteDebit.getDebitNoteDetail()) {
				dnDelete.setMaterial(new Material());
				dnDelete.setUom(new Uom());
				getHibernateTemplate().delete(dnDelete);
			}
			getHibernateTemplate().delete(dnb);

		} catch (Exception e) {

			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public boolean deleteDebitNoteLine(int dndId) {
		try {
			DebitNoteDetail dnoteBean = (DebitNoteDetail) getHibernateTemplate()
					.get(DebitNoteDetail.class, dndId);
			dnoteBean.setMaterial(new Material());
			dnoteBean.setUom(new Uom());
			getHibernateTemplate().delete(dnoteBean);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchDebitNote(String label, String operator,
			String searchName) {
		try {

			String hql = "select dn.debitNoteId,dn.debitNoteNo,dn.debitNoteDT,dn.custInvoiceId,dn.vendorInvoiceId,dn.custInvoice,dn.vendorInvoice  from DebitNoteBean dn where dn."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> advSearchDebitNote(String advSearch) {
		String hql = null;
		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select dn.debitNoteId,dn.debitNoteNo,dn.debitNoteDT,dn.custInvoiceId,dn.vendorInvoiceId,dn.custInvoice,dn.vendorInvoice  from DebitNoteBean dn where dn."
					+ advSearch + " order by dn.debitNoteNo";

		} else {
			hql = "select dn.debitNoteId,dn.debitNoteNo,dn.debitNoteDT,dn.custInvoiceId,dn.vendorInvoiceId,dn.custInvoice,dn.vendorInvoice from DebitNoteBean dn order by dn.debitNoteNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
