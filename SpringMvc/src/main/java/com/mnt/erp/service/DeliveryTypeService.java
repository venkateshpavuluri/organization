
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

/**
 * This is DeliveryTypeService interface.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public interface DeliveryTypeService {

	public String saveDeliveryType(Object object,String userId, String userName);
	
	public List<Object[]> searchDeliveryType(int id);
	
	public List<Object[]> editDeliveryTypeWithId(int id);
	
	public String updateDeliveryType(Object object);
	
	public String deleteDeliveryType(int id);
	
	public int deliveryTypeDuplicate(String deliveryType);
	
	public int delivertyTypeEditDuplicate(String deliveryType,int id);
	
	public List<Object[]> basicSearchDeliveryType(String label,String operator,String searchName);
}
