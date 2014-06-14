package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.RfqBean;

public interface RfqDao {
	public String saverfq(Object object);
	public List<Object[]>selectrfqType();
	public List<Object[]>selectItemCategory();
	public List<Object[]>selectstorageLocation();
	public List<Object[]>selectplant();
	public List<Object[]>selectpurchaseGroup();
	public List<Object[]>searchRfq();
	public List<Object[]>selectRfq();
	public List<Object[]>selectStatus();
	public List<Object[]>selectMaterial();
	public List<Object[]>selectUOM();
	public List<RfqBean>EditRfq(int iid);
	public String updateRfq(Object object);
	public String deleteRfq(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchRfq(String label,String operator,String searchName);
	public List<Object[]> setRfqAdvanceSearch(String name);
	public List<Object[]> setRfqSearch(String name);
	public Long getRfqCount(String name);
	public Long getRfqCountedit(String name,int Rfqid);
}
