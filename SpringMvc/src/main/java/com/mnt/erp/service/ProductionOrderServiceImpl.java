/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ProductionOrderDao;

/**
 * @author Naresh
 * @version 1.0 24-01-2014
 */
public class ProductionOrderServiceImpl implements ProductionOrderService {

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	Long l = 0l;
	private ProductionOrderDao prodOrderDao;

	public ProductionOrderDao getProdOrderDao() {
		return prodOrderDao;
	}

	public void setProdOrderDao(ProductionOrderDao prodOrderDao) {
		this.prodOrderDao = prodOrderDao;
	}

	@Override
	public Long updateCheckProdOrder(String poNo, int poId) {
		try {
			l = prodOrderDao.updateCheckProdOrder(poNo, poId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Long checkProdOrderCout(String poNo) {
		try {
			l = prodOrderDao.checkProdOrderCout(poNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveProdOrderDetails(Object object) {
		try {
			flag = prodOrderDao.saveProdOrderDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchProdOrder() {
		try {
			objects = prodOrderDao.searchProdOrder();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchProdOrderWithId(int poId) {
		try {
			obj = prodOrderDao.searchProdOrderWithId(poId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateProdOrder(Object object) {
		try {
			flag = prodOrderDao.updateProdOrder(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteProdOrder(int poId) {
		try {
			flag = prodOrderDao.deleteProdOrder(poId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchProdOrder(String label, String operator,
			String searchName) {
		try {
			objects = prodOrderDao.basicSearchProdOrder(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
