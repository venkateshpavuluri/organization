package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.RfqBean;

public interface RfqService {
	public String saverfqservice(Object object);
	public List<Object[]>selectrfqTypeservice();
	public List<Object[]>selectItemCategoryservice();
	public List<Object[]>selectstorageLocationservice();
	public List<Object[]>selectplantservice();
	public List<Object[]>selectpurchaseGroupservice();
	public List<Object[]>searchRfqservice();
	public List<Object[]>selectRfqservice();
	public List<Object[]>selectMaterialservice();
	public List<Object[]>selectStatus();
	public List<Object[]>selectUOMservice();
	public List<RfqBean>EditRfqservice(int iid);
	public List<Object[]> Rfqadvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getrfq(String rfq);
	public String deleteChildDetailsService(int cid);
	public String updateRfqservice(Object object);
	public String deleteRfqservice(int id);
	public List<Object[]> basicSearchRfqservice(String label,String operator,String searchName);
	public Long getRfqCount(String name);
	public Long getRfqCountedit(String name,int Rfqid);
}
