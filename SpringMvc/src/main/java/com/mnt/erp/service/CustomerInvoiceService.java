package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.CustomerInvoice;


public interface CustomerInvoiceService {
	public String saveCustomerInvoiceservice(Object object);
	public List<Object[]>selectorgservice();
	public List<Object[]>selectcurrencyservice();
	public List<Object[]>selectDeliveryNoteservice();
	public List<Object[]>selectCustomerInvoiceservice();
	public List<Object[]>selectMaterialservice();
	public List<Object[]>selectUOMservice();
	public List<CustomerInvoice>EditCustomerInvoiceservice(int iid);
	public List<Object[]> CustomerInvoiceadvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getCustomerInvoice(String vi);
	public String deleteChildDetailsService(int cid);
	public String updateCustomerInvoiceservice(Object object);
	public String deleteCustomerInvoiceservice(int id);
	public List<Object[]> basicSearchCustomerInvoiceservice(String label,String operator,String searchName);
	public Long getCICount(String name);
	public Long getCICountedit(String name,int cid);
}
