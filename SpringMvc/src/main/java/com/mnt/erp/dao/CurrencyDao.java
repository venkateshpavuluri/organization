package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Currency;

/**
 * @author Gkiran
 */

public interface CurrencyDao {

	public String setCurrency(Currency mm,String userId,String userName);

	public List<Object[]> setCurrencySearch(String name);

	public List<Object[]> setCurrencySearch(int id);

	public String updateCurrency(Object object);

	public String currencyDelete(int id);

	public Long checkDuplicateCurrency(String name);

	public Long checkDuplicateCurrencyUpdate(String name, int id);

	public List<Object[]> currencyIdGet();
	
	public List<Object[]> getCurrencyCode();
	
	public List<Object[]> basicSearchCurrency(String label, String operator,
			String searchName);

}
