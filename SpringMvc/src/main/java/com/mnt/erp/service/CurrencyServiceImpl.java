package com.mnt.erp.service;

import java.io.Serializable;

import java.util.List;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.dao.LoginDaoImpl;
import com.mnt.erp.dao.CurrencyDao;
import com.mnt.erp.dao.CurrencyDaoImpl;

/**
 * @author Gkiran
 */

public class CurrencyServiceImpl implements CurrencyService, Serializable {
	private com.mnt.erp.dao.CurrencyDaoImpl dao;

	public CurrencyDaoImpl getDao() {
		return dao;
	}

	public void setDao(CurrencyDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public List<Object[]> getCurrency(String currency) {
		List<Object[]> list = dao.setCurrencySearch(currency);
		return list;
	}

	@Override
	public List<Object[]> getCurrencyId(int id) {
		List<Object[]> list = dao.setCurrencySearch(id);
		return list;
	}

	@Override
	public String updateCurrency(Object object) {
		String msg = null;
		try {
			msg = dao.updateCurrency(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String currencyDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.currencyDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String setCurrencySave(com.mnt.erp.bean.Currency mm,String userId,String userName) {
		String success = dao.setCurrency(mm,userId,userName);

		return success;

	}

	public Long checkDuplicateCurrency(String name) {
		Long success = dao.checkDuplicateCurrency(name);
		return success;

	}

	public Long checkDuplicateCurrencyUpdate(String name, int id) {
		Long success = dao.checkDuplicateCurrencyUpdate(name, id);
		return success;

	}

	@Override
	public List<Object[]> currencyIdGet() {
		// TODO Auto-generated method stub

		List<Object[]> idsList = dao.currencyIdGet();
		return idsList;

	}

	public List<Object[]> basicSearchCurrency(String label, String operator,
			String searchName) {
		List<Object[]> list = null;
		try {
			list = dao.basicSearchCurrency(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Object[]> getCurrencyCode() {
		// TODO Auto-generated method stub
		List<Object[]> currencyCode=dao.getCurrencyCode();
		return currencyCode;
	}
}
