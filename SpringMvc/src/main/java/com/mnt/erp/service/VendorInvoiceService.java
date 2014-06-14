package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.bean.VendorInvoice;

public interface VendorInvoiceService {
	public String saveVendorInvoiceservice(Object object);
	public List<Object[]>selectorgservice();
	public List<Object[]>selectcurrencyservice();
	public List<Object[]>selectVendorservice();
	public List<Object[]>selectpurchaseOrderservice();
	public List<Object[]>searchVendorInvoiceservice();
	public List<Object[]>selectVendorInvoiceservice();
	public List<Object[]>selectMaterialservice();
	public List<Object[]>selectUOMservice();
	public List<VendorInvoice>EditVendorInvoiceservice(int iid);
	public List<Object[]> VendorInvoiceadvance(String columns,String opeator,String advanceSearchText);
	public List<Object[]> getVendorInvoice(String vi);
	public String deleteChildDetailsService(int cid);
	public String updateVendorInvoiceservice(Object object);
	public String deleteVendorInvoiceservice(int id);
	public List<Object[]> basicSearchVendorInvoiceservice(String label,String operator,String searchName);
	public Long getVICount(String name);
	public Long getVICountedit(String name,int Rfqid);
}
