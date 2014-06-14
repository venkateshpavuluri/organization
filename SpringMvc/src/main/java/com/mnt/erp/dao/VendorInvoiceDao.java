package com.mnt.erp.dao;

import java.util.List;


import com.mnt.erp.bean.VendorInvoice;

public interface VendorInvoiceDao {
	public String saveVendorInvoice(Object object);
	public List<Object[]>selectorg();
	public List<Object[]>selectcurrency();
	public List<Object[]>selectVendor();
	public List<Object[]>selectpurchaseOrder();
	public List<Object[]>searchVendorInvoice();
	public List<Object[]>selectVendorInvoice();
	public List<Object[]>selectMaterial();
	public List<Object[]>selectUOM();
	public List<VendorInvoice>EditVendorInvoice(int iid);
	public String updateVendorInvoice(Object object);
	public String deleteVendorInvoice(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchVendorInvoice(String label,String operator,String searchName);
	public List<Object[]> setVendorInvoiceAdvanceSearch(String name);
	public List<Object[]> setVendorInvoiceSearch(String name);
	public Long getVICount(String name);
	public Long getVICountedit(String name,int viid);

}
