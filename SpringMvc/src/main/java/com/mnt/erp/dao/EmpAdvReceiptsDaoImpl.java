package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.mnt.erp.bean.EmpAdvanceReceipts;
import com.mnt.erp.service.AuditLogService;

public class EmpAdvReceiptsDaoImpl extends HibernateDaoSupport implements
		EmpAdvReceiptDao {
	String msg;
	@Autowired
	AuditLogService auditLogService;
	List<Object[]> list = null;

	@Override
	public String saveEmpAdvReceipts(Object object, String userId,
			String userName) {
		try {
			EmpAdvanceReceipts emprecbean = (EmpAdvanceReceipts) object;
			Serializable id = getHibernateTemplate().save(emprecbean);
			if (id != null) {
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A",
						"Employee Advance Receipts", "ROW", String.valueOf(id),
						"1", modifiedDate, userName);
				msg = "S";
			}

		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();

		}

		return msg;
	}

	@Override
	public List<Object[]> searchEmpAdvReceiptsWithId(int id) {
		try {
			String hql1 = "select er.earId,er.earadvId,er.receivedamount,er.receiveddate,er.month from EmpAdvanceReceipts er where er.earId="
					+ id + "";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchEmpAdvReceipts() {
		try {
			String hql1 = "select er.earId,er.empadvrecbean,er.receivedamount,er.receiveddate,er.month from EmpAdvanceReceipts er ";
			list = getHibernateTemplate().find(hql1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectempadvreceiptIds() {
		try {
			String hql = "select er.earId,er.empadvrecbean,er.receivedamount,er.receiveddate,er.month from EmpAdvanceReceipts er";
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
	public String updateEmpAdvReceipts(Object object) {
		try {
			EmpAdvanceReceipts empbean = (EmpAdvanceReceipts) object;
			getHibernateTemplate().update(empbean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteEmpAdvReceipts(int id) {
		try {
			EmpAdvanceReceipts empBean = new EmpAdvanceReceipts();
			empBean.setEarId(id);
			getHibernateTemplate().delete(empBean);
			msg = "S";
		} catch (Exception e) {
			msg = "F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getEmpAdvReceiptsCount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getEmpAdvReceiptsCountedit(String name, int eapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object[]> basicSearchEmpadvrec(String label, String operator,
			String searchName) {
		try {

			String hql = "select er.earId,er.empadvrecbean,er.receivedamount,er.receiveddate,er.month from EmpAdvanceReceipts er  where er."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
