package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.HouseBankBean;


public interface HouseBankDao {
	public String saveHouseBank(Object object,String userId,String userName);
	public List<Object[]> searchHouseBank();
	public List<Object[]>searchHouseBankWithId(int id);
	public List<Object[]> selectHouseBankIds();
	public List<Object[]>selectOrgid();
	public List<Object[]>selectCountryid();
	public List<HouseBankBean>Edithb(int iid);
	public String updateHouseBank(Object object);
	public String deleteHouseBank(int id);
	public Long getHouseBankCount(String name);
	public Long getHouseBankCountedit(String name,int hbid);
	public List<Object[]> basicSearchHouseBank(String label,String operator,String searchName);
}
