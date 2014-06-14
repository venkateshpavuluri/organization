/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SchedulingTypeDao;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class ShedulingTypeServiceImpl implements ShedulingTypeService {

	String sus;
	Long l = 0l;
	List<Object[]> objects = null;

	SchedulingTypeDao stDao;

	public SchedulingTypeDao getStDao() {
		return stDao;
	}

	public void setStDao(SchedulingTypeDao stDao) {
		this.stDao = stDao;
	}

	public int updateCheckScCount(String shType, int shId) {
		int i = 0;
		try {
			i = stDao.updateCheckScCount(shType, shId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public Long checkSchedulingType(String shType) {

		try {
			l = stDao.checkSchedulingType(shType);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public String saveShedulingType(Object object) {
		try {
			sus = stDao.saveShedulingType(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchShedulingType() {
		try {
			objects = stDao.searchShedulingType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchShedulingTypeWithId(int sId) {
		try {
			objects = stDao.searchShedulingTypeWithId(sId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateShedulingType(Object object) {
		try {
			sus = stDao.updateShedulingType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteShedulingType(int sId) {
		try {
			sus = stDao.deleteShedulingType(sId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> selectShedulingType() {
		try {
			objects = stDao.selectShedulingType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicShedtype(String label, String operator,
			String searchName) {
		try {
			objects = stDao.basicShedtype(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
