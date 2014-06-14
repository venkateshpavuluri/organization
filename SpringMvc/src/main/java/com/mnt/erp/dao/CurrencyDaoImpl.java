package com.mnt.erp.dao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.service.AuditLogService;

/**
 * @author Gkiran
 */

public class CurrencyDaoImpl extends HibernateDaoSupport implements CurrencyDao {
	private static Logger logger=Logger.getLogger(CurrencyDaoImpl.class);

	
	@Autowired
	AuditLogService auditLogService;
	String success = null;

	@Override
	public String setCurrency(com.mnt.erp.bean.Currency mm,String userId,String userName) {
		Serializable id=null;
		try {
	 id=getHibernateTemplate().save(mm);
if(id!=null)
{
	Date date = new Date();
	String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	auditLogService.setAuditLogSave(userId,"A","Currency","ROW" ,String.valueOf(id),"1",modifiedDate,userName);
	success = "S";
}	
		} catch (Exception e) {
			success = "F";
			e.printStackTrace();
		}
		return success;

	}

	@Override
	public List<Object[]> setCurrencySearch(String currency) {
		String hql = null;
		if (currency.equalsIgnoreCase("ALL")) {
			hql = "select h.currencyId,h.currency,h.isoCode,h.symbol from Currency h";
			
		}

		if (!currency.equalsIgnoreCase("ALL")) {
			hql = "select h.currencyId,h.currency,h.isoCode,h.symbol from Currency h where h.currency='"
					+ currency + "'";
			
		}
		List<Object[]> list = getHibernateTemplate().find(hql);

		/*
		 * for (Object[] objects : list) {
		 * System.out.println("with in the dao for Material Search=="+objects);
		 * }
		 */
	
		return list;

	}

	@Override
	public List<Object[]> setCurrencySearch(int id) {
		

		String hql = "select h.currencyId,h.currency,h.isoCode,h.symbol from Currency h where h.currencyId="
				+ id;

		List<Object[]> list = getHibernateTemplate().find(hql);

	
		return list;

	}

	@Override
	public String updateCurrency(Object object) {
		String sucMess=null;
		try {
			com.mnt.erp.bean.Currency currency = (com.mnt.erp.bean.Currency) object;

			int id = currency.getCurrencyIdEdit();
			String currencyvalue = currency.getCurrencyEdit();
			String isoCodevalue = currency.getIsoCodeEdit();
			String symbolvalue = currency.getSymbolEdit();

			

			currency.setCurrencyId(id);
			currency.setIsoCode(isoCodevalue);
			currency.setSymbol(symbolvalue);

			currency.setCurrency(currencyvalue);

			getHibernateTemplate().update(currency);
			sucMess="S";

		} catch (Exception e) {
			sucMess="F";
			e.printStackTrace();
		}

		return sucMess;
	}

	public String currencyDelete(int id) {
		com.mnt.erp.bean.Currency currency = null;
		String sucMesg=null;
		try {
			currency = (com.mnt.erp.bean.Currency) getHibernateTemplate().get(
					com.mnt.erp.bean.Currency.class, id);
			getHibernateTemplate().delete(currency);
			sucMesg="S";
		} catch (Exception e) {
			sucMesg="F";
			logger.error(e.getMessage());
			
		}
		return sucMesg;
	}

	public Long checkDuplicateCurrency(String mm) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from Currency h where h.currency='"
					+ mm + "'";
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;
				// System.out.println("kiran duplicae Bom    "+count);
			}
			// success =count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public Long checkDuplicateCurrencyUpdate(String mm, int id) {
		List<Object> list = null;
		Iterator<Object> it = null;
		Long count = null;
		try {

			String hql = "select count(*) from Currency h where h.currency='"
					+ mm + "' AND h.currencyId!=" + id;
			list = getHibernateTemplate().find(hql);
			it = list.iterator();
			for (Object object : list) {
				count = (Long) object;
				// System.out.println("kiran duplicae Bom    "+count);
			}
			// success =count;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	@Override
	public List<Object[]> currencyIdGet() {
		// TODO Auto-generated method stub

		String hql = "select c.currencyId,c.currency from Currency c";
		List<Object[]> cList = getHibernateTemplate().find(hql);

		return cList;
	}
	
	public List<Object[]> basicSearchCurrency(String label, String operator,
			String searchName){
		List<Object[]> objs=null;
		try {

			String hql = "select h.currencyId,h.currency,h.isoCode,h.symbol from Currency h where h."
					+ label + "" + operator + " ? ";

			Object[] parameters = { searchName };
			objs = getHibernateTemplate().find(hql, parameters);
		} catch (Exception e) {
		logger.error(e.getMessage());
		}
		return objs;
	}
	
	@Override
	public List<Object[]> getCurrencyCode() {
		// TODO Auto-generated method stub
		String hql="select c.currencyId,c.isoCode from Currency c";
		  List<Object[]> currencyList=getHibernateTemplate().find(hql);
			
			return currencyList;
	}

}
