/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.CustomerDao;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class CustomerServiceImpl implements CustomerService {
	String sus;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
	CustomerDao custDao;

	public CustomerDao getCustDao() {
		return custDao;
	}

	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	public int updateCheckCustomer(String custName, int custId) {
		int i = 0;
		try {
			i = custDao.updateCheckCustomer(custName, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Long checkCustomer(String custName) {
		try {
			l = custDao.checkCustomer(custName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public String saveCustomerDetails(Object object) {
		try {

			sus = custDao.saveCustomerDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchCustomer(String active) {
		try {
			objects = custDao.searchCustomer(active);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchCustomerWithId(int cId, String active) {
		try {
			objects = custDao.searchCustomerWithId(cId, active);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editCustomerWithId(int cId, String active) {
		try {
			obj = custDao.editCustomerWithId(cId, active);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateCustomer(Object object) {
		try {
			sus = custDao.updateCustomer(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteCustomer(int cId) {
		try {
			sus = custDao.deleteCustomer(cId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	@Override
	public List<Object[]> selectCustomer(String active) {
		try {
			objects = custDao.selectCustomer(active);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectCustomerGroup() {
		try {
			objects = custDao.selectCustomerGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesArea() {
		try {
			objects = custDao.selectSalesArea();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> getCustomerIds() {
		List<Object[]> list = null;
		try {
			list = custDao.getCustomerIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object[]> basicSearchCustomer(String label, String operator,
			String searchName) {
		try {
			objects = custDao.basicSearchCustomer(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> Customeradvance(String columns, String opeator,
			String advanceSearchText) {
		String column[] = columns.split(",");
		String op[] = opeator.split(",");
		String advanceSearch[] = advanceSearchText.split(",");
		String finalStringForSearch = "";

		for (int i = 0; i < advanceSearch.length; i++) {
			if (!op[i].equals("0") && advanceSearch[i] != "") {
				if (op[i].equals("_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = advanceSearch[i] + "%";

				} else if (op[i].equals("%_")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i];

				} else if (op[i].equals("%_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i] + "%";

				} else if (op[i].equals("=")) {
					column[i] = column[i];
					op[i] = " = ";
					advanceSearch[i] = advanceSearch[i];

				} else if (op[i].equals("!=")) {
					column[i] = column[i];
					op[i] = " != ";
					advanceSearch[i] = advanceSearch[i];

				}
				if (!op[i].equals("0") && advanceSearch[i] != "") {
					finalStringForSearch = finalStringForSearch + "  "
							+ column[i] + " " + op[i] + " '" + advanceSearch[i]
							+ "' " + "AND";
				}
			}

		}

		List<Object[]> list = null;
		if (finalStringForSearch.length() > 3) {
			list = custDao.setCustomerAdvanceSearch(finalStringForSearch
					.substring(0, finalStringForSearch.length() - 3));
		} else {
			list = custDao.setCustomerSearch("ALL");
		}
		return list;
	}

	@Override
	public List<Object[]> getcustomer(String cust) {
		List<Object[]> list = custDao.setCustomerSearch(cust);
		return list;
	}

	@Override
	public List<Object[]> selectAccountGroupIds() {
		try {
			objects = custDao.selectAccountGroupIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			objects = custDao.selectPaymentTermIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentMethodIds() {
		try {
			objects = custDao.selectPaymentMethodIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteCustomerBankDet(int custId) {

		try {
			sus = custDao.deleteCustomerBankDet(custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteCustomerAccount(int acId) {
		try {
			sus = custDao.deleteCustomerAccount(acId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

}
