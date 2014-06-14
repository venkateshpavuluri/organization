package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Document;

public interface DocumentService {
	public Long updateCheckDocument(String fiscalYear,int fiscalYearId);

	public Long checkDocument(String fiscalYear);
	
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
