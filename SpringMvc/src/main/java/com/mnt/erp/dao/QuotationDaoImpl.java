/**

 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Qualification;
import com.mnt.erp.bean.Quotation;
import com.mnt.erp.bean.QuotationLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;

/**
 * @author Sailaja
 * @version1.0
 * @build 0.0
 * 
 */
public class QuotationDaoImpl extends HibernateDaoSupport implements
		QuotationDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	List<Object[]> obj = null;

	/* =======================Add Method============================ */
	@Override
	public String addQuotation(Object object) {
		// TODO Auto-generated method stub

		try {

			Quotation quotation = (Quotation) object;
			getHibernateTemplate().save(quotation);

			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;

	}

	/* =======================Search(All) Method============================ */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchQuotation() {
		// TODO Auto-generated method stub

		String qry = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q";
		obj = getHibernateTemplate().find(qry);

		return obj;

	}

	/* =======================Search(With Id) Method============================ */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchQuotationWithId(int id) {
		// TODO Auto-generated method stub

		String qry = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q where q.quotationId="
				+ id + "";
		obj = getHibernateTemplate().find(qry);

		return obj;
	}

	/* =======================Update Method============================ */
	@Override
	public String updateQuotation(Object object) {
		// TODO Auto-generated method stub

		Iterator<QuotationLine> iterator = null;
		try {
			Quotation quotation = (Quotation) object;
			Quotation quota = (Quotation) getHibernateTemplate().get(
					Quotation.class, quotation.getQuotationIdEditt());
			List<QuotationLine> list = quota.getQuotationLine();

			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				QuotationLine quotationL = (QuotationLine) o;
				quotationL.setMaterialDetails(new Material());
				quotationL.setUomDetails(new Uom());
				quotationL.setCurrencyDetails(new Currency());
				quotationL.setPlantDetails(new Plant());
				quotationL.setStatusDetails(new Status());
				quotationL.setStLocDetails(new StorageLocation());

				quotationL.setQuotationLineId(quotationL.getQuotationLineId());
				getHibernateTemplate().delete(quotationL);

			}

			getHibernateTemplate().update(quotation);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	/* =======================Edit Method============================ */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> editQuotationWithId(int qid) {
		// TODO Auto-generated method stub
		List<Object> objs = null;
		try {
			String hql = "from Quotation q where q.quotationId=" + qid + " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;
	}

	/* =======================Delete Method============================ */
	@Override
	public String deleteQuotation(int id) {
		try {

			Quotation deleteQuot = new Quotation();
			deleteQuot.setQuotationId(id);
			deleteQuot.setVendorBean(new Vendor());
			deleteQuot.setStatusBean(new Status());
			
			Quotation delQuotLine = getHibernateTemplate().get(Quotation.class,id);
			for (QuotationLine line : delQuotLine.getQuotationLine()) {
				line.setMaterial(new Material());
				line.setUomDetails(new Uom());
				line.setPlantDetails(new Plant());
				line.setStLocDetails(new StorageLocation());
				line.setStatusDetails(new Status());
				line.setCurrencyDetails(new Currency());
				getHibernateTemplate().delete(line);
			}

			getHibernateTemplate().delete(deleteQuot);
			msg = "S";
		} catch (Exception e) {

			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	/*
	 * =======================Add Duplicate Check
	 * Method============================
	 */
	@Override
	public int checkDuplicate(String checkQuotNo) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from Quotation q where q.quotationNo='"
					+ checkQuotNo + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	/*
	 * =======================Edit Duplicate Checking
	 * Method============================
	 */
	@Override
	public int checkEditDuplicate(String checkQuotNo, int id) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from Quotation q where q.quotationNo='"
					+ checkQuotNo + "' and q.quotationId!='" + id + "'";
			count = (Long) getHibernateTemplate().execute(
					new HibernateCallback<Object>() {
						public Object doInHibernate(Session sesssion)
								throws HibernateException, SQLException {
							Query query = sesssion.createQuery(hql);
							query.setMaxResults(1);
							return query.uniqueResult();
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count.intValue();
	}

	/*
	 * ================================To get RFQ No
	 * Values===================================
	 */
	@Override
	public List<Object[]> rfqIdGet() {
		// TODO Auto-generated method stub
		String hql = "select r.rfqid,r.rfqNo from RfqBean r ";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}

	/*
	 * =======================To get Quotation Id Values
	 * ============================
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> quotationIdGet() {
		// TODO Auto-generated method stub
		String hql = "select q.quotationId,q.quotationNo from Quotation q ";

		List<Object[]> list = getHibernateTemplate().find(hql);
		return list;
	}

	public List<Object[]> basicSearchQuotation(String label, String operator,
			String searchName) {
		try {

			String hql = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			obj = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String deleteQuotationLine(int qLineId) {
		// TODO Auto-generated method stub
		try {

			QuotationLine line = new QuotationLine();
			line.setQuotationLineId(qLineId);

			line.setMaterialDetails(new Material());
			line.setPlantDetails(new Plant());
			line.setUomDetails(new Uom());
			line.setCurrencyDetails(new Currency());
			line.setStatusDetails(new Status());
			line.setStLocDetails(new StorageLocation());
			getHibernateTemplate().delete(line);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Quotation Deleted Successfully";
	}

	@Override
	public List<Object[]> quotationAdvanceSearch(String quotation) {
		// TODO Auto-generated method stub
		String hql = null;
		if (quotation.equalsIgnoreCase("ALL")) {

			hql = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q";

		}

		if (!quotation.equalsIgnoreCase("ALL")) {

			hql = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q where "
					+ quotation;

		}

		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public List<Object[]> setQuotationSearch(String quotation) {
		String hql = null;
		if (quotation.equalsIgnoreCase("ALL")) {
			hql = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q";

		}

		if (!quotation.equalsIgnoreCase("ALL")) {
			hql = "select q.quotationId,q.quotationNo,q.vendorBean,q.quotationDate,q.description,q.statusBean from Quotation q where"
					+ quotation;

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;

	}
}