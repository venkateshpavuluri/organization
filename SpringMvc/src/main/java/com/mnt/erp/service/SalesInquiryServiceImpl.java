/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesInquiryDao;

/**
 * @author Naresh
 * @version 1.0 08-11-2013
 */
public class SalesInquiryServiceImpl implements SalesInquiryService {
	String sus;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;

	SalesInquiryDao salesInquiryDao;

	public SalesInquiryDao getSalesInquiryDao() {
		return salesInquiryDao;
	}

	public void setSalesInquiryDao(SalesInquiryDao salesInquiryDao) {
		this.salesInquiryDao = salesInquiryDao;
	}

	@Override
	public int updateCheckSalesInquiry(String salesNo, int siId) {
		int i = 0;
		try {
			i = salesInquiryDao.updateCheckSalesInquiry(salesNo, siId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkSalesInquiry(String salesNo) {
		try {
			l = salesInquiryDao.checkSalesInquiry(salesNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveSalesInquiry(Object object) {
		try {

			sus = salesInquiryDao.saveSalesInquiry(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchSalesInquiry() {
		try {
			objects = salesInquiryDao.searchSalesInquiry();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesInquiryWithId(int sId) {
		try {
			obj = salesInquiryDao.searchSalesInquiryWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesInquiry(Object object) {
		try {
			sus = salesInquiryDao.updateSalesInquiry(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteSalesInquiry(int cId) {
		try {
			sus = salesInquiryDao.deleteSalesInquiry(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> basicSearchSalesInquiry(String label,
			String operator, String searchName) {
		try {
			objects = salesInquiryDao.basicSearchSalesInquiry(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectCustomerIds() {
		try {
			objects = salesInquiryDao.selectCustomerIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesGroupIds() {
		try {
			objects = salesInquiryDao.selectSalesGroupIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			objects = salesInquiryDao.populateUOMIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds() {
		try {
			objects = salesInquiryDao.populateMaterialIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteSalesLine(int id) {
		try {
			sus = salesInquiryDao.deleteSalesLine(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> advSearchSalesInquiry(String labels, String opts,
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
						finalStringForSearch += " and cb." + column[i] + " "
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
			list = salesInquiryDao.advSearchSalesInquiry(finalStringForSearch);
		} else {
			list = salesInquiryDao.searchSalesInquiry();
		}
		return list;
	}

}
