package com.mnt.erp.dao;

import java.util.List;



import com.mnt.erp.bean.AuditLog;


/**
 * @author Gkiran
 */


public interface AuditLogDao {
	
public String saveAuditLog(AuditLog mm);
public List<Object[]> setAuditLogSearch(String name);
public List<Object[]> setAuditLogSearch(int id);
public String updateAuditLog(Object object);
public String auditLogDelete(int id);
public Long checkDuplicateAuditLog(String name);
public List<Object> setAuditLogDetailSearch(int id);
public String  saveAuditLogForAdd(Object object);
public List<Object[]> basicSearchAuditLog(String label, String operator,String searchName);
public String addAuditLog(Object object);


}
