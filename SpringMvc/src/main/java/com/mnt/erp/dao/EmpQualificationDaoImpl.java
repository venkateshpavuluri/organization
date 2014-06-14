package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.EmpQualification;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Qualification;
import com.mnt.erp.service.AuditLogService;

public class EmpQualificationDaoImpl extends HibernateDaoSupport implements EmpQualificationDao {

	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> objects = null;

	public Long updateCheckEmpQualification(String equipment,String planedDate,int maintenancePlanId) {

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenancePlan m where m.equipment_Id='"
					+ equipment + "' and m.plannedDT!='" + planedDate + "' and m.maintenancePlan_Id!='" + maintenancePlanId + "'";
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

	public Long checkEmpQualificationCout(String equipment,String planedDate){

		Iterator<Object> iterator = null;
		List<Object> list = null;
		Long l = 0l;
		try {
			String sql = "select count(*) from MaintenancePlan m where m.equipment_Id='"
					+ equipment + "' and m.plannedDT!='" + planedDate + "'";
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

	public String saveEmpQualificationDetails(Object object,String userId,String userName) {
		try {
			EmpQualification empQualification = (EmpQualification) object;
			Serializable id=getHibernateTemplate().save(empQualification);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Employee Qualification",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> searchEmpQualification() {

		try {
			String hql = "select q.empQual_Id,q.employee,q.qualification,q.yearPassed,q.grade,q.board,q.totMarks,q.percentage from EmpQualification q";
		
			objects = getHibernateTemplate().find(hql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchEmpQualificationWithId(int id) {
		try {
			String hql = "select q.empQual_Id,q.employee_Id,q.qualification_Id,q.yearPassed,q.grade,q.board,q.totMarks,q.percentage from EmpQualification q where q.empQual_Id="
					+ id + " ";

			objects = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public String updateEmpQualification(Object object) {
		try {
			EmpQualification updateEmpQualification = (EmpQualification) object;
			getHibernateTemplate().update(updateEmpQualification);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	public String deleteEmpQualification(int id) {

		try {
			EmpQualification deleteEmpQualification = getHibernateTemplate().get(
					EmpQualification.class, id);
			deleteEmpQualification.setEmployee(new Employee());
			deleteEmpQualification.setQualification(new Qualification());
			getHibernateTemplate().delete(deleteEmpQualification);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();

		}
		return msg;
	}

	public List<Object[]> selectEmployee() {
		String sql = null;
		try {
			sql = "select employee_Id,fName+'--'+employeeNo from Employee";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	public List<Object[]> selectQualification() {
		String sql = null;
		try {
			sql = "select m.qualification_Id, m.qualification from Qualification m";
			objects = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}
	
	
	public List<Object[]> basicSearchEmpQualification(String label,String operator,String searchName) {
		try {

			String hql = "select q.empQual_Id,q.employee,q.qualification,q.yearPassed,q.grade,q.board,q.totMarks,q.percentage from EmpQualification q where q."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objects = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;

	}

	
	
	
}
