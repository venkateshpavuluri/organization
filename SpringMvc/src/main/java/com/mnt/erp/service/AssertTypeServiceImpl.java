/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.AssertTypeDao;

/**
 * @author Naresh
 * @version 1.0 18-09-2013
 */
public class AssertTypeServiceImpl implements AssertTypeService {

	List<Object[]> objects = null;
	String sus=null;
	public AssertTypeDao atDao;

	public AssertTypeDao getAtDao() {
		return atDao;
	}

	public void setAtDao(AssertTypeDao atDao) {
		this.atDao = atDao;
	}

	

	public Long checkAssetTypeCout(String assetType) {
		Long l = atDao.checkAssetTypeCout(assetType);
		return l;
	}
	public Long updateCheckAssetType(String assetType,int assetId) {
		Long l = atDao.updateCheckAssetType(assetType,assetId);
		return l;
	}
	
	public String saveAssertTypeDetails(Object object,String userId,String userName) {
		try {
			sus = atDao.saveAssertTypeDetails(object,userId,userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchAssertType() {
		
		try {
			objects = atDao.searchAssertType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchAssertTypeWithId(int id) {
		List<Object[]> list = null;
		try {
			list = atDao.searchAssertTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateAssertType(Object object) {
		try {
			sus = atDao.updateAssertType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteAssertType(int id) {
		try {
			sus = atDao.deleteAssertType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectAssetType() {
		
		try {
			objects = atDao.selectAssetType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchAssertType(String label,String operator,String searchName){
		try {
			objects = atDao.basicSearchAssertType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
