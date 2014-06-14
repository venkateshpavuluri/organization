package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.PurchaseOrganization;

public interface AgreementDao {
	public String saveAgreement(Object object);
	public List<Object[]>selectAgreementTypeid();
	public List<PurchaseOrganization> selectPoIds(int orgId);
	public List<PurchaseOrganization> selectPoIdsEdit(int orgId);
	public List<Object[]>selectVendorId();
	public List<Object[]>selectOrgId();
	public List<Object[]>selectpurOrgId();
	public List<Object[]>selectMaterial();
	public List<Object[]>selectUom();
	public List<Object[]>searchAgreement();
	public List<Agreement>EditAgreement(int iid);
	public String updateAgreement(Object object);
	public String deleteAgreement(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchAgreement(String label,String operator,String searchName);
	public List<Object[]> setAgreementAdvanceSearch(String name);
	public List<Object[]> setAgreementSearch(String name);
	public Long getAgreementCount(String name);
	public Long getAgreementCountedit(String name,int Agreementid);
	
	
}
