/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.SalesPOLineBean;
import com.mnt.erp.bean.SalesPurchaseOrderBean;
import com.mnt.erp.bean.SalesQuotationBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 04-12-2013
 */
public class SalesPODaoImpl extends HibernateDaoSupport implements SalesPODao {
	private static final Logger log = Logger.getLogger(SalesPODaoImpl.class);
	String success;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public List<Object[]> selectCustomerIds() {
		try {
			String sql = "select cb.customerId,cb.customerName from CustomerBean cb";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesQuotationIds() {
		try {
			String sql = "select s.salesQuotationId,s.salesQuotationNo from SalesQuotationBean s";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckSalesPO(String salesNo, int siId) {
		try {
			String sql = "select count(*) from SalesPurchaseOrderBean sb where  sb.salesPONbr='"
					+ salesNo + "' and sb.salesPOId!='" + siId + "'";
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
	public Long checkSalesPO(String salesNo) {
		try {
			String sql = "select count(*) from SalesPurchaseOrderBean sb where  sb.salesPONbr='"
					+ salesNo + "'";
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
	public String saveSalesPO(Object object) {
		try {
			SalesPurchaseOrderBean salesPOBean = (SalesPurchaseOrderBean) object;
			getHibernateTemplate().save(salesPOBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<Object[]> searchSalesPO() {
		try {
			String hql = "select sq.salesPOId,sq.salesPONbr,sq.salesPOValue,sq.salesPODate,sq.description,sq.memo,sq.salesTaxAmount,sq.VATAmount,sq.exiciseAmount,sq.frieghtCharges,sq.PnFCharges,sq.dueDate,sq.createdBy,sq.createdDTTM,sq.custBean,sq.paymentTerm,sq.status,sq.currency from SalesPurchaseOrderBean sq order by sq.salesPONbr";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesPOWithId(int sId) {
		try {
			String hql = "from SalesPurchaseOrderBean sq where sq.salesPOId="
					+ sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesPO(Object object) {
		try {
			SalesPurchaseOrderBean salesBeanUp = (SalesPurchaseOrderBean) object;
			SalesPurchaseOrderBean sBean = (SalesPurchaseOrderBean) getHibernateTemplate()
					.get(SalesPurchaseOrderBean.class,
							salesBeanUp.getSalesPOId());
			for (SalesPOLineBean cbDelete : sBean.getSalesPOLine()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setCurrency(new Currency());
				cbDelete.setUom(new Uom());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().update(salesBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Updated";
	}

	@Override
	public String deleteSalesPO(int cId) {
		String msg = null;

		try {
			SalesPurchaseOrderBean spob = new SalesPurchaseOrderBean();
			spob.setSalesPOId(cId);
			SalesPurchaseOrderBean deleteSales = getHibernateTemplate().get(
					SalesPurchaseOrderBean.class, cId);
			deleteSales.setCustBean(new CustomerBean());
			deleteSales.setPaymentTerm(new PaymentTerms());
			deleteSales.setStatus(new Status());
			deleteSales.setSalesQuotation(new SalesQuotationBean());
			deleteSales.setCurrency(new Currency());
			for (SalesPOLineBean cbDelete : deleteSales.getSalesPOLine()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setCurrency(new Currency());
				cbDelete.setUom(new Uom());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().delete(spob);
			msg = "Deleted";

		} catch (Exception e) {

			msg = "NotDeleted";
			e.printStackTrace();

		}
		return msg;
	}

	@Override
	public List<Object[]> basicSearchSalesPO(String label, String operator,
			String searchName) {
		try {

			String hql = "select sq.salesPOId,sq.salesPONbr,sq.salesPOValue,sq.salesPODate,sq.description,sq.memo,sq.salesTaxAmount,sq.VATAmount,sq.exiciseAmount,sq.frieghtCharges,sq.PnFCharges,sq.dueDate,sq.createdBy,sq.createdDTTM,sq.custBean,sq.paymentTerm,sq.status,sq.currency from SalesPurchaseOrderBean sq where sq."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateCurrencyIds() {
		try {
			String sql = "select c.currencyId,c.currency from Currency c";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds() {
		try {
			String sql = "select m.material_Id,m.materialName from Material m";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			String sql = "select u.uom_Id,u.uom from Uom u";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> editSalesQuotationWithId(int sId) {
		try {
			String hql = "from SalesQuotationBean cb where cb.salesQuotationId="
					+ sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			String sql = "select p.paymentTermId,p.paymentTermName from PaymentTerms p";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectStatusIds() {
		try {
			String sql = "select s.statusId,s.status from Status s";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteSalesPOLine(int sId) {
		try {
			SalesPOLineBean SPOLine = (SalesPOLineBean) getHibernateTemplate()
					.get(SalesPOLineBean.class, sId);
			SPOLine.setMaterial(new Material());
			SPOLine.setUom(new Uom());
			SPOLine.setCurrency(new Currency());
			getHibernateTemplate().delete(SPOLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

	@Override
	public List<Object[]> advSearchSalesPO(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select sq.salesPOId,sq.salesPONbr,sq.salesPOValue,sq.salesPODate,sq.description,sq.memo,sq.salesTaxAmount,sq.VATAmount,sq.exiciseAmount,sq.frieghtCharges,sq.PnFCharges,sq.dueDate,sq.createdBy,sq.createdDTTM,sq.custBean,sq.paymentTerm,sq.status,sq.currency from SalesPurchaseOrderBean sq where sq."
					+ advSearch + " order by sq.salesPONbr";

		} else {
			hql = "select sq.salesPOId,sq.salesPONbr,sq.salesPOValue,sq.salesPODate,sq.description,sq.memo,sq.salesTaxAmount,sq.VATAmount,sq.exiciseAmount,sq.frieghtCharges,sq.PnFCharges,sq.dueDate,sq.createdBy,sq.createdDTTM,sq.custBean,sq.paymentTerm,sq.status,sq.currency from SalesPurchaseOrderBean sq order by sq.salesPONbr";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
