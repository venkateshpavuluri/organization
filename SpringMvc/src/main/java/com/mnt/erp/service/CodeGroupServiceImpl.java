package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AssertTypeDao;
import com.mnt.erp.dao.CodeGroupDao;

public class CodeGroupServiceImpl implements CodeGroupService {

	List<Object[]> objects = null;
	String sus=null;
	public CodeGroupDao codeGroupDao;

	
	public CodeGroupDao getCodeGroupDao() {
		return codeGroupDao;
	}
	public void setCodeGroupDao(CodeGroupDao codeGroupDao) {
		this.codeGroupDao = codeGroupDao;
	}
	
	public Long checkCodeGroupCout(String codeGroup) {
		Long l = codeGroupDao.checkCodeGroupCout(codeGroup);
		return l;
	}
	public Long updateCheckCodeGroup(String codeGroup,int codeGroupId) {
		Long l = codeGroupDao.updateCheckCodeGroup(codeGroup, codeGroupId);
		return l;
	}
	
	public String saveCodeGroupDetails(Object object,String userId,String userName) {
		try {
			sus = codeGroupDao.saveCodeGroupDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchCodeGroup() {
		
		try {
			objects = codeGroupDao.searchCodeGroup();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchCodeGroupWithId(int id) {
		List<Object[]> list = null;
		try {
			list = codeGroupDao.searchCodeGroupWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateCodeGroup(Object object) {
		try {
			sus = codeGroupDao.updateCodeGroup(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteCodeGroup(int id) {
		try {
			sus = codeGroupDao.deleteCodeGroup(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectCodeGroup() {
		
		try {
			objects = codeGroupDao.selectCodeGroup();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchCodeGroup(String label,String operator,String searchName){
		try {
			objects = codeGroupDao.basicSearchCodeGroup(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
