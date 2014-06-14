/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.OrderType;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.SalesOrderLineBean;
import com.mnt.erp.bean.SalesOrderSchLineBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.UserOrganizationBean;
import com.mnt.erp.bean.WorkFlowList;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
public class SalesOrderDaoImpl extends HibernateDaoSupport implements
		SalesOrderDao {
	private static final Logger log = Logger.getLogger(SalesOrderDaoImpl.class);
	String msg = "success";
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
	public List<Object[]> selectOrderTypeIds() {
		try {
			String sql = "select o.orderTypeId,o.orderType from OrderType o";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
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
	public int updateCheckSalesOrder(String salesNo, int siId) {
		try {
			String sql = "select count(*) from SalesOrderBean sb where  sb.salesOrderNo='"
					+ salesNo + "' and sb.salesOrderId!='" + siId + "'";
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
	public Long checkSalesOrder(String salesNo) {
		try {
			String sql = "select count(*) from SalesOrderBean sb where  sb.salesOrderNo='"
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
	public String saveSalesOrder(Object object) {

		try {
			SalesOrderBean salesOrdBean = (SalesOrderBean) object;
		Serializable id=getHibernateTemplate().save(salesOrdBean);
		logger.info("sales order save iss=="+id);
			msg="S";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public List<Object[]> searchSalesOrder() {
		try {
			String hql = "select so.salesOrderId,so.custPONumber,so.salesOrderDate,so.custPODate,so.reqDeliveryDate,so.netWeight,so.totalWeight,so.totalVolume,so.orderReason,so.priority,so.unloadingPoint,so.route,so.receivingPoint,so.custBean,so.salesGroup,so.orderType,so.paymentTerm,so.salesOrderNo,so.uomBean,so.status from SalesOrderBean so order by so.salesOrderNo";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesOrderWithId(int sId) {
		try {
			String hql = "from SalesOrderBean cb where cb.salesOrderId=" + sId;
			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesOrder(Object object) {
		try {
			SalesOrderBean salesBeanUp = (SalesOrderBean) object;
			SalesOrderBean sBean = (SalesOrderBean) getHibernateTemplate().get(
					SalesOrderBean.class, salesBeanUp.getSalesOrderId());
			for (SalesOrderLineBean cbDelete : sBean.getSalesOrderLineBean()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setUom(new Uom());
				cbDelete.setCurrency(new Currency());
				getHibernateTemplate().delete(cbDelete);
			}
			getHibernateTemplate().update(salesBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			msg = "F";
		}
		return msg;
	}

	@Override
	public String deleteSalesOrder(int dId) {
		String msg = null;
		try {
			SalesOrderBean delSales = new SalesOrderBean();
			delSales.setSalesOrderId(dId);
			SalesOrderBean deleteSales = getHibernateTemplate().get(
					SalesOrderBean.class, dId);
			deleteSales.setCustBean(new CustomerBean());
			deleteSales.setSalesGroup(new SalesGroup());
			deleteSales.setPaymentTerm(new PaymentTerms());
			deleteSales.setOrderType(new OrderType());
			deleteSales.setUomBean(new Uom());
			for (SalesOrderLineBean cbDelete : deleteSales
					.getSalesOrderLineBean()) {
				cbDelete.setMaterial(new Material());
				cbDelete.setUom(new Uom());
				cbDelete.setCurrency(new Currency());
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
	public List<Object[]> basicSearchSalesOrder(String label, String operator,
			String searchName) {
		try {

			String hql = "select so.salesOrderId,so.custPONumber,so.salesOrderDate,so.custPODate,so.reqDeliveryDate,so.netWeight,so.totalWeight,so.totalVolume,so.orderReason,so.priority,so.unloadingPoint,so.route,so.receivingPoint,so.custBean,so.salesGroup,so.orderType,so.paymentTerm,so.salesOrderNo,so.uomBean,so.status from SalesOrderBean so where so."
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
	public String deleteSalesOrderLine(int slId) {
		try {
			SalesOrderLineBean SLBean = (SalesOrderLineBean) getHibernateTemplate()
					.get(SalesOrderLineBean.class, slId);
			SLBean.setCurrency(new Currency());
			SLBean.setMaterial(new Material());
			SLBean.setUom(new Uom());
			getHibernateTemplate().delete(SLBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";

	}

	@Override
	public String deleteSalesOrderSch(int scId) {
		try {
			SalesOrderSchLineBean SCBean = (SalesOrderSchLineBean) getHibernateTemplate()
					.get(SalesOrderSchLineBean.class, scId);
			SCBean.setChildUom(new Uom());
			getHibernateTemplate().delete(SCBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Deleted";
	}

	@Override
	public List<UserOrganizationBean> getOrganizationId(String userId) {
		List<UserOrganizationBean> user = null;
		try {
			String sql = "from UserOrganizationBean u where u.userid='"
					+ userId + "'";
			user = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<Object[]> advSearchSalesOrder(String advSearch) {
		String hql = null;

		if (!advSearch.equalsIgnoreCase("ALL")) {
			hql = "select so.salesOrderId,so.custPONumber,so.salesOrderDate,so.custPODate,so.reqDeliveryDate,so.netWeight,so.totalWeight,so.totalVolume,so.orderReason,so.priority,so.unloadingPoint,so.route,so.receivingPoint,so.custBean,so.salesGroup,so.orderType,so.paymentTerm,so.salesOrderNo,so.uomBean,so.status from SalesOrderBean so where so."
					+ advSearch + " order by so.salesOrderNo";

		} else {
			hql = "select so.salesOrderId,so.custPONumber,so.salesOrderDate,so.custPODate,so.reqDeliveryDate,so.netWeight,so.totalWeight,so.totalVolume,so.orderReason,so.priority,so.unloadingPoint,so.route,so.receivingPoint,so.custBean,so.salesGroup,so.orderType,so.paymentTerm,so.salesOrderNo,so.uomBean,so.status from SalesOrderBean so order by so.salesOrderNo";

		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		return list;
	}

	@Override
	public String saveWorkFlowListDaoDetails(WorkFlowList workFlowList) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
		Serializable id=getHibernateTemplate().save(workFlowList);
		if(id!=null)
		{
			msg="S";
		}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getStepUsers() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			 list=getHibernateTemplate().findByNamedQuery("StepUserForSO");
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

}
