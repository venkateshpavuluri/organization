package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.HouseBankBean;


public interface HouseBankService {
	public String saveHouseBankService(Object object,String userId,String userName);
	public List<Object[]> searchHouseBankService();
	public List<Object[]>searchHouseBankServiceWithId(int id);
	public List<Object[]> selectHouseBankIdsService();
	public List<Object[]>selectOrgidService();
	public List<Object[]>selectCountryidService();
	public String updateHouseBankService(Object object);
	public List<HouseBankBean>EditHousebankservice(int iid);
	public String deleteHouseBankService(int id);
	public Long getHouseBankCountService(String name);
	public Long getHouseBankCounteditService(String name,int hbid);
	public List<Object[]> basicSearchHouseBankService(String label,String operator,String searchName);

}
