package com.mnt.erp.service;

import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;



import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.AuditLogDetail;
import com.mnt.erp.bean.VendorBankDet;
import com.mnt.erp.dao.AuditLogDaoImpl;
import com.mnt.erp.dao.LoginDaoImpl;
import com.mnt.erp.dao.AuditLogDao;


/**
 * @author Gkiran
 */


public class AuditLogServiceImpl implements AuditLogService,Serializable{
private com.mnt.erp.dao.AuditLogDaoImpl dao;
	public AuditLogDaoImpl getDao() {
	return dao;
}
public void setDao(AuditLogDaoImpl dao) {
	this.dao = dao;
}


@Override
public List<Object[]> getAuditLog(String bomCategory) {
	List<Object[]> list=dao.setAuditLogSearch(bomCategory);
	return list;
}

@Override
public List<Object[]> basicSearchAuditLog(String label, String operator,
		String searchName){
	List<Object[]> objs=null;
	try
	{
		 objs=dao.basicSearchAuditLog(label, operator, searchName);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return objs;
	
}

@Override
public String  saveAuditLogForAdd(Object object)
{
	String list=dao.saveAuditLogForAdd(object);
	return list;
}

@Override
public List<Object[]> getAuditLogId(int id) {
	List<Object[]> list=dao.setAuditLogSearch(id);
	return list;
}

@Override
public List<Object> getAuditLogDetailId(int id) {
	List<Object> list=dao.setAuditLogDetailSearch(id);
	return list;
}



@Override
public String updateAuditLog(Object object) {
	String msg=null;
	try
	{
 msg=dao.updateAuditLog(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public String auditLogDelete(int id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=dao.auditLogDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}



@Override
public String setAuditLogSave(com.mnt.erp.bean.AuditLog mm) {
	String success =dao.saveAuditLog(mm);
	return success;
	
}

public Long checkDuplicateAuditLog(String name) {
	Long success =dao.checkDuplicateAuditLog(name);
	return success;
	
}

public Long checkDuplicateAuditLogUpdate(String name ,int id) {
	Long success =dao.checkDuplicateAuditLogUpdate(name,id);
	return success;
	
}

public void setAuditLogSave(String userId, String operation,String objectChanged, String objectType,String ObjectId,String status, String timeStamp,String userName)
{
	com.mnt.erp.bean.AuditLog auditLog=new com.mnt.erp.bean.AuditLog();
	auditLog.setUserId(userId);
	auditLog.setOperation(operation);
	auditLog.setObjectChanged(objectChanged); 
	auditLog.setObjectType(objectType);
	auditLog.setObjectId(ObjectId);
	auditLog.setStatus(status);
	auditLog.setTimeStamp(timeStamp);
	auditLog.setUserName(userName);
	dao.saveAuditLog(auditLog);
}



public void setAuditLogSaveRelation(String userId, String operation,String objectChanged, String objectType,String ObjectId,String status, String timeStamp,String oldvalue,String newvalue,String userName)
{
	com.mnt.erp.bean.AuditLog auditLog=new com.mnt.erp.bean.AuditLog();
	List<AuditLogDetail> AuditLogDetail = new ArrayList<AuditLogDetail>();
	auditLog.setUserId(userId);
	auditLog.setOperation(operation);
	auditLog.setObjectChanged(objectChanged); 
	auditLog.setObjectType(objectType);
	auditLog.setObjectId(ObjectId);
	auditLog.setStatus(status);
	auditLog.setTimeStamp(timeStamp);
	auditLog.setUserName(userName);
	if(oldvalue!=null && newvalue!=null)
	{
	AuditLogDetail v = new AuditLogDetail();
	v.setOldValue(oldvalue);
	v.setNewValue(newvalue);
	AuditLogDetail.add(v);
	}
	auditLog.setAuditLogDetail(AuditLogDetail);
	dao.saveAuditLog(auditLog);
}


@Override
public String  addAuditLog(Object object) {
	// TODO Auto-generated method stub
	String  message=dao.addAuditLog(object);
	 return message;
}



}
