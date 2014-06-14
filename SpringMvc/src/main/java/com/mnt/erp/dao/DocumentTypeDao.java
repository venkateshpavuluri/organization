package com.mnt.erp.dao;

import java.util.List;

public interface DocumentTypeDao {
	public String saveDocumentType(Object object,String userId,String userName);
	
	public List<Object[]> searchDocumentType();
	
	public List<Object[]> editDocumentTypeWithId(int id);
	
	public String updateDocumentType(Object object);
	
	public String deleteDocumentType(int id);
	
	public int documentTypeDuplicate(String documentType);
	
	public int documentTypeEditDuplicate(String documentType,int id);
	
	public List<Object[]> basicSearchAssertType(String label,String operator,String searchName);

}
