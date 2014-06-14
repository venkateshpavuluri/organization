package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.EmpAdvancePayments;
import com.mnt.erp.service.AuditLogService;

public class EmpAdvPaymentsDaoImpl extends HibernateDaoSupport implements EmpAdvPaymentsDao {
	String msg;
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;
	@Override
	public String saveEmpAdvPayments(Object object, String userId,
			String userName) {
		try {
			EmpAdvancePayments empbean = (EmpAdvancePayments) object;
			Serializable id = getHibernateTemplate().save(empbean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Employee Advance Payments",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;
	}

	@Override
	public List<Object[]> searchEmpAdvPaymentsWithId(int id) {
		try {
			String hql1 = "select e.eapId,e.empadvId,e.paidamount,e.paiddate,e.month from EmpAdvancePayments e where e.eapId="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchEmpAdvPayments() {
		try {
			String hql1 = "select e.eapId,e.empadvbean,e.paidamount,e.paiddate,e.month from EmpAdvancePayments e ";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectempadvpaymentIds() {
		try {
			String hql = "select e.eapId,e.empadvbean,e.paidamount,e.paiddate,e.month from EmpAdvancePayments e ";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectEmpadv() {
		try {
			String hql = "select e.empAdvanceId,e.advanceAmount from EmpAdvance e ";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateEmpAdvPayments(Object object) {
		try {
			EmpAdvancePayments empbean = (EmpAdvancePayments) object;
			getHibernateTemplate().update(empbean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteEmpAdvPayments(int id) {
		try {
			EmpAdvancePayments empBean = new EmpAdvancePayments();
			empBean.setEapId(id);
			getHibernateTemplate().delete(empBean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getEmpAdvPaymentsCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getEmpAdvPaymentsCountedit(String name, int eapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchEmpadvpay(String label, String operator,
			String searchName) {
		try {

			String hql = "select e.eapId,e.empadvbean,e.paidamount,e.paiddate,e.month from EmpAdvancePayments e  where e."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
