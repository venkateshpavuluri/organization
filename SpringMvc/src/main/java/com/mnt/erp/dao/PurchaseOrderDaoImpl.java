/**
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseOrderLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.WorkFlowList;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 * 
 */
public class PurchaseOrderDaoImpl extends HibernateDaoSupport implements
		PurchaseOrderDao {
	private static Logger logger = Logger.getLogger(PurchaseOrderDaoImpl.class);
	String msg;

	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;
	Long l = 0l;

	@Override
	public String addPurchaseOrder(Object object) {
		try {
			PurchaseOrder purchaseOrder = (PurchaseOrder) object;
			Serializable id = getHibernateTemplate().save(purchaseOrder);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> basicSearchPO() {
		try {
			String hql = "select po.purchaseOrderId,po.purchaseOrderNo,po.purchaseOrderDate,po.purchaseOrderValue"
					+ ",po.satatusDetails,po.description,po.paymentDetails,po.memo,po.dueDate from PurchaseOrder po order by  po.purchaseOrderNo";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editPOWithId(int Id) {
		try {

			String hql = "from PurchaseOrder po where po.purchaseOrderId=" + Id;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchPurchase(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {

			String hql = "select po.purchaseOrderId,po.purchaseOrderNo,po.purchaseOrderDate,po.purchaseOrderValue,po.satatusDetails"
					+ ",po.description,po.paymentDetails,po.memo,po.dueDate from PurchaseOrder po where po."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public List<Object[]> setPurchaseAdvanceSearch(String purchase) {
		String hql = null;
		hql = "select po.purchaseOrderId,po.purchaseOrderNo,po.purchaseOrderDate,po.purchaseOrderValue"
				+ ",po.satatusDetails,po.description,po.paymentDetails,po.memo,po.dueDate from PurchaseOrder po  where "
				+ purchase;
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}

	@Override
	public String updatePurchaseOrderDao(Object object) {

		try {
			PurchaseOrder puchareOrderUp = (PurchaseOrder) object;
			getHibernateTemplate().update(puchareOrderUp);

		} catch (Exception e) {

			e.printStackTrace();
			return "fail";
		}
		return "Updated";
	}

	public int updateCheckPurchase(String custName, int custId) {
		try {
			String sql = "select count(*) from PurchaseOrder cb where  cb.purchaseOrderNo='"
					+ custName + "' and cb.purchaseOrderId!='" + custId + "'";
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

	public Long checkPurchase(String pno) {

		try {
			String sql = "select count(*) from PurchaseOrder cb where  cb.purchaseOrderNo='"
					+ pno + "'";
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

	public String deletePurchaseOrderLine(int id) {
		String message = null;
		com.mnt.erp.bean.PurchaseOrderLine purchaseOrderLine = null;
		try {
			purchaseOrderLine = (com.mnt.erp.bean.PurchaseOrderLine) getHibernateTemplate()
					.get(com.mnt.erp.bean.PurchaseOrderLine.class, id);
			purchaseOrderLine.setCurrencyDetails(new Currency());
			purchaseOrderLine.setMaterialDetails(new Material());
			purchaseOrderLine.setUomDetails(new Uom());
			getHibernateTemplate().delete(purchaseOrderLine);

			message = "Purchase Order Line Deleted Successfully";

		} catch (Exception e) {
			e.printStackTrace();
			message = "Sorry Cant be Deleted";

		}
		return message;
	}

	public String deletePurchaseOrder(int id) {
		String message = null;
		com.mnt.erp.bean.PurchaseOrder purchaseOrder = null;
		try {
			PurchaseOrder po = new PurchaseOrder();
			po.setPurchaseOrderId(id);
			po.setVendorDetails(new Vendor());
			po.setSatatusDetails(new Status());
			po.setCurrencyDetails(new Currency());
			po.setPaymentDetails(new PaymentTerms());
			
			purchaseOrder = (com.mnt.erp.bean.PurchaseOrder) getHibernateTemplate()
					.get(com.mnt.erp.bean.PurchaseOrder.class, id);
			for (PurchaseOrderLine puLineDelete : purchaseOrder.getPoLine()) {
				puLineDelete.setMaterialDetails(new Material());
				puLineDelete.setUomDetails(new Uom());
				puLineDelete.setCurrencyDetails(new Currency());
				getHibernateTemplate().delete(puLineDelete);
			}
			getHibernateTemplate().delete(po);
			message = "S";

		} catch (Exception e) {
			e.printStackTrace();
			message = "F";
		}
		return message;
	}

	public List<Object[]> purchaseOrderNumGet(String s) {
		List<Object[]> list = null;
		if (s.equals("PurchaseOrder")) {
			String hql = "select p.purchaseOrderId, p.purchaseOrderNo from "
					+ s + " p where p.purchaseOrderStatus='100'";

			list = getHibernateTemplate().find(hql);
		} else if (s.equals("ProductionOrder")) {
            System.out.println("this is else if");
			String hql = "select p.prodOrderId, p.prodOrderNo from "
					+ "ProductionOrderBean" + " p where p.statusId='100'";

			list = getHibernateTemplate().find(hql);
			System.out.println("the size of the list:"+list.size());
		}
		return list;
	}

	public List<Object[]> getStepUser() {
		List<Object[]> list = null;
		String sql = null;
		try {
			list = getHibernateTemplate().findByNamedQuery("StepUserForPO");
		} catch (Exception e) {
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
