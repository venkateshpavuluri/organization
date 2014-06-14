package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeManager;
import com.mnt.erp.bean.GLFiscalYear;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionPlan;
import com.mnt.erp.bean.ProductionPlanLine;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;

public class ProductionPlanDaoImpl extends HibernateDaoSupport implements ProductionPlanDao{
@Autowired
AuditLogService auditLogService;
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckProductionPlan(String fiscalYear,int fiscalYearId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from GLFiscalYear at where  at.fiscalYear ='"
					+ fiscalYear + "' and at.gLFiscalYear_Id!='" + fiscalYearId + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public Long checkProductionPlan(String fiscalYear) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from GLFiscalYear g where  g.fiscalYear='"
					+ fiscalYear + "'";
			list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				l = (Long) object;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public String saveProductionPlanDetails(Object object,String userId,String userName) {
		try {
			ProductionPlan productionPlanBean = (ProductionPlan) object;
	Serializable id=getHibernateTemplate().save(productionPlanBean);
	if(id!=null)
	{
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(userId,"A","Production Plan","ROW" ,String.valueOf(id),"1",modifiedDate,userName);	
		msg="S";
	}
			

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchProductionPlan() {

		try {
			String hql = "select p.productionPlan_Id,p.productionPlanType,p.planDate,p.plant,p.project,p.status from ProductionPlan p";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> searchProductionPlanWithId(int id) {
		List<Object> object=null;
		try {
			String hql = "from ProductionPlan p where p.productionPlan_Id="
					+ id + " ";

			object = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateProductionPlan(Object object) {
				
		ProductionPlanLine pc = null;
		Iterator<ProductionPlanLine> iterator1 = null;
		ProductionPlanLine pLine = null;
		List<ProductionPlanLine> list2 = null;
		try {

			ProductionPlan pg = (ProductionPlan) object;
			int id = pg.getProductionPlan_Id();
			

			ProductionPlan po = (ProductionPlan) getHibernateTemplate().get(
					ProductionPlan.class, id);
			list2 = po.getProductionPlanLine();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (ProductionPlanLine) o;
				pc = new ProductionPlanLine();
				pc.setProductionPlanLine_Id(pLine.getProductionPlanLine_Id());
		
				
				pc.setMaterial(new Material());
				pc.setUom(new Uom());
				pc.setProductionOrder(new ProductionOrderBean());
				getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public String deleteProductionPlan(int id) {

		/*ProductionPlanLine emp=null;
		List<ProductionPlanLine> list=null;*/
		try {
			ProductionPlan productionPlan=new ProductionPlan();
			productionPlan.setProductionPlan_Id(id);
			/*list=new ArrayList<ProductionPlanLine>();
			ProductionPlan empbean=(ProductionPlan)getHibernateTemplate().get(ProductionPlan.class, id);
			List<ProductionPlanLine> beans=empbean.getProductionPlanLine();
			Iterator<ProductionPlanLine> iterator=beans.iterator();
			while(iterator.hasNext())
			{
				emp=(ProductionPlanLine)iterator.next();
				emp.setMaterial(new Material());
				emp.setUom(new Uom());
				emp.setProductionOrder(new ProductionOrderBean());
				
				list.add(emp);
			}
			empbean.setProductionPlanLine(list);*/
	
		getHibernateTemplate().delete(productionPlan);
		msg="S";
	} catch (Exception e) {
		msg="F";
		e.printStackTrace();

	}
	
		return msg;
	}

	public List<Object[]> selectPlant() {
		String sql = null;
		try {
			sql = "select plantId,plantName from Plant";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	public List<Object[]> selectProductionPlanType() {
		String sql = null;
		try {
			sql = "select productionPlanTypeId,productionPlanType from productionPlanTypeBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectStatus() {
		String sql = null;
		try {
			sql = "select statusId,status from Status";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectProject() {
		String sql = null;
		try {
			sql = "select projectId,projectName from Project";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public List<Object[]> selectMaterial() {
		String sql = null;
		try {
			sql = "select material_Id,materialName from Material";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public List<Object[]> selectUom() {
		String sql = null;
		try {
			sql = "select uom_Id,uom from Uom";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public List<Object[]> selectProductionOrderNums() {
		String sql = null;
		try {
			sql = "select prodOrderId,prodOrderNo from ProductionOrderBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> basicSearchProductionPlan(String label, String operator,
			String searchName) {
		try {

			String hql = "select g.gLFiscalYear_Id,g.fiscalYear,g.calendarYear,g.startDate,g.endDate,g.fiscalYearClosed from GLFiscalYear g where g."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteProductionPlanLine(int kk){
		// TODO Auto-generated method stub
		try {
			
			ProductionPlanLine line=new ProductionPlanLine();
			line.setProductionPlanLine_Id(kk);
			
			line.setMaterial(new Material());
			line.setUom(new Uom());
			line.setProductionOrder(new ProductionOrderBean());
		
			
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "Production Plan Line Deleted Successfully";
	}
}
