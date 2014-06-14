/**
 *@Copyright MNTSOFT   
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesInquiryBean;
import com.mnt.erp.bean.SalesInquiryLineBean;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 07-11-2013
 */
public class SalesInquiryDaoImpl extends HibernateDaoSupport implements
		SalesInquiryDao {

	String success;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public int updateCheckSalesInquiry(String salesNo, int siId) {
		try {
			String sql = "select count(*) from SalesInquiryBean sb where  sb.salesInquiryNo='"
					+ salesNo + "' and sb.salesInquiryId!='" + siId + "'";
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
	public Long checkSalesInquiry(String salesNo) {
		try {
			String sql = "select count(*) from SalesInquiryBean sb where  sb.salesInquiryNo='"
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
	public String saveSalesInquiry(Object object) {
		String msg = null;
		try {
			SalesInquiryBean salesInqBean = (SalesInquiryBean) object;
			salesInqBean.setStatusId("1");
			getHibernateTemplate().save(salesInqBean);
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> searchSalesInquiry() {
		try {
			String hql = "select cb.salesInquiryId,cb.salesInquiryNo,cb.requestedDate,cb.validFrom,cb.validTo,cb.requiredDeliveryDate,cb.description,cb.statusId,cb.custBean,cb.salesGroup from SalesInquiryBean cb";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesInquiryWithId(int sId) {
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
	public String updateSalesInquiry(Object object) {
		try {
			SalesInquiryBean salesBeanUp = (SalesInquiryBean) object;
			SalesInquiryBean sBean = (SalesInquiryBean) getHibernateTemplate()
					.get(SalesInquiryBean.class,
							salesBeanUp.getSalesInquiryId());
			for (SalesInquiryLineBean cbDelete : sBean.getSalesEnquiryLine()) {
				cbDelete.setMaterial(new Material());
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
	public String deleteSalesInquiry(int cId) {
		String msg = null;

		try {
			SalesInquiryBean delSales = new SalesInquiryBean();
			delSales.setSalesInquiryId(cId);
			SalesInquiryBean deleteSales = getHibernateTemplate().get(
					SalesInquiryBean.class, cId);
			deleteSales.setCustBean(new CustomerBean());
			deleteSales.setSalesGroup(new SalesGroup());
			for (SalesInquiryLineBean cbDelete : deleteSales
					.getSalesEnquiryLine()) {
				cbDelete.setMaterial(new Material());
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
	public List<Object[]> basicSearchSalesInquiry(String label,
			String operator, String searchName) {
		try {

			String hql = "select cb.salesInquiryId,cb.salesInquiryNo,cb.requestedDate,cb.validFrom,cb.validTo,cb.requiredDeliveryDate,cb.description,cb.statusId,cb.custBean,cb.salesGroup from SalesInquiryBean cb where cb."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

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
	public List<Object[]> selectSalesGroupIds() {
		try {
			String sql = "select s.salesGroup_Id,s.salesGroup from SalesGroup s";
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
	public String deleteSalesLine(int id) {
		try {
			SalesInquiryLineBean sLine = (SalesInquiryLineBean) getHibernateTemplate()
					.get(SalesInquiryLineBean.class, id);
			sLine.setMaterial(new Material());
			sLine.setUom(new Uom());
			getHibernateTemplate().delete(sLine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

	@Override
	public List<Object[]> advSearchSalesInquiry(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select cb.salesInquiryId,cb.salesInquiryNo,cb.requestedDate,cb.validFrom,cb.validTo,cb.requiredDeliveryDate,cb.description,cb.statusId,cb.custBean,cb.salesGroup from SalesInquiryBean cb where cb."
					+ advSearch + " order by cb.salesInquiryNo";

		} else {
			hql = "select cb.salesInquiryId,cb.salesInquiryNo,cb.requestedDate,cb.validFrom,cb.validTo,cb.requiredDeliveryDate,cb.description,cb.statusId,cb.custBean,cb.salesGroup from SalesInquiryBean cb";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

}
