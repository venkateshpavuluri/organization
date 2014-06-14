package com.mnt.erp.service;

import java.util.List;

public interface VoucherTypeService {
	public String saveVoucherTypeservice(Object object,String userId,String userName);
	public List<Object[]> searchVoucherTypeWithId(int id);
	public List<Object[]> searchVoucherType();
	public List<Object[]> selectVoucherTypeids();
	public String updateVoucherType(Object object);
	public String deleteVoucherType(int id);
	public Long getVoucherTypeCount(String name);
	public Long getVoucherTypeCountedit(String name,int vtid);
	
	public List<Object[]> basicSearchVoucherType(String label,String operator,String searchName);

}
