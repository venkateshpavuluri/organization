package com.mnt.erp.dao;

import java.util.List;

public interface VoucherTypeDao {
	public String saveVoucherType(Object object,String userId,String userName);
	public List<Object[]> searchVoucherTypeWithId(int id);
	public List<Object[]> searchVoucherType();
	public List<Object[]> selectVoucherTypeIds();
	public String updateVoucherType(Object object);
	public String deleteVoucherType(int id);
	public Long getVoucherTypeCount(String name);
	public Long getVoucherTypeCountedit(String name,int vtid);
	public List<Object[]> basicSearchVoucherType(String label,String operator,String searchName);
}
