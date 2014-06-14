package com.mnt.erp.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.EmpPerformance;
import com.mnt.erp.bean.EmpPerformanceKPI;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.KPIBean;
import com.mnt.erp.bean.Status;

public class EmpPerformanceDaoImpl extends HibernateDaoSupport implements EmpPerformanceDao {
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckEmpPerformance(String equipment,int id) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from EmpPerformance at where  at.equipmentId ='"
					+ equipment + "' and at.EmpPerformanceSchId!='" + id + "'";
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

	public Long checkEmpPerformance(String employee) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from EmpPerformance g where  g.equipmentId='"
					+ employee + "'";
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

	public String saveEmpPerformanceDetails(Object object) {
		try {
			EmpPerformance EmpPerformanceBean = (EmpPerformance) object;
			Serializable id=getHibernateTemplate().save(EmpPerformanceBean);
			if(id!=null){
				msg="S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchEmpPerformance() {

		try {
			String hql = "select r.performanceReviewId,r.employee,r.periodFrom,r.periodTo,r.status from EmpPerformance r";
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<EmpPerformance> searchEmpPerformanceWithId(int id) {
		List<EmpPerformance> object=null;
		try {
			String hql = "from EmpPerformance r where r.performanceReviewId="
					+ id + " ";
			object = getHibernateTemplate().find(hql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	public String updateEmpPerformance(Object object) {
			
		EmpPerformanceKPI pc = null;
		Iterator<EmpPerformanceKPI> iterator1 = null;
		EmpPerformanceKPI pLine = null;
		List<EmpPerformanceKPI> list2 = null;
		try {

			EmpPerformance pg = (EmpPerformance) object;
			int id = pg.getPerformanceReviewId();
			System.out.println("the id is:"+id);
			EmpPerformance po = (EmpPerformance) getHibernateTemplate().get(
					EmpPerformance.class, id);
			list2 = po.getEmpPerformanceKPI();

			iterator1 = list2.iterator();
			while (iterator1.hasNext()) {
				Object o = (Object) iterator1.next();
				pLine = (EmpPerformanceKPI) o;
				pc = new EmpPerformanceKPI();
				System.out.println("the child id is:"+pLine.getPerformanceReviewKPIId());
				pc.setPerformanceReviewKPIId(pLine.getPerformanceReviewKPIId());
				pc.setKpibean(new KPIBean());
		
	
			
				
				//getHibernateTemplate().delete(pc);

			}

			getHibernateTemplate().update(pg);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		
		
		return msg;
	}

	public String deleteEmpPerformance(int id) {
	
		EmpPerformanceKPI emp=null;
	List<EmpPerformanceKPI> list=null;
	try {
		list=new ArrayList<EmpPerformanceKPI>();
		EmpPerformance empbean=(EmpPerformance)getHibernateTemplate().get(EmpPerformance.class, id);
		empbean.setEmployee(new Employee());
		empbean.setStatus(new Status());
		List<EmpPerformanceKPI> beans=empbean.getEmpPerformanceKPI();
		Iterator<EmpPerformanceKPI> iterator=beans.iterator();
		while(iterator.hasNext())

		{
			
			emp=(EmpPerformanceKPI)iterator.next();
			emp.setKpibean(new KPIBean());
			emp.setEmployee(new Employee());
		
	
			list.add(emp);
		}
		empbean.setEmpPerformanceKPI(list);

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

	public List<Object[]> selectKpi() {
		String sql = null;
		try {
			sql = "select KPIId,KPI from KPIBean";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	
	public List<Object[]> basicSearchEmpPerformance(String label, String operator,
			String searchName) {
		try {

			String hql = "select r.performanceReviewId,r.employee,r.periodFrom,r.periodTo,r.status from EmpPerformance r where r."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	public String deleteEmpPerformanceDetail(int kk){
		// TODO Auto-generated method stub
		try {
			
			EmpPerformanceKPI line=new EmpPerformanceKPI();
		line.setPerformanceReviewKPIId(kk);
		line.setKpibean(new KPIBean());
			
					
			getHibernateTemplate().delete(line);
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "S";
	}

}
