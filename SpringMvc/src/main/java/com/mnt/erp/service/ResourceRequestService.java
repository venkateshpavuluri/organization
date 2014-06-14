package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ResourceRequest;

public interface ResourceRequestService {

	public Long updateCheckResourceRequest(String fiscalYear,int fiscalYearId);

	public Long checkResourceRequest(String fiscalYear);
	
	public String saveResourceRequestDetails(Object object);

	public List<Object[]> searchResourceRequest();

	public List<ResourceRequest> searchResourceRequestWithId(int id);

	public String updateResourceRequest(Object object);

	public String deleteResourceRequest(int id);
	
	public List<Object[]> selectEmployee();
	
	public List<Object[]> selectStatus();
	
	public String deleteResourceReqDetail(int kk);
	
	public List<Object[]> basicSearchResourceRequest(String label,String operator,String searchName);
	
	
}
