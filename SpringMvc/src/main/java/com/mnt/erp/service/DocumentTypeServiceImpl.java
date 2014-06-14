package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.DeliveryTypeDao;
import com.mnt.erp.dao.DocumentTypeDao;

public class DocumentTypeServiceImpl implements DocumentTypeService{
	
	
	public DocumentTypeDao doctdao;
	String msg;
	
	
	
	public DocumentTypeDao getDoctdao() {
		return doctdao;
	}
	public void setDoctdao(DocumentTypeDao doctdao) {
		this.doctdao = doctdao;
	}
	public String saveDocumentType(Object object,String userId,String userName){
		
		try
		{
			msg=doctdao.saveDocumentType(object, userId, userName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return msg;
		
	}
	public List<Object[]> searchDocumentType(){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=doctdao.searchDocumentType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
		
	}
	public List<Object[]> editDocumentTypeWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=doctdao.editDocumentTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public String updateDocumentType(Object object){
		try
		{
	         msg=doctdao.updateDocumentType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public String deleteDocumentType(int id){
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=doctdao.deleteDocumentType(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int documentTypeDuplicate(String deliveryType){
		// TODO Auto-generated method stub
		int list=0;
		try
		{
			list=doctdao.documentTypeDuplicate(deliveryType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public int documentTypeEditDuplicate(String deliveryType,int id){
		int list=0;
		try
		{
			list=doctdao.documentTypeEditDuplicate(deliveryType, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> basicSearchAssertType(String label,String operator,String searchName){
		List<Object[]> objects=null;
		try {
			objects = doctdao.basicSearchAssertType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

}
