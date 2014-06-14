package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.CustomerInvoice;



public interface CustomerInvoiceDao {
	public String saveCustomerInvoice(Object object);
	public List<Object[]>selectdeliverynote();
	public List<Object[]>selectcurrency();
	public List<Object[]>selectorg();
	public List<Object[]>searchCustomerInvoice();
	public List<Object[]>selectCustomerInvoice();
	public List<Object[]>selectMaterial();
	public List<Object[]>selectUOM();
	public List<CustomerInvoice>EditCustomerInvoice(int iid);
	public String updateCustomerInvoice(Object object);
	public String deleteCustomerInvoice(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchCustomerInvoice(String label,String operator,String searchName);
	public List<Object[]> setCustomerInvoiceAdvanceSearch(String name);
	public List<Object[]> setCustomerInvoiceSearch(String name);
	public Long getCICount(String name);
	public Long getCICountedit(String name,int cid);
}
