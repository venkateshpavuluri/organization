package com.mnt.erp.service;

import java.util.List;

public interface CharacteristicTypeService {
	public Long updateCheckCharacteristicType(String characteristicType,int characteristicTypeId);

	public Long checkCharacteristicType(String characteristicType);
	
	public String saveCharacteristicTypeDetails(Object object,String userId,String userName);

	public List<Object[]> searchCharacteristicType();

	public List<Object[]> searchCharacteristicTypeWithId(int id);

	public String updateCharacteristicType(Object object);

	public String deleteCharacteristicType(int id);
	
	public List<Object[]> selectCharacteristicType();
	
	public List<Object[]> basicSearchCharacteristicType(String label,String operator,String searchName);
}
