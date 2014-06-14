/**
 * 
 */
package com.mnt.erp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.GoodsDeliveryInTheYear;
import com.mnt.erp.bean.InvoiceToCollect;
import com.mnt.erp.bean.InvoiceToPay;
import com.mnt.erp.bean.PendingPo;
import com.mnt.erp.bean.ToBeReoredeMaterial;

/**
 * @author venkateshp
 * 
 */
public class DashBoardDaoImpl extends HibernateDaoSupport implements
	DashBoardDao {
    private static Logger logger = Logger.getLogger(DashBoardDaoImpl.class);

    List<Object[]> listofObjects = null;
    String hql = null;

    @Override
    public List<Object[]> getTotalStocks(int storageLocId) {
	try {
	    hql = "select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="
		    + storageLocId;

	    // listofObjects=getHibernateTemplate().find(hql);
	    listofObjects = getHibernateTemplate().find(hql);
	    logger.info("list size in dao iss==" + listofObjects.size());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listofObjects;
    }

    @Override
    public List<PendingPo> getPendingPoDetails(String count) {
	List<PendingPo> listofPendings = null;
	try {
	    if (count.equals("all")) {
		/*
		 * PendingPo Procedure configration is ther in
		 * PurchaseOrder.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"PendingPo");
	    } else {
		/*
		 * TOP5PendingPo Procedure configration is ther in
		 * PurchaseOrder.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"TOP5PendingPo");
	    }
	    listofPendings = new ArrayList<PendingPo>();
	    Iterator<Object[]> iterator = listofObjects.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		PendingPo pendingPo = new PendingPo();
		pendingPo.setPurchaseOrderNo((String) objects[0]);
		pendingPo.setVendorName((String) objects[1]);
		pendingPo.setDueDate((String) objects[2]);
		listofPendings.add(pendingPo);
	    }
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return listofPendings;
    }

    @Override
    public List<GoodsDeliveryInTheYear> getGoodsinyear(String msg) {
	List<GoodsDeliveryInTheYear> deliveryInTheYears = null;
	try {
	    if (msg.equals("all")) {
		listofObjects = getHibernateTemplate()
			.findByNamedQueryAndNamedParam(
				"GoodsDeliveryIntheYear", "message", "all");
	    } else {
		listofObjects = getHibernateTemplate()
			.findByNamedQueryAndNamedParam(
				"GoodsDeliveryIntheYear", "message", "top5");

	    }
	    deliveryInTheYears = new ArrayList<GoodsDeliveryInTheYear>();
	    Iterator<Object[]> iterator = listofObjects.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		GoodsDeliveryInTheYear deliveryInTheYear = new GoodsDeliveryInTheYear();
		deliveryInTheYear.setMaterialName((String) objects[0]);
		deliveryInTheYear.setDeliveredQty((String) objects[1]);
		deliveryInTheYears.add(deliveryInTheYear);
	    }
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return deliveryInTheYears;
    }

    @Override
    public List<ToBeReoredeMaterial> getTobeReorederLevels(String msg) {
	// TODO Auto-generated method stub
	List<ToBeReoredeMaterial> beReorederLevels = null;
	try {
	    if (msg.equals("top5")) {
		listofObjects = getHibernateTemplate()
			.findByNamedQueryAndNamedParam("TobeReorderedMaterial",
				"exMessage", "top5");
	    } else {
		listofObjects = getHibernateTemplate()
			.findByNamedQueryAndNamedParam("TobeReorderedMaterial",
				"exMessage", "all");
	    }
	    beReorederLevels = new ArrayList<ToBeReoredeMaterial>();
	    Iterator<Object[]> iterator = listofObjects.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		ToBeReoredeMaterial reorederLevel = new ToBeReoredeMaterial();
		reorederLevel.setMaterialName((String) objects[0]);
		reorederLevel.setQtyAvailabale((String) objects[1]);
		reorederLevel.setReorderLevel((String) objects[2]);
		reorederLevel.setUom((String) objects[3]);
		beReorederLevels.add(reorederLevel);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    logger.error(e.getMessage());
	}
	return beReorederLevels;
    }

    @Override
    public List<InvoiceToCollect> invoiceToCollect(String count) {
	// TODO Auto-generated method stub
	List<InvoiceToCollect> invoiceToCollects = null;
	try {
	    if (count.equals("top5")) {
		/*
		 * TOP5GetInvoiesToCollect Procedure configration is ther in
		 * CustomerInvoice.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"TOP5GetInvoiesToCollect");
	    } else {
		/*
		 * GetInvoiesToCollect Procedure configration is ther in
		 * CustomerInvoice.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"GetInvoiesToCollect");
	    }
	    logger.info("list size iss==" + listofObjects.size());
	    invoiceToCollects = new ArrayList<InvoiceToCollect>();
	    Iterator<Object[]> iterator = listofObjects.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		InvoiceToCollect collect = new InvoiceToCollect();
		collect.setCustomerNo((String) objects[0]);
		collect.setCustomer((String) objects[1]);
		collect.setAmount((String) objects[2]);
		collect.setRecievedAmount((String) objects[3]);
		collect.setPendingAmount((String) objects[4]);
		collect.setCurrency((String) objects[5]);
		collect.setDate((String) objects[6]);
		invoiceToCollects.add(collect);

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return invoiceToCollects;
    }

    @Override
    public List<InvoiceToPay> getInvoiceToPays(String count) {
	// TODO Auto-generated method stub
	List<InvoiceToPay> listOfInvoices = null;
	try {
	    if (count.equals("all")) {
		/*
		 * InvoiceToPay Procedure configration is ther in
		 * VendorInvoice.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"InvoiceToPay");
	    } else {
		/*
		 * TOP5InvoiceToPay Procedure configration is ther in
		 * VendorInvoice.hbm.xml file
		 */
		listofObjects = getHibernateTemplate().findByNamedQuery(
			"TOP5InvoiceToPay");
	    }
	    listOfInvoices = new ArrayList<InvoiceToPay>();
	    Iterator<Object[]> iterator = listofObjects.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		InvoiceToPay invoiceToPay = new InvoiceToPay();
		invoiceToPay.setVendorInvoiceNo((String) objects[0]);
		invoiceToPay.setVendor((String) objects[1]);
		invoiceToPay.setAmount((String) objects[2]);
		invoiceToPay.setRecievedAmount((String) objects[3]);
		invoiceToPay.setPendingAmount((String) objects[4]);
		invoiceToPay.setCurrency((String) objects[5]);
		invoiceToPay.setDate((String) objects[6]);
		listOfInvoices.add(invoiceToPay);
	    }
	} catch (Exception e) {

	}

	return listOfInvoices;
    }

    @Override
    public List<Object[]> getMatStockDetails() {
	// TODO Auto-generated method stub
	try {

	    hql = "select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m";

	    // listofObjects=getHibernateTemplate().find(hql);
	    listofObjects = getHibernateTemplate().find(hql);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return listofObjects;
    }

    @Override
    public List<Object[]> getTop5orderItems() {
	// TODO Auto-generated method stub

	try {
	    listofObjects = getHibernateTemplate().findByNamedQuery(
		    "top5OrderItems");
	    logger.debug("top5orderitems size iss==" + listofObjects.size());
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return listofObjects;
    }

    @Override
    public List<Object[]> getSalesOrdersByYear(int year) {
	// TODO Auto-generated method stub
	try {
	    listofObjects = getHibernateTemplate()
		    .findByNamedQueryAndNamedParam("GetSOrderPCTbyYear",
			    "Year", year);
	    logger.info("sorder by year size iss==" + listofObjects.size());
	} catch (Exception e)

	{
	    e.printStackTrace();
	    logger.error(e.getMessage());
	}
	return listofObjects;
    }

    @Override
    public List<Object[]> allorderItems() {
	try {
	    listofObjects = getHibernateTemplate().findByNamedQuery(
		    "allOrderItems");
	    logger.debug("top5orderitems size iss==" + listofObjects.size());
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return listofObjects;
    }

    @Override
    public List<Object[]> getPendingLeaveRequest() {
	try {
	    listofObjects = getHibernateTemplate().findByNamedQuery(
		    "GetPendingLeaveRequest");
	    logger.debug("top5orderitems size iss==" + listofObjects.size());
	} catch (Exception e) {
	    logger.error(e.getMessage());
	    e.printStackTrace();
	}
	return listofObjects;
    }

    @Override
    public List<Object[]> getScheduleInterviews() {
	try {
	    listofObjects = getHibernateTemplate().findByNamedQuery(
		    "GetScheduleInterviews");
	    logger.debug("top5orderitems size iss==" + listofObjects.size());
	} catch (Exception e) {
	    logger.error(e.getMessage());
	    e.printStackTrace();
	}
	return listofObjects;
    }
}
