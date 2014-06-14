package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Document;
import com.mnt.erp.dao.DocumentDao;

public class DocumentServiceImpl implements DocumentService {
	List<Object[]> objects = null;
	String sus=null;
	
	private DocumentDao documentDao;
	
	
	

	public DocumentDao getDocumentDao() {
		return documentDao;
	}
	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}
	public Long checkDocument(String fiscalYear){
		Long l = documentDao.checkDocument(fiscalYear);
		return l;
	}
	public Long updateCheckDocument(String fiscalYear,int fiscalYearId) {
		Long l = documentDao.updateCheckDocument(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveDocumentDetails(Object object) {
		try {
			sus = documentDao.saveDocumentDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchDocument() {
		
		try {
			objects = documentDao.searchDocument();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Document> searchDocumentWithId(int id) {
		List<Document> list = null;
		try {
			list = documentDao.searchDocumentWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateDocument(Object object) {
		try {
			sus = documentDao.updateDocument(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteDocument(int id) {
		try {
			sus = documentDao.deleteDocument(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectEquipment() {
		
		try {
			objects = documentDao.selectEquipment();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectMaintenanceCategory() {
		
		try {
			objects = documentDao.selectMaintenanceCategory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
public List<Object[]> selectMaintenanceType() {
		
		try {
			objects = documentDao.selectMaintenanceType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object[]> basicSearchDocument(String label,String operator,String searchName){
		try {
			objects = documentDao.basicSearchDocument(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteDocumentDetail(int kk){
		String msg = null;
		try {
			msg = documentDao.deleteDocumentDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	
}
