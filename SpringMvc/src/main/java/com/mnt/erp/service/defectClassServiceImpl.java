package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.defectClassDao;

public class defectClassServiceImpl implements defectClassService{
List<Object[]> list=null;
defectClassDao deDao;
public defectClassDao getDeDao() {
	return deDao;
}
public void setDeDao(defectClassDao deDao) {
	this.deDao = deDao;
}

public String saveDefectClass(Object object) {
	// TODO Auto-generated method stub

	String ip = null;
	try {
		ip = deDao.saveDefectClass(object);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
} 
@Override
public long checkDefectClass(String type) {
	// TODO Auto-generated method stub
	long count = 0;
	try {
		count = deDao.checkDefectClass(type);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return count;
}
@Override
public List<Object[]> searchDefectClass() {
	// TODO Auto-generated method stub
	List<Object[]> list = null;
	try {
		list = deDao.searchDefectClass();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> searchDefectClassWithId(int id) {
	// TODO Auto-generated method stub
	List<Object[]> list = null;
	try {
		list = deDao.searchDefectClassWithId(id);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchDefectClass(String label,String operator,String searchName){
	try {
		list = deDao.basicSearchDefectClass(label, operator, searchName);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}
@Override
public String deleteDefectClass(int id) {
	// TODO Auto-generated method stub
	String ip = null;
	try {
		ip = deDao.deleteDefectClass(id);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
}
@Override
public String updateDefectClass(Object object) {
	// TODO Auto-generated method stub

	String ip = null;
	try {
		ip = deDao.updateDefectClass(object);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return ip;
}
@Override
public List<Object[]> selectDefectClass() {
	// TODO Auto-generated method stub
	
	try {
		list = deDao.selectDefectClass();
		} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
}
public long updateCheckDefectClass(String type, int Id) {
	long count = 0;
	try {
		count = deDao.updateCheckDefectClass(type, Id);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return count;
}


}
