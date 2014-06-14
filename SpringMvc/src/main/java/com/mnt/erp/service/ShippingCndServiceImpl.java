/*
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ShippingConditionDao;

/*
 * @author Naresh
 * @version 1.0 20-09-2013
 */
public class ShippingCndServiceImpl implements ShippingConditionService {
	String sus;
	List<Object[]> objects = null;
	ShippingConditionDao scDao;

	public ShippingConditionDao getScDao() {
		return scDao;
	}

	public void setScDao(ShippingConditionDao scDao) {
		this.scDao = scDao;
	}

	public int updateCheckScCount(String scName, int scId) {
		int i = 0;
		try {
			i = scDao.updateCheckScCount(scName, scId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;

	}

	public Long checkShippingCndCount(String scName) {
		Long l = 0l;
		try {
			l = scDao.checkShippingCndCount(scName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public String saveShippingCondition(Object object,String userId,String userName) {
		try {
			sus = scDao.saveShippingCondition(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchShippingCondition() {
		try {
			objects = scDao.searchShippingCondition();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchShippingConditionWithId(int id) {
		try {
			objects = scDao.searchShippingConditionWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateShippingCondition(Object object) {
		try {
			sus = scDao.updateShippingCondition(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteShippingCondition(int id) {
		try {
			sus = scDao.deleteShippingCondition(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> selectShippingCondition() {
		try {
			objects = scDao.selectShippingCondition();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicShipCnd(String label,String operator,String searchName){
		try {
			objects = scDao.basicShipCnd(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
