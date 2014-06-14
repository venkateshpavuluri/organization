/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesQuotationDao;

/**
 * @author Naresh
 * @version 1.0 14-11-2013
 */
public class SalesQuotationServiceImpl implements SalesQuotationService {
	String sus;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;

	private SalesQuotationDao salesQuotDao;

	public SalesQuotationDao getSalesQuotDao() {
		return salesQuotDao;
	}

	public void setSalesQuotDao(SalesQuotationDao salesQuotDao) {
		this.salesQuotDao = salesQuotDao;
	}

	@Override
	public List<Object[]> selectCustomerIds() {
		try {
			objects = salesQuotDao.selectCustomerIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesInquiryIds() {
		try {
			objects = salesQuotDao.selectSalesInquiryIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckSalesQuotation(String salesNo, int siId) {
		int i = 0;
		try {
			i = salesQuotDao.updateCheckSalesQuotation(salesNo, siId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkSalesQuotation(String salesNo) {
		try {
			l = salesQuotDao.checkSalesQuotation(salesNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveSalesQuotation(Object object) {
		try {

			sus = salesQuotDao.saveSalesQuotation(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchSalesQuotation() {
		try {
			objects = salesQuotDao.searchSalesQuotation();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesQuotationWithId(int sId) {
		try {
			obj = salesQuotDao.searchSalesQuotationWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesQuotation(Object object) {
		try {
			sus = salesQuotDao.updateSalesQuotation(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteSalesQuotation(int cId) {
		try {
			sus = salesQuotDao.deleteSalesQuotation(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> basicSearchSalesQuotation(String label,
			String operator, String searchName) {
		try {
			objects = salesQuotDao.basicSearchSalesQuotation(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateCurrencyIds() {
		try {
			objects = salesQuotDao.populateCurrencyIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds() {
		try {
			objects = salesQuotDao.populateMaterialIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> populateUOMIds() {
		try {
			objects = salesQuotDao.populateUOMIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> editSalesInquiryWithId(int sId) {
		try {
			obj = salesQuotDao.editSalesInquiryWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String deleteSalesQuotLine(int sId) {
		try {
			sus = salesQuotDao.deleteSalesQuotLine(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> advSearchSalesQuotation(String labels, String opts,
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
			list = salesQuotDao.advSearchSalesQuotation(finalStringForSearch);
		} else {
			list = salesQuotDao.searchSalesQuotation();
		}
		return list;
	}

}
