/**
@copyright MNT SOFT
 * 
 */
package com.mnt.erp.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionOrderProcess;
import com.mnt.erp.bean.WorkCenter;

/**
 * @author sailajach
 * @version 1.0 05-02-2014
 * @build 0.0
 * 
 */
public class ProductionOrderProcessDaoImpl extends HibernateDaoSupport
		implements ProductionOrderProcessDao {

	private Logger logger = Logger
			.getLogger(ProductionOrderProcessDaoImpl.class);
	List<Object[]> objects = null;
	String msg = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getProductionOrderNo() {
		// TODO Auto-generated method stub
		try {
			String query = "select po.prodOrderId,po.prodOrderNo from ProductionOrderBean po";
			objects = getHibernateTemplate().find(query);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getWorkCenterName() {
		// TODO Auto-generated method stub
		try {
			String query = "select wc.workCenter_Id,wc.workCenterName from WorkCenter wc";
			objects = getHibernateTemplate().find(query);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getProcessDetail() {
		// TODO Auto-generated method stub
		try {
			String query = "select pd.processdetailid,pd.processdescription from ProcessDetailBean pd";
			objects = getHibernateTemplate().find(query);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return objects;
	}

	@Override
	public String addProductionOrderProcess(Object obj) {

		try {

			ProductionOrderProcess pop = (ProductionOrderProcess) obj;

			Serializable id = getHibernateTemplate().save(pop);
			if (id != null) {
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return msg;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchProductionOrderProcess() {
		// TODO Auto-generated method stub
		try {
			String qry = "select pop.productionOrderProcessId,pop.productionOrderBean,pop.processDetailBean,pop.workCenterBean,pop.startDate,pop.finishDate from ProductionOrderProcess pop";
			objects = getHibernateTemplate().find(qry);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> basicSearchProductionOrderProcess(String label,
			String operator, String searchName) {
		try {

			String hql = "select pop.productionOrderProcessId,pop.productionOrderBean,pop.processDetailBean,pop.workCenterBean,pop.startDate,pop.finishDate from ProductionOrderProcess pop where pop."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return objects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> editProductionOrderProcessWithId(int popid) {
		// TODO Auto-generated method stub
		List<Object> objs = null;
		try {
			String hql = "from ProductionOrderProcess pop where pop.productionOrder="
					+ popid + " ";
			objs = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return objs;
	}

	@Override
	public String updateProductionOrderProcess(Object object) {
		Iterator<ProductionOrderProcess> iterator = null;
		try {

			ProductionOrderProcess orderProcess = (ProductionOrderProcess) object;
			List<ProductionOrderProcess> list = orderProcess.getPopChild();

			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object o = (Object) iterator.next();
				ProductionOrderProcess popL = (ProductionOrderProcess) o;
				getHibernateTemplate().update(popL);
			}
			msg = "S";

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return msg;
	}

	@Override
	public String deleteProductionOrderProcess(int id) {
		try {
			ProductionOrderProcess deletePop =new ProductionOrderProcess();
			deletePop.setProductionOrderProcessId(id);
			deletePop.setWorkCenterBean(new WorkCenter());
			deletePop.setProcessDetailBean(new ProcessDetailBean());
			deletePop.setProductionOrderBean(new ProductionOrderBean());
			getHibernateTemplate().delete(deletePop);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public int checkDuplicate(String checkProductionOrderNo) {
		// TODO Auto-generated method stub
		Long count = null;
		try {
			final String hql = "select count(*) from ProductionOrderProcess pop where pop.productionOrder='"
					+ checkProductionOrderNo + "'";
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
			logger.error(e.getMessage());
		}
		return count.intValue();
	}

	@Override
	public int checkEditDuplicate(String checkProductionOrderNo, String id) {
		Long count = null;
		try {
			final String hql = "select count(*) from ProductionOrderProcess pop where pop.productionOrder='"
					+ checkProductionOrderNo
					+ "' and pop.productionOrderProcessId!='" + id + "'";
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
			logger.error(e.getMessage());
		}
		return count.intValue();
	}

	@Override
	public String deleteProductionOrderProcessChild(int pLineId) {

		try {

			ProductionOrderProcess line = new ProductionOrderProcess();
			line.setProductionOrderProcessId(pLineId);

			line.setProcessDetailBean(new ProcessDetailBean());
			line.setWorkCenterBean(new WorkCenter());

			getHibernateTemplate().delete(line);

		} catch (Exception e) {
			logger.error(e.getMessage());

		}
		return "Production Order Process Deleted Successfully";
	}

}
