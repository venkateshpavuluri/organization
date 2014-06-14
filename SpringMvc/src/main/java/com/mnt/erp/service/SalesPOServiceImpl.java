/**
 * @Copyright MNTSOFT   
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesPODao;

/**
 * @author Naresh
 * @version 1.0 04-12-2013
 */
public class SalesPOServiceImpl implements SalesPOService {

	String sus;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;

	private SalesPODao salesPODao;

	public SalesPODao getSalesPODao() {
		return salesPODao;
	}

	public void setSalesPODao(SalesPODao salesPODao) {
		this.salesPODao = salesPODao;
	}

	@Override
	public List<Object[]> selectCustomerIds() {
		try {
			objects = salesPODao.selectCustomerIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesQuotationIds() {
		try {
			objects = salesPODao.selectSalesQuotationIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckSalesPO(String salesNo, int siId) {
		int i = 0;
		try {
			i = salesPODao.updateCheckSalesPO(salesNo, siId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkSalesPO(String salesNo) {
		try {
			l = salesPODao.checkSalesPO(salesNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveSalesPO(Object object) {
		try {

			sus = salesPODao.saveSalesPO(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchSalesPO() {
		try {
			objects = salesPODao.searchSalesPO();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesPOWithId(int sId) {
		try {
			obj = salesPODao.searchSalesPOWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesPO(Object object) {
		try {
			sus = salesPODao.updateSalesPO(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteSalesPO(int cId) {
		try {
			sus = salesPODao.deleteSalesPO(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> basicSearchSalesPO(String label, String operator,
			String searchName) {
		try {
			objects = salesPODao
					.basicSearchSalesPO(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateCurrencyIds() {
		try {
			objects = salesPODao.populateCurrencyIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds() {
		try {
			objects = salesPODao.populateMaterialIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			objects = salesPODao.populateUOMIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> editSalesQuotationWithId(int sId) {
		try {
			obj = salesPODao.editSalesQuotationWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			objects = salesPODao.selectPaymentTermIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectStatusIds() {
		try {
			objects = salesPODao.selectStatusIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteSalesPOLine(int sId) {
		try {
			sus = salesPODao.deleteSalesPOLine(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> advSearchSalesPO(String labels, String opts,
			String advText) {
		List<Object[]> list = null;
		String column[] = labels.split(",");
		String op[] = opts.split(",");
		String advanceSearch[] = advText.split(",");
		String finalStringForSearch = "";
		int count = 0;
		for (int i = 0; i < advanceSearch.length; i++) {
			if (!op[i].equals("0") && advanceSearch[i] != "") {
				if (op[i].equals("_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = advanceSearch[i] + "%";

				} else if (op[i].equals("%_")) {
					column[i] = column[i];
					op[i] = "like ";
					advanceSearch[i] = "%" + advanceSearch[i];

				} else if (op[i].equals("%_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i] + "%";

				} else if (op[i].equals("=")) {
					column[i] = column[i];
					op[i] = "=";
					advanceSearch[i] = advanceSearch[i];

				} else if (op[i].equals("!=")) {
					column[i] = column[i];
					op[i] = "!=";
					advanceSearch[i] = advanceSearch[i];

				}
				if (!"".equals(advanceSearch[i])) {
					if (count > 0) {
						finalStringForSearch += " and sq." + column[i] + " "
								+ op[i] + "'" + advanceSearch[i] + "'";
					} else {
						finalStringForSearch += column[i] + " " + op[i] + "'"
								+ advanceSearch[i] + "'";
						count++;
					}

				}

			}

		}

		if (finalStringForSearch.length() > 0) {
			list = salesPODao.advSearchSalesPO(finalStringForSearch);
		} else {
			list = salesPODao.searchSalesPO();
		}
		return list;
	}

}
