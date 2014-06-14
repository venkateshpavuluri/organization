package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeManager;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionPlan;
import com.mnt.erp.bean.ProductionPlanLine;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ResourceReqDetail;
import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;

public class ResourceRequestDaoImpl extends HibernateDaoSupport implements ResourceRequestDao {
	
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckResourceRequest(String fiscalYear,int fiscalYearId) {

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

	public Long checkResourceRequest(String fiscalYear) {

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

	public String saveResourceRequestDetails(Object object) {
		try {
			ResourceRequest resourceRequestBean = (ResourceRequest) object;
			Serializable id=getHibernateTemplate().save(resourceRequestBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchResourceRequest() {

		try {
			String hql = "select r.resourceReqId,r.resourceReqDate,r.employee,r.description,r.status from ResourceRequest r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<ResourceRequest> searchResourceRequestWithId(int id) {
		List<ResourceRequest> object=null;
		try {
			String hql = "from ResourceRequest r where r.resourceReqId="
					+ id + " ";
			System.out.println("the Query is:"+hql);

			object = getHibernateTemplate().find(hql);
			System.out.println("the object is:"+object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateResourceRequest(Object object) {
			
		ResourceReqDetail pc = null;
		Iterator<ResourceReqDetail> iterator1 = null;
		ResourceReqDetail pLine = null;
		List<ResourceReqDetail> list2 = null;
		try {

			ResourceRequest pg = (ResourceRequest) object;
			int id = pg.getResourceReqId();
			

			ResourceRequest po = (ResourceRequest) getHibernateTemplate().get(
					ResourceRequest.class, id);
			list2 = po.getResourceReqDetail();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (ResourceReqDetail) o;
				pc = new ResourceReqDetail();
				pc.setResourceReqDetId(pLine.getResourceReqDetId());
		
				
				pc.setStatus(new Status());
				
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

	public String deleteResourceRequest(int id) {
	
	ResourceReqDetail emp=null;
	List<ResourceReqDetail> list=null;
	try {
		list=new ArrayList<ResourceReqDetail>();
		ResourceRequest empbean=(ResourceRequest)getHibernateTemplate().get(ResourceRequest.class, id);
		empbean.setEmployee(new Employee());
		empbean.setStatus(new Status());
		List<ResourceReqDetail> beans=empbean.getResourceReqDetail();
		Iterator<ResourceReqDetail> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			emp=(ResourceReqDetail)iterator.next();
			emp.setStatus(new Status());
	
			list.add(emp);
		}
		empbean.setResourceReqDetail(list);

	getHibernateTemplate().delete(empbean);
	msg="S";

		
	} catch (Exception e) {
		msg="F";
		e.printStackTrace();

	}
	return msg;
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
	public List<Object[]> selectEmployee() {
		String sql = null;
		try {
			sql = "select employee_Id,fName from Employee";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	public List<Object[]> basicSearchResourceRequest(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.resourceReqId,r.resourceReqDate,r.employee,r.description,r.status from ResourceRequest r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteResourceReqDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			ResourceReqDetail line=new ResourceReqDetail();
			line.setResourceReqDetId(kk);
			line.setStatus(new Status());
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
