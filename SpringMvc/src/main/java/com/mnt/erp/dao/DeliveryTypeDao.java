
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.dao;

import java.util.List;


/**
 * This is DeliveryTypeDao inteface.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface DeliveryTypeDao {
	
	public String saveDeliveryType(Object object,String userId, String userName);
	
	public List<Object[]> searchDeliveryType(int id);
	
	public List<Object[]> editDeliveryTypeWithId(int id);
	
	public String updateDeliveryType(Object object);
	
	public String deliveryTypeDelete(int id);
	
	public int deliveryTypeDuplicate(String deliveryType);
	
	public int delivertyTypeEditDuplicate(String deliveryType,int id);
	
	public List<Object[]> basicSearchDeliveryType(String label,String operator,String searchName);
	
}
