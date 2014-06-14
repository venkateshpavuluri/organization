package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.CharacteristicTypeDao;

public class CharacteristicTypeServiceImpl implements CharacteristicTypeService{
	String sus=null;
	
	List<Object[]> objects = null;
	
	public  CharacteristicTypeDao charTypeDao;

	public CharacteristicTypeDao getCharTypeDao() {
		return charTypeDao;
	}
	public void setCharTypeDao(CharacteristicTypeDao charTypeDao) {
		this.charTypeDao = charTypeDao;
	}
	public Long checkCharacteristicType(String characteristicType) {
		Long l = charTypeDao.checkCharacteristicType(characteristicType);
		return l;
	}
	public Long updateCheckCharacteristicType(String characteristicType,int characteristicTypeId) {
		Long l = charTypeDao.updateCheckCharacteristicType(characteristicType, characteristicTypeId);
		return l;
	}
	
	public String saveCharacteristicTypeDetails(Object object,String userId,String userName) {
		try {
			sus = charTypeDao.saveCharacteristicTypeDetails(object, userId, userName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchCharacteristicType() {
		
		try {
			objects = charTypeDao.searchCharacteristicType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> searchCharacteristicTypeWithId(int id) {
		List<Object[]> list = null;
		try {
			list = charTypeDao.searchCharacteristicTypeWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateCharacteristicType(Object object) {
		try {
			sus = charTypeDao.updateCharacteristicType(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteCharacteristicType(int id) {
		try {
			sus = charTypeDao.deleteCharacteristicType(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> selectCharacteristicType() {
		
		try {
			objects = charTypeDao.selectCharacteristicType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> basicSearchCharacteristicType(String label,String operator,String searchName){
		try {
			objects = charTypeDao.basicSearchCharacteristicType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
}
