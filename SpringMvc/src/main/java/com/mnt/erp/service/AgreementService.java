package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.PurchaseOrganization;

public interface AgreementService {
	public String saveAgreement(Object object);
	public List<Object[]>selectAgreementTypeid();
	public List<PurchaseOrganization>selectPo(int orgId);
	public List<PurchaseOrganization>selectPoEdit(int orgId);
	public List<Object[]>selectVendorId();
	public List<Object[]>selectOrgId();
	public List<Object[]>selectpurOrgId();
	public List<Object[]>selectMaterial();
	public List<Object[]>selectUom();
	public List<Object[]>searchAgreementservice();
	public List<Agreement>EditAgreement(int iid);
	public String updateAgreement(Object object);
	public String deleteAgreement(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchAgreement(String label,String operator,String searchName);
	public List<Object[]> setAgreementAdvanceSearch(String columns, String opeator,
			String advanceSearchText);
	public List<Object[]> setAgreementSearch(String name);
	public Long getAgreementCount(String name);
	public Long getAgreementCountedit(String name,int Agreementid);
}
