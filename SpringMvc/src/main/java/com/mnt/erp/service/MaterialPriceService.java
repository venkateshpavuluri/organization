package com.mnt.erp.service;

import java.util.List;

public interface MaterialPriceService {

	
	public Long updateCheckMaterialPrice(int material,String batchNo,String validFrom,String validTo,int materialPrice_id);

	public Long checkMaterialPrice(int material,String batchNo,String validFrom,String validTo);
	
	public String saveMaterialPriceDetails(Object object,String userId,String userName);

	public List<Object[]> searchMaterialPrice();

	public List<Object[]> searchMaterialPriceWithId(int id);

	public String updateMaterialPrice(Object object);

	public String deleteMaterialPrice(int id);
	
	public List<Object[]> populateCurrencyIds();
	
	public List<Object[]> selectMaterialPrice();
	
	public List<Object[]> basicSearchMaterialPrice(String label,String operator,String searchName);
}
