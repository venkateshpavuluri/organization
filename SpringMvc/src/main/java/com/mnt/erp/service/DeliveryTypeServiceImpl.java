
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.DeliveryTypeDao;
/**
 * This is DeliveryTypeService interface implementation.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class DeliveryTypeServiceImpl implements DeliveryTypeService{
	
	public DeliveryTypeDao dtdao;
	String msg;
	List<Object[]> objects=null;
	public DeliveryTypeDao getDtdao() {
		return dtdao;
	}
	public void setDtdao(DeliveryTypeDao dtdao) {
		this.dtdao = dtdao;
	} 
	
	public String saveDeliveryType(Object object,String userId, String userName){
		
		try
		{
			msg=dtdao.saveDeliveryType(object,userId,userName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;
		
	}
	public List<Object[]> searchDeliveryType(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dtdao.searchDeliveryType(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
		
	}
	public List<Object[]> editDeliveryTypeWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=dtdao.editDeliveryTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public String updateDeliveryType(Object object){
		try
		{
	         msg=dtdao.updateDeliveryType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public String deleteDeliveryType(int id){
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dtdao.deliveryTypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int deliveryTypeDuplicate(String deliveryType){
		// TODO Auto-generated method stub
		int list=0;
		try
		{
			list=dtdao.deliveryTypeDuplicate(deliveryType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public int delivertyTypeEditDuplicate(String deliveryType,int id){
		int list=0;
		try
		{
			list=dtdao.delivertyTypeEditDuplicate(deliveryType, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchDeliveryType(String label,
			String operator, String searchName) {
		try {
			objects = dtdao.basicSearchDeliveryType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
}
