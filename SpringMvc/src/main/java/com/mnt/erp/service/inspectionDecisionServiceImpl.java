/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.inspectionDecisionDao;

/**
 * @author devi
 *
 */
public class inspectionDecisionServiceImpl implements inspectionDecisionService{
	
inspectionDecisionDao isDao;
List<Object[]> list = null;
List<Object[]> objects;
public inspectionDecisionDao getIsDao() {
	return isDao;
}

public void setIsDao(inspectionDecisionDao isDao) {
	this.isDao = isDao;
}
public String saveInspectionDecision(Object object,String userId,String userName) {
	// TODO Auto-generated method stub

	String ip = null;
	try {
		ip = isDao.saveInspectionDecision(object, userId, userName);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
} 
@Override
public long checkInspectionDecision(String type) {
	// TODO Auto-generated method stub
	long count = 0;
	try {
		count = isDao.checkInspectionDecision(type);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return count;
}
@Override
public List<Object[]> searchInspectionDecision() {
	// TODO Auto-generated method stub
	List<Object[]> list = null;
	try {
		list = isDao.searchInspectionDecision();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> searchInspectionDecisionWithId(int id) {
	// TODO Auto-generated method stub
	List<Object[]> list = null;
	try {
		list = isDao.searchInspectionDecisionWithId(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchInspectionDecision(String label,String operator,String searchName){
	try {
		list = isDao.basicSearchInspectionDecision(label, operator, searchName);
		} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}
@Override
public String deleteInspectionDecision(int id) {
	// TODO Auto-generated method stub
	String ip = null;
	try {
		ip = isDao.deleteInspectionDecision(id);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
}
@Override
public String updateInspectionDecision(Object object) {
	// TODO Auto-generated method stub

	String ip = null;
	try {
		ip = isDao.updateInspectionDecision(object);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
}
@Override
public List<Object[]> selectInspectionDecision() {
	// TODO Auto-generated method stub
	
	try {
		list = isDao.selectInspectionDecision();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public long updateCheckInspectionDecision(String type, int Id) {
	long count = 0;
	try {
		count = isDao.updateCheckInspectionDecision(type, Id);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return count;
}
@Override
public List<Object[]> selectInspectionDecisionservice() {
try{
		
		objects=isDao.getInspectionLotOriginIds();
	}catch(Exception e){
		e.printStackTrace();
	}
	return objects;
}

}
