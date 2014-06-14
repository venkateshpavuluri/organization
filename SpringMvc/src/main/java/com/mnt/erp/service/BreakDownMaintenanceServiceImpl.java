/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.dao.BreakDownMaintenanceDao;

/**
 * @author Naresh
 * @version 1.0  16-04-2014
 */
public class BreakDownMaintenanceServiceImpl implements
		BreakDownMaintenanceService {

	List<Object[]> objects = null;
	List<Object> obj = null;
	boolean flag = true;
	Long l = 0l;
	@Autowired
	BreakDownMaintenanceDao breakDownDao;

	@Override
	public Long updateCheckBreakDown(String recNo, int recId) {
		try {
			l = breakDownDao.updateCheckBreakDown(recNo, recId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Long checkBreakDownCout(String recNo) {
		try {
			l = breakDownDao.checkBreakDownCout(recNo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean saveBreakDownDetails(Object object) {
		try {
			flag = breakDownDao.saveBreakDownDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> searchBreakDown() {
		try {
			objects = breakDownDao.searchBreakDown();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object> searchBreakDownWithId(int recId) {
		try {
			obj = breakDownDao.searchBreakDownWithId(recId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean updateBreakDown(Object object) {
		try {
			flag = breakDownDao.updateBreakDown(object);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public boolean deleteBreakDown(int recId) {
		try {
			flag = breakDownDao.deleteBreakDown(recId);

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<Object[]> basicSearchBreakDown(String label, String operator,
			String searchName) {
		try {
			objects = breakDownDao.basicSearchBreakDown(label, operator,
					searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
