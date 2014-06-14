/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.UserOrganizationBean;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.dao.SalesOrderDao;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
public class SalesOrderServiceImpl implements SalesOrderService {
	String sus = "success";
	String del;
	Long l = 0l;
	List<Object[]> objects = null;
	List<Object> obj = null;
@Autowired
	SalesOrderDao salesOrderDao;

	public SalesOrderDao getSalesOrderDao() {
		return salesOrderDao;
	}

	public void setSalesOrderDao(SalesOrderDao salesOrderDao) {
		this.salesOrderDao = salesOrderDao;
	}

	@Override
	public List<Object[]> selectCustomerIds() {
		try {
			objects = salesOrderDao.selectCustomerIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesGroupIds() {
		try {
			objects = salesOrderDao.selectSalesGroupIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectOrderTypeIds() {
		try {
			objects = salesOrderDao.selectOrderTypeIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			objects = salesOrderDao.selectPaymentTermIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public int updateCheckSalesOrder(String salesNo, int siId) {
		int i = 0;
		try {
			i = salesOrderDao.updateCheckSalesOrder(salesNo, siId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public Long checkSalesOrder(String salesNo) {
		try {
			l = salesOrderDao.checkSalesOrder(salesNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String saveSalesOrder(Object object) {
		try {

			sus = salesOrderDao.saveSalesOrder(object);

		} catch (Exception e) {
			e.printStackTrace();
			sus = "F";
		}
		return sus;
	}

	@Override
	public List<Object[]> searchSalesOrder() {
		try {
			objects = salesOrderDao.searchSalesOrder();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchSalesOrderWithId(int sId) {
		try {
			obj = salesOrderDao.searchSalesOrderWithId(sId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public String updateSalesOrder(Object object) {
		try {
			sus = salesOrderDao.updateSalesOrder(object);
		} catch (Exception e) {
			e.printStackTrace();
			sus = "F";
		}
		return sus;
	}

	@Override
	public String deleteSalesOrder(int dId) {
		try {
			del = salesOrderDao.deleteSalesOrder(dId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public List<Object[]> basicSearchSalesOrder(String label, String operator,
			String searchName) {
		try {
			objects = salesOrderDao.basicSearchSalesOrder(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateCurrencyIds() {
		try {
			objects = salesOrderDao.populateCurrencyIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateMaterialIds() {
		try {
			objects = salesOrderDao.populateMaterialIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> populateUOMIds() {
		try {
			objects = salesOrderDao.populateUOMIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String deleteSalesOrderLine(int slId) {
		try {
			del = salesOrderDao.deleteSalesOrderLine(slId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public String deleteSalesOrderSch(int scId) {
		try {
			del = salesOrderDao.deleteSalesOrderSch(scId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return del;
	}

	@Override
	public String getOrganizationId(String userId) {
		String org = null;
		List<UserOrganizationBean> user = null;
		try {
			user = salesOrderDao.getOrganizationId(userId);
			for (UserOrganizationBean u : user) {
				org = u.getOrgid();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return org;

	}

	@Override
	public List<Object[]> advSearchSalesOrder(String labels, String opts,
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
						finalStringForSearch += " and so." + column[i] + " "
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
			list = salesOrderDao.advSearchSalesOrder(finalStringForSearch);
		} else {
			list = salesOrderDao.searchSalesOrder();
		}
		return list;
	}

	@Override
	public String saveWorkFlowListDaoDetails(WorkFlowList workFlowList) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=salesOrderDao.saveWorkFlowListDaoDetails(workFlowList);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Object[]> getStepUsers() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=salesOrderDao.getStepUsers();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
