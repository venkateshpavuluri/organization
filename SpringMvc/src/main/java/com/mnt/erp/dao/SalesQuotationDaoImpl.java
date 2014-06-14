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
import com.mnt.erp.bean.SalesQuotationBean;
import com.mnt.erp.bean.SalesQuotationLineBean;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 14-11-2013
 */
public class SalesQuotationDaoImpl extends HibernateDaoSupport implements
		SalesQuotationDao {

	private static final Logger log = Logger
			.getLogger(SalesQuotationDaoImpl.class);
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
	public List<Object[]> selectSalesInquiryIds() {
		try {
			String sql = "select s.salesInquiryId,s.salesInquiryNo from SalesInquiryBean s";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckSalesQuotation(String salesNo, int siId) {
		try {
			String sql = "select count(*) from SalesQuotationBean sb where  sb.salesQuotationNo='"
					+ salesNo + "' and sb.salesQuotationId!='" + siId + "'";
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
	public Long checkSalesQuotation(String salesNo) {
		try {
			String sql = "select count(*) from SalesQuotationBean sb where  sb.salesQuotationNo='"
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
	public String saveSalesQuotation(Object object) {
		try {
			SalesQuotationBean salesQuotBean = (SalesQuotationBean) object;
			salesQuotBean.setStatusId(1);
			getHibernateTemplate().save(salesQuotBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public List<Object[]> searchSalesQuotation() {
		try {
			String hql = "select sq.salesQuotationId,sq.salesQuotationNo,sq.customerId,sq.salesInquiryId,sq.salesQuotationDate,sq.description,sq.statusId,sq.custBean from SalesQuotationBean sq";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	@Override
	public List<Object> searchSalesQuotationWithId(int sId) {
		try {
			String hql = "from SalesQuotationBean sq where sq.salesQuotationId="
					+ sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesQuotation(Object object) {
		try {
			SalesQuotationBean salesBeanUp = (SalesQuotationBean) object;
			SalesQuotationBean sBean = (SalesQuotationBean) getHibernateTemplate()
					.get(SalesQuotationBean.class,
							salesBeanUp.getSalesQuotationId());
			for (SalesQuotationLineBean cbDelete : sBean
					.getSalesQuotationLineBean()) {
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
	public String deleteSalesQuotation(int cId) {
		String msg = null;

		try {
			SalesQuotationBean delSales = new SalesQuotationBean();
			delSales.setSalesQuotationId(cId);
			SalesQuotationBean deleteSales = getHibernateTemplate().get(
					SalesQuotationBean.class, cId);
			deleteSales.setCustBean(new CustomerBean());
			for (SalesQuotationLineBean cbDelete : deleteSales
					.getSalesQuotationLineBean()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setCurrency(new Currency());
				cbDelete.setUom(new Uom());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().delete(delSales);
			msg = "Deleted";

		} catch (Exception e) {

			msg = "NotDeleted";
			e.printStackTrace();

		}
		return msg;
	}

	@Override
	public List<Object[]> basicSearchSalesQuotation(String label,
			String operator, String searchName) {
		try {

			String hql = "select sq.salesQuotationId,sq.salesQuotationNo,sq.customerId,sq.salesInquiryId,sq.salesQuotationDate,sq.description,sq.statusId,sq.custBean from SalesQuotationBean sq where sq."
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
	public List<Object> editSalesInquiryWithId(int sId) {
		try {
			String hql = "from SalesInquiryBean cb where cb.salesInquiryId="
					+ sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String deleteSalesQuotLine(int sId) {
		try {
			SalesQuotationLineBean SQLine = (SalesQuotationLineBean) getHibernateTemplate()
					.get(SalesQuotationLineBean.class, sId);
			SQLine.setCurrency(new Currency());
			SQLine.setMaterial(new Material());
			SQLine.setUom(new Uom());
			getHibernateTemplate().delete(SQLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

	@Override
	public List<Object[]> advSearchSalesQuotation(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select sq.salesQuotationId,sq.salesQuotationNo,sq.customerId,sq.salesInquiryId,sq.salesQuotationDate,sq.description,sq.statusId,sq.custBean from SalesQuotationBean sq where sq."
					+ advSearch + " order by sq.salesQuotationNo";

		} else {
			hql = "select sq.salesQuotationId,sq.salesQuotationNo,sq.customerId,sq.salesInquiryId,sq.salesQuotationDate,sq.description,sq.statusId,sq.custBean from SalesQuotationBean sq";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
