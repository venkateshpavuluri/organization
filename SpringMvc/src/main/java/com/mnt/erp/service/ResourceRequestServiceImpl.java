package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.dao.ResourceRequestDao;

public class ResourceRequestServiceImpl implements ResourceRequestService{
	
	List<Object[]> objects = null;
	String sus=null;
	
	private ResourceRequestDao resourceRequestDao;
	
	
	
	public ResourceRequestDao getResourceRequestDao() {
		return resourceRequestDao;
	}
	public void setResourceRequestDao(ResourceRequestDao resourceRequestDao) {
		this.resourceRequestDao = resourceRequestDao;
	}
	public Long checkResourceRequest(String fiscalYear){
		Long l = resourceRequestDao.checkResourceRequest(fiscalYear);
		return l;
	}
	public Long updateCheckResourceRequest(String fiscalYear,int fiscalYearId) {
		Long l = resourceRequestDao.updateCheckResourceRequest(fiscalYear, fiscalYearId);
		return l;
	}
	
	public String saveResourceRequestDetails(Object object) {
		try {
			sus = resourceRequestDao.saveResourceRequestDetails(object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	public List<Object[]> searchResourceRequest() {
		
		try {
			objects = resourceRequestDao.searchResourceRequest();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<ResourceRequest> searchResourceRequestWithId(int id) {
		List<ResourceRequest> list = null;
		try {
			list = resourceRequestDao.searchResourceRequestWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updateResourceRequest(Object object) {
		try {
			sus = resourceRequestDao.updateResourceRequest(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;
	}

	public String deleteResourceRequest(int id) {
		try {
			sus = resourceRequestDao.deleteResourceRequest(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sus;

	}

	
	public List<Object[]> selectStatus() {
		
		try {
			objects = resourceRequestDao.selectStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> selectEmployee() {
		
		try {
			objects = resourceRequestDao.selectEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

	public List<Object[]> basicSearchResourceRequest(String label,String operator,String searchName){
		try {
			objects = resourceRequestDao.basicSearchResourceRequest(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public String deleteResourceReqDetail(int kk){
		String msg = null;
		try {
			msg = resourceRequestDao.deleteResourceReqDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	

}
