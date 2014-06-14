package com.mnt.erp.service;

import java.util.List;

public interface DocumentTypeService {

public String saveDocumentType(Object object,String userId,String userName);
	
	public List<Object[]> searchDocumentType();
	
	public List<Object[]> editDocumentTypeWithId(int id);
	
	public String updateDocumentType(Object object);
	
	public String deleteDocumentType(int id);
	
	public int documentTypeDuplicate(String deliveryType);
	
	public int documentTypeEditDuplicate(String deliveryType,int id);
	
	public List<Object[]> basicSearchAssertType(String label,String operator,String searchName);

}
