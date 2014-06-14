/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 */
public interface InspCharacteristicDao 
{
	public String saveInspCharacteristic(Object object,String userId,String userName);
	public List<Object> editInspCharacteristicWithId(int cId);
	public List<Object[]> basicSearchInspCharacteristic(String label, String operator,String searchName,String advaBasic); 
	public String updateInspCharacteristic(Object object);
	public int checkInspCharacteristic(String checkValue, String id);
	public String deleteInspCharacteristic(int id,String mainOrSub); 
	public List<Object[]> inspectionMethodSelect();
	public List<Object[]> charactersticTypeSelect();
}