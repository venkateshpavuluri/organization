package com.mnt.erp.service;

import java.util.List;



import com.mnt.erp.bean.BomCategory;
import com.mnt.erp.bean.MaterialCategory;

/**
 * @author Gkiran
 */



public interface AuditLogService {
	//public String setAuditLogSave(BomCategory mm);
	
	public List<Object[]> getAuditLog(String audit);
	public List<Object[]> getAuditLogId(int id);
	public String updateAuditLog(Object object);
	public String auditLogDelete(int id);
	public Long checkDuplicateAuditLog(String name);
	public Long checkDuplicateAuditLogUpdate(String name,int id);
	public String setAuditLogSave(com.mnt.erp.bean.AuditLog mm);
	public void setAuditLogSave(String userId, String operation,String objectChanged, String objectType,String objectId, String status, String timeStamp,String userName);
	public void setAuditLogSaveRelation(String userId, String operation,String objectChanged, String objectType,String ObjectId,String status, String timeStamp,String oldvalue,String newvalue , String userName);
	public List<Object> getAuditLogDetailId(int id);
	public String  saveAuditLogForAdd(Object object);
	public List<Object[]> basicSearchAuditLog(String label, String operator,
			String searchName);
	public String  addAuditLog(Object object) ;
}
