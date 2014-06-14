package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Currency;

/**
 * @author Gkiran
 */

public interface CurrencyService {
	public String  setCurrencySave(Currency mm,String userId,String userName);

	public List<Object[]> getCurrency(String currency);

	public List<Object[]> getCurrencyId(int id);

	public String updateCurrency(Object object);

	public String currencyDelete(int id);

	public Long checkDuplicateCurrency(String name);

	public Long checkDuplicateCurrencyUpdate(String name, int id);

	public List<Object[]> currencyIdGet();
	public List<Object[]> getCurrencyCode();

	public List<Object[]> basicSearchCurrency(String label, String operator,
			String searchName);

}
