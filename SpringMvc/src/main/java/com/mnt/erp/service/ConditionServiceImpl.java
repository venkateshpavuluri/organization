/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ConditionDao;
import com.mnt.erp.dao.SalesAreaDao;

/**
 * @author madhav
 *
 */
public class ConditionServiceImpl implements ConditionService {
	
	//Instance Variables
	List<Object[]> objects = null;
	String sus = null;

	//Dao decleration with getters and setters methods
	ConditionDao conditionDao;
	
	/**
	 * @return the conditionDao
	 */
	public ConditionDao getConditionDao() {
		return conditionDao;
	}

	/**
	 * @param conditionDao the conditionDao to set
	 */
	public void setConditionDao(ConditionDao conditionDao) {
		this.conditionDao = conditionDao;
	}

	//Methods for CRUD Operations
	@Override
	public List<Object[]> selectCondition() {
		try {
			objects = conditionDao.selectCondition();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public Long updateCheckCondition(String condition, int conditionId) {
		Long l = conditionDao.updateCheckCondition(condition, conditionId);
		return l;
	}

	@Override
	public Long addCheckConditionType(String condition) {
		
		Long l = conditionDao.addCheckConditionType(condition);
		return l;
	}

	@Override
	public String saveCondition(Object object,String userId,String userName) {
		
		try {
			sus = conditionDao.saveCondition(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> searchCondition() {
		try {
			objects =conditionDao.searchCondition();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchConditoinWithId(int id) {
		
		try {
			objects = conditionDao.searchConditoinWithId(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public String updateCondition(Object object) {
		
		try {
			sus = conditionDao.updateCondition(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public String deleteCodition(int id) {
		
		try {
			sus = conditionDao.deleteCodition(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	@Override
	public List<Object[]> selectConditionType() {
		
		try {
			objects = conditionDao.selectConditionType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> basicSearchCondition(String label, String operator,
			String searchName) {
		try {
			objects = conditionDao.basicSearchCondition(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
