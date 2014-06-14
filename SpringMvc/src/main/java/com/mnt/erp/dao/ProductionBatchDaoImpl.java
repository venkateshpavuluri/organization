package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.ProductionBatchBean;
import com.mnt.erp.service.AuditLogService;

public class ProductionBatchDaoImpl extends HibernateDaoSupport implements ProductionBatchDao {
	String msg;
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	@Override
	public String saveProductionBatch(Object object,String userId,String userName) {
		try {
			ProductionBatchBean pdbean = (ProductionBatchBean) object;
			Serializable id=getHibernateTemplate().save(pdbean);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Production Batch",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
			

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}

		return msg;
	}

	@Override
	public List<Object[]> searchProductionBatchWithId(int id) {
		try {
			String hql1 = "select ag.probatchId,ag.proId,ag.batchtype,ag.batchdate,ag.batchqty,ag.batchstdt,ag.deliverydt,ag.batchedt,ag.batchastdt,ag.batchaedt,ag.statusId from ProductionBatchBean ag where ag.probatchId="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchProductionBatch() {
		
		try {
			String hql = "select ag.probatchId,ag.pobean,ag.batchtype,ag.batchdate,ag.batchqty,ag.batchstdt,ag.deliverydt,ag.batchedt,ag.batchastdt,ag.batchaedt,ag.statusbean from ProductionBatchBean ag";
			list = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectproductionorderIds() {
		try{
			String hql="select p.prodOrderId,p.prodOrderNo from ProductionOrderBean p";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<Object[]> selectStatus() {
		try{
			String hql="select p.statusId,p.status from Status p";
			list=getHibernateTemplate().find(hql);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateProductionBatch(Object object) {
		try {
			ProductionBatchBean pbBean = (ProductionBatchBean) object;
			getHibernateTemplate().update(pbBean);
            msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteProductionBatch(int id) {
		try {
			ProductionBatchBean pbbean=new ProductionBatchBean();
			pbbean.setProbatchId(id);
			getHibernateTemplate().delete(pbbean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getProductionBatchCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getProductionBatchCountedit(String name, int accountgroupid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchProductionBatch(String label,
			String operator, String searchName) {
		try {

			String hql = "select ag.probatchId,ag.pobean,ag.batchtype,ag.batchdate,ag.batchqty,ag.batchstdt,ag.deliverydt,ag.batchedt,ag.batchastdt,ag.batchaedt,ag.statusbean from ProductionBatchBean ag where ag."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
