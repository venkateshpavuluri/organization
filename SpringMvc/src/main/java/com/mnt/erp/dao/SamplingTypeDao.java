package com.mnt.erp.dao;

import java.util.List;

public interface SamplingTypeDao {
	
public String saveSamplingType(Object object,String userId,String userName);
	
	public List<Object[]> searchSamplingType(int id);
	
	public List<Object[]> editSamplingTypeWithId(int id);
	
	public String updateSamplingType(Object object);
	
	public String samplingTypeDelete(int id);
	
	public int samplingTypeDuplicate(String agreementType);
	
	public int samplingTypeEditDuplicate(String agreementType,int id);
	
	public List<Object[]> basicSearchSamplingType(String label,String operator,String searchName);
}
