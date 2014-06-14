package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Vendor;

public interface VendorDao {

	public int saveVendor(Vendor mm);

	public List<Object[]> setVendorSearch(String name);

	public List<Object[]> setVendorSearch(int id);
	
	public List<Object[]> setVendorAdvanceSearch(String name);

	public List<Object[]> setVendorBankDetSearch(int id);

	public List<Object[]> setVendorDocumentSearch(int id);

	public List<Object[]> setVendorMaterialSearch(int id);
	public List<Object[]> setVendorAccountSearch(int id);

	public String updateVendor(Object object);
	public String updateVendorAccount(Object object);

	public String updateVendorBankDet(Object object);

	public String updateVendorMaterial(Object object);

	public String vendorDelete(int id);

	public String vendorBankDetDelete(int id);

	public String vendorMaterialDelete(int id);

	public Long getVendorNameDuplicate(String mm);

	public String UpdateVendorDocuments(Object object);

	public String vendorDocumentDelete(int id);

	public Long checkDuplicateVendorBankDet(String name, String accountNumber,
			int id,int bankId);

	public String getGroupName(String id);

	public String getCountryName(String id);
	
	public List<Object[]> vendorIdGet();
	
	public List<Object[]> basicSearchVendor(String label,String operator,String searchName);
	
	public Long getVendorNameDuplicateEdit(String mm,int id);
	
	
	public List<Object[]> selectAccountGroupIds();

	public List<Object[]> selectPaymentTermIds();

	public List<Object[]> selectPaymentMethodIds(String type);

}
