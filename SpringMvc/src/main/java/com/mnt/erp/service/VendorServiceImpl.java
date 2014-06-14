package com.mnt.erp.service;

import java.io.Serializable;


import java.util.List;

import com.mnt.erp.dao.VendorDaoImpl;

public class VendorServiceImpl implements VendorService, Serializable {
	private com.mnt.erp.dao.VendorDaoImpl dao;
	List<Object[]> objects = null;

	public VendorDaoImpl getDao() {
		return dao;
	}

	public void setDao(VendorDaoImpl dao) {
		this.dao = dao;
	}

	public List<Object[]> getVendor(String vendor) {
		List<Object[]> list = dao.setVendorSearch(vendor);
		return list;
	}
	
	public List<Object[]> getVendorAdvance(String columns,String opeator,String advanceSearchText) {
		String column[]=columns.split(",");
		String op[]=opeator.split(",");
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  "+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
			
			
			
		}
		//System.out.println("String Value Kiran" +finalStringForSearch);
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = dao.setVendorAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = dao.setVendorSearch("ALL");
		}
		return list;
	}

	public String getGroupName(String id) {
		String name = dao.getGroupName(id);
		return name;
	}

	public String getCountryName(String id) {
		String name = dao.getCountryName(id);
		return name;
	}

	public List<Object[]> getVendorId(int id) {
		List<Object[]> list = dao.setVendorSearch(id);
		return list;
	}

	public List<Object[]> getVendorBankDetId(int id) {
		List<Object[]> list = dao.setVendorBankDetSearch(id);
		return list;
	}

	public List<Object[]> getVendorDocumentId(int id) {
		List<Object[]> list = dao.setVendorDocumentSearch(id);
		return list;
	}

	public List<Object[]> getVendorMaterialId(int id) {
		List<Object[]> list = dao.setVendorMaterialSearch(id);
		return list;
	}
	public List<Object[]> getVendorAccountId(int id) {
		List<Object[]> list = dao.setVendorAccountSearch(id);
		return list;
	}
	
	

	public String updateVendor(Object object) {
		String msg = null;
		try {
			msg = dao.updateVendor(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String UpdateVendorDocuments(Object object) {
		String msg = null;
		try {
			msg = dao.UpdateVendorDocuments(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String updateVendorBankDet(Object object) {
		String msg = null;
		try {
			msg = dao.updateVendorBankDet(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String updateVendorMaterial(Object object) {
		String msg = null;
		try {
			msg = dao.updateVendorMaterial(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	
	public String updateVendorAccount(Object object) {
		String msg = null;
		try {
			msg = dao.updateVendorAccount(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	

	public String vendorDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.vendorDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String vendorBankDetDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.vendorBankDetDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String vendorDocumentDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.vendorDocumentDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String vendorMaterialDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.vendorMaterialDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public String vendorAccountDelete(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = dao.vendorAccountDelete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	

	public int setVendorSave(com.mnt.erp.bean.Vendor mm) {
		int success = dao.saveVendor(mm);
		return success;

	}

	public Long getVendorNameDuplicate(String name) {
		Long success = dao.getVendorNameDuplicate(name);
		return success;

	}

	public int setVendorBankDetSave(com.mnt.erp.bean.VendorBankDet mm) {
		int success = dao.saveVendorBankDet(mm);
		return success;

	}

	public Long checkDuplicateVendorBankDet(String name, String accountNumber,
			int id,int bankId) {
		Long success = dao.checkDuplicateVendorBankDet(name, accountNumber, id,bankId);
		return success;

	}

	public int setVendorMaterialSave(com.mnt.erp.bean.VendorMaterial mm) {
		int success = dao.saveVendorMaterial(mm);
		return success;

	}
	public int setVendorAccountSave(com.mnt.erp.bean.VendorAccountDetails mm) {
		int success = dao.saveVendorAccount(mm);
		return success;

	}
	

	public int setVendorDocumentsSave(com.mnt.erp.bean.VendorDocuments mm) {
		int success = dao.saveVendorDocuments(mm);
		return success;

	}

	@Override
	public List<Object[]> vendorIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = dao.vendorIdGet();
		return idsList;
	}

	public List<Object[]> basicSearchVendor(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {
			objs = dao.basicSearchVendor(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	public Long getVendorNameDuplicateForEdit(String name,int id) {
		Long success =dao.getVendorNameDuplicateEdit(name,id);
		return success;
		
	}
	
	
	@Override
	public List<Object[]> selectAccountGroupIds() {
		try {
			objects = dao.selectAccountGroupIds();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentTermIds() {
		try {
			objects = dao.selectPaymentTermIds();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPaymentMethodIds(String type) {
		try {
			objects = dao.selectPaymentMethodIds(type);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	
	
	
}
