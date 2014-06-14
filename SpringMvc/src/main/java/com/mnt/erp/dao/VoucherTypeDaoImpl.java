package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.mnt.erp.bean.VoucherTypeBean;
import com.mnt.erp.service.AuditLogService;

public class VoucherTypeDaoImpl extends HibernateDaoSupport implements VoucherTypeDao {
	@Autowired
	AuditLogService auditLogService;
	String msg=null;
	List<Object[]> list = null;
	@Override
	public String saveVoucherType(Object object,String userId,String userName) {
		try{
			VoucherTypeBean vtbean=(VoucherTypeBean) object;
			Serializable id=getHibernateTemplate().save(vtbean);
			if (id != null) {

				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(userId, "A", "Voucher Type",
						"ROW", String.valueOf(id), "1", modifiedDate, userName);
				msg = "S";
			}
		}catch(Exception e){
			msg="F";
			e.printStackTrace();
			
		}
		return msg;
	}

	@Override
	public List<Object[]> searchVoucherTypeWithId(int id) {
		try {
			String hql1 = "select vt.vouchertypeid,vt.vouchertype from VoucherTypeBean vt where vt.vouchertypeid="
					+ id + "";
			
			list = getHibernateTemplate().find(hql1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchVoucherType() {
		try {
			String hql = "select vt.vouchertypeid,vt.vouchertype from VoucherTypeBean vt order by vt.vouchertype";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> selectVoucherTypeIds() {
		try {
			String hql = "select vt.vouchertypeid,vt.vouchertype from VoucherTypeBean vt";
			list = getHibernateTemplate().find(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateVoucherType(Object object) {
		try {
			VoucherTypeBean vbean = (VoucherTypeBean) object;
			
			getHibernateTemplate().update(vbean);
			msg="S";

		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteVoucherType(int id) {
		try {
			VoucherTypeBean vbean = (VoucherTypeBean) getHibernateTemplate()
					.get(VoucherTypeBean.class, id);
			getHibernateTemplate().delete(vbean);
			msg="S";
		} catch (Exception e) {
			msg="F";
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Long getVoucherTypeCount(String name) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VoucherTypeBean ab where ab.vouchertype='"
					+ name + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Long getVoucherTypeCountedit(String name, int vtid) {
		Iterator<Object> iterator = null;
		Long p = 1L;
		try {
			String sql = "select count(*) from VoucherTypeBean ab where ab.vouchertype='"
					+ name + "'and ab.vouchertypeid!='" + vtid + "'";
			List<Object> list = getHibernateTemplate().find(sql);
			iterator = list.iterator();

			while (iterator.hasNext()) {
				Object object = (Object) iterator.next();
				p = (Long) object;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public List<Object[]> basicSearchVoucherType(String label, String operator,
			String searchName) {
		try {

			String hql = "select vt.vouchertypeid,vt.vouchertype from VoucherTypeBean vt where vt."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			list = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
