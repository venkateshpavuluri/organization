/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesAreaDao;

/**
 * @author Naresh
 * @version 1.0 31-10-2013
 */
public class SalesAreaServiceImpl implements SalesAreaService {
	List<Object[]> objects = null;
	String sus = null;

	SalesAreaDao salesAreaDao;

	public SalesAreaDao getSalesAreaDao() {
		return salesAreaDao;
	}

	public void setSalesAreaDao(SalesAreaDao salesAreaDao) {
		this.salesAreaDao = salesAreaDao;
	}

	@Override
	public Long updateCheckSalesArea(String salesArea, int salesId) {
		Long l = salesAreaDao.updateCheckSalesArea(salesArea, salesId);
		return l;
	}

	@Override
	public Long checkSalesAreaCout(String salesArea) {
		Long l = salesAreaDao.checkSalesAreaCout(salesArea);
		return l;
	}

	@Override
	public String saveSalesAreaDetails(Object object,String userId, String UserName) {
		try {
			sus = salesAreaDao.saveSalesAreaDetails(object,userId,UserName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchSalesArea() {
		try {
			objects = salesAreaDao.searchSalesArea();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateSalesArea(Object object) {
		try {
			sus = salesAreaDao.updateSalesArea(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteSalesArea(int id) {
		try {
			sus = salesAreaDao.deleteSalesArea(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> selectSalesOrg() {
		try {
			objects = salesAreaDao.selectSalesOrg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchSalesArea(String label, String operator,
			String searchName) {
		try {
			objects = salesAreaDao.basicSearchSalesArea(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> searchSalesAreaWithId(int id) {
		try {
			objects = salesAreaDao.searchSalesAreaWithId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesArea() {
		// TODO Auto-generated method stub
		try {
			objects = salesAreaDao.selectSalesArea();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
