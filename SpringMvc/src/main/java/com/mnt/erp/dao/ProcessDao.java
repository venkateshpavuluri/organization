package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.ProcessBean;

public interface ProcessDao {
	public String saveprocess(Object object);
	public List<Object[]>searchProcessWithId(int id);
	public List<Object[]>searchProcess();
	public List<Object[]>selectProcess();
	public List<Object[]>selectMaterial();
	public List<ProcessBean>EditProcess(int iid);
	public Long getProcessDetailedit(String name,int processdid);
	public Long getProcessDetailcountedit(String name,int processdetailsid);
	public String updateProcess(Object object);
	public String deleteProcess(int id);
	public String deleteChildDetails(int cid);
	public Long getProcessCount(String name);
	public Long getProcessDetailCount(String desc);
	public Long getProcessDescriptionedit(String name,int processdescid);
	public List<Object[]>selectProcessTypeDetail();
	public List<Object[]> basicSearchProcess(String label,String operator,String searchName);
}
