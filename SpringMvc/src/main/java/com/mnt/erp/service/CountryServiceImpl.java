/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.CountryDao;

/**
 * @author pvenkateswarlu
 * 
 */
public class CountryServiceImpl implements CountryService {

	CountryDao countryDao;

	public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	
	@Override
	public List<Object[]> getCountryIds() {
		// TODO Auto-generated method stub
		List<Object[]> list = null;
		try {
			list = countryDao.getCountryIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
