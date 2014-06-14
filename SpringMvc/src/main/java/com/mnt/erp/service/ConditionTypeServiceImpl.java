/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AgreementTypeDao;
import com.mnt.erp.dao.AssertTypeDao;
import com.mnt.erp.dao.ConditionTypeDao;

/**
 * @author madhav
 *
 */
public class ConditionTypeServiceImpl implements ConditionTypeService {
	
	//Member variables
	public ConditionTypeDao ctDao;
	public String msg;
	List<Object[]> objects;
	
	
	
	
	//Getters and Setter Methods for variables
	public ConditionTypeDao getCtDao() {
		return ctDao;
	}


	public void setCtDao(ConditionTypeDao ctDao) {
		this.ctDao = ctDao;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	//Methods for Service Implimentation

	

	@Override
	public Long updateCheckConditionType(String conditionType,
			int conditionTypeId) {
		Long l = ctDao.updateCheckConditionType(conditionType, conditionTypeId);
		return l;
	}


	@Override
	public Long addCheckConditionType(String conditionType) {
		Long l = ctDao.addCheckConditionType(conditionType);
		return l;
	}

	//Method for Adding ConditionType 
	@Override
	public String saveConditionType(Object object,String userId,String userName) {
		try {
			msg = ctDao.saveConditionType(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	//Method for Searching ConditionType
	@Override
	public List<Object[]> searchConditionType() {
		try {
			objects = ctDao.searchConditionType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	//Searching Condition Type With Id
	@Override
	public List<Object[]> searchConditionTypeWithId(int id) {
		
		List<Object[]> list = null;
		try {
			list = ctDao.searchConditionTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Basic Search for Condition Type
	@Override
	public List<Object[]> basicSearchConditionType(String label,
			String operator, String searchName) {
		try {
			objects = ctDao.basicSearchConditionType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	//Method for Updating ConditionType Form
	@Override
	public String updateConditionType(Object object) {
		try {
			msg = ctDao.updateConditionType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String deleteConditionType(int id) {
		try {
			msg = ctDao.deleteConditionType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	

}
