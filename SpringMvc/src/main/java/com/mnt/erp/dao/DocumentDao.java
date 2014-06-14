package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Document;

public interface DocumentDao {
	public Long updateCheckDocument(String equipment,int id);

	public Long checkDocument(String equipment);
	
	public String saveDocumentDetails(Object object);

	public List<Object[]> searchDocument();

	public List<Document> searchDocumentWithId(int id);

	public String updateDocument(Object object);

	public String deleteDocument(int id);
	
	public List<Object[]> selectEquipment();
	
	public List<Object[]> selectMaintenanceCategory();
	
	public List<Object[]> selectMaintenanceType();
	
	public String deleteDocumentDetail(int kk);
	
	public List<Object[]> basicSearchDocument(String label,String operator,String searchName);
}
