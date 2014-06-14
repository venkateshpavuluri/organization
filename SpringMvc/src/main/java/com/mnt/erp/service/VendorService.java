package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorAccountDetails;
import com.mnt.erp.bean.VendorBankDet;
import com.mnt.erp.bean.VendorDocuments;
import com.mnt.erp.bean.VendorMaterial;

public interface VendorService {
	public int setVendorSave(Vendor mm);

	public int setVendorBankDetSave(VendorBankDet mm);

	public int setVendorMaterialSave(VendorMaterial mm);
	
	public int setVendorAccountSave(VendorAccountDetails mm);
	

	public int setVendorDocumentsSave(VendorDocuments mm);

	public List<Object[]> getVendor(String vendor);

	public String getGroupName(String id);

	public String getCountryName(String id);

	public List<Object[]> getVendorId(int id);

	public List<Object[]> getVendorBankDetId(int id);

	public List<Object[]> getVendorDocumentId(int id);

	public List<Object[]> getVendorMaterialId(int id);

	public List<Object[]> getVendorAccountId(int id);
	

	public String updateVendor(Object object);

	public String updateVendorBankDet(Object object);

	public String updateVendorMaterial(Object object);
	public String updateVendorAccount(Object object);
	
	

	public String vendorDelete(int id);

	public String vendorBankDetDelete(int id);

	public String vendorMaterialDelete(int id);
	
	public String vendorAccountDelete(int id);
	

	public String vendorDocumentDelete(int id);

	public Long getVendorNameDuplicate(String name);
	
	public Long getVendorNameDuplicateForEdit(String name,int id);

	public Long checkDuplicateVendorBankDet(String name, String accountNumber,
			int id,int bankId);

	public String UpdateVendorDocuments(Object object);

	public List<Object[]> vendorIdGet();
	
	public List<Object[]> basicSearchVendor(String label, String operator,
			String searchName);

	// public List<Object[]> getVendorGroupIds();
	public List<Object[]> getVendorAdvance(String columns,String opeator,String advanceSearchText);

	
	public List<Object[]> selectAccountGroupIds();

	public List<Object[]> selectPaymentTermIds();

	public List<Object[]> selectPaymentMethodIds(String type);
}
