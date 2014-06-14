/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;

/**
 * @author Naresh
 * @version 1.0 24-01-2014
 */
public class ProductionOrderDaoImpl extends HibernateDaoSupport implements
		ProductionOrderDao {
	boolean flag = true;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Iterator<Object> iterator = null;

	@Override
	public Long updateCheckProdOrder(String poNo, int poId) {
		try {
			String sql = "select count(*) from ProductionOrderBean db where  db.prodOrderNo='"
					+ poNo + "' and db.prodOrderId!='" + poId + "'";
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
	public Long checkProdOrderCout(String poNo) {
		try {
			String sql = "select count(*) from ProductionOrderBean po where  po.prodOrderNo='"
					+ poNo + "'";
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
	public boolean saveProdOrderDetails(Object object) {
		try {
			ProductionOrderBean poBean = (ProductionOrderBean) object;
			getHibernateTemplate().save(poBean);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchProdOrder() {
		try {
			String hql = "select po.prodOrderId,po.prodOrderNo,po.prodOrderDate,po.totQty,po.estStartDate,po.estEndDate,po.actStartDate,po.actEndDate,po.priority,po.desc,po.prodOrderType,po.salesOrder,po.material,po.plant,po.uom,po.status from ProductionOrderBean po";

			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchProdOrderWithId(int poId) {
		try {
			String hql = "from ProductionOrderBean po where po.prodOrderId='"
					+ poId + "'";

			obj = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateProdOrder(Object object) {
		try {
			ProductionOrderBean poBeanUp = (ProductionOrderBean) object;
			getHibernateTemplate().update(poBeanUp);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOrder(int poId) {
		try {
			ProductionOrderBean pob = new ProductionOrderBean();
			pob.setProdOrderId(poId);
			pob.setSalesOrder(new SalesOrderBean());
			pob.setStatus(new Status());
			pob.setMaterial(new Material());
			pob.setPlant(new Plant());
			pob.setUom(new Uom());

			getHibernateTemplate().delete(pob);

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();

		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchProdOrder(String label, String operator,
			String searchName) {
		try {
			String hql = "select po.prodOrderId,po.prodOrderNo,po.prodOrderDate,po.totQty,po.estStartDate,po.estEndDate,po.actStartDate,po.actEndDate,po.priority,po.desc,po.prodOrderType,po.salesOrder,po.material,po.plant,po.uom,po.status from ProductionOrderBean po where po."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
