package com.mnt.erp.bean;

import java.util.List;

public class Agreement {
	private int agreementId;
	private String agreementtypeid;
	private String agreementNo;
	private String vendorId;
	private String orgId;
	private String purOrgId;
	private String agreementDate;
	private String stdt;
	private String etdt;
	private int[] agreementlineId;
	private String materialId;
	private String materialName;
	private String[] targetqty;
	private String uomId;
	private String uomName;
	private String[] netprice;
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private AgreementType agtypebean;
	private Vendor vendorbean;
	private Organization orgbean;
	private PurchaseOrganization purorgbean;
	private int[] agreementlineidedit;
	private String materialIdedit;
	private String[] targetqtyedit;
	private String uomIdedit;
	private String[] netpriceedit;
	private String uomNameEdit;
	private String materialNameEdit;
	private String materialidName;
	private String uomidName;

	public String getUomidName() {
		return uomidName;
	}

	public void setUomidName(String uomidName) {
		this.uomidName = uomidName;
	}

	public String getMaterialidName() {
		return materialidName;
	}

	public void setMaterialidName(String materialidName) {
		this.materialidName = materialidName;
	}

	public String getUomNameEdit() {
		return uomNameEdit;
	}

	public void setUomNameEdit(String uomNameEdit) {
		this.uomNameEdit = uomNameEdit;
	}

	public String getMaterialNameEdit() {
		return materialNameEdit;
	}

	public void setMaterialNameEdit(String materialNameEdit) {
		this.materialNameEdit = materialNameEdit;
	}

	public int[] getAgreementlineidedit() {
		return agreementlineidedit;
	}

	public void setAgreementlineidedit(int[] agreementlineidedit) {
		this.agreementlineidedit = agreementlineidedit;
	}

	public String getMaterialIdedit() {
		return materialIdedit;
	}

	public void setMaterialIdedit(String materialIdedit) {
		this.materialIdedit = materialIdedit;
	}

	public String getUomIdedit() {
		return uomIdedit;
	}

	public void setUomIdedit(String uomIdedit) {
		this.uomIdedit = uomIdedit;
	}

	public String[] getTargetqtyedit() {
		return targetqtyedit;
	}

	public void setTargetqtyedit(String[] targetqtyedit) {
		this.targetqtyedit = targetqtyedit;
	}

	public String[] getNetpriceedit() {
		return netpriceedit;
	}

	public void setNetpriceedit(String[] netpriceedit) {
		this.netpriceedit = netpriceedit;
	}

	public AgreementType getAgtypebean() {
		return agtypebean;
	}

	public void setAgtypebean(AgreementType agtypebean) {
		this.agtypebean = agtypebean;
	}

	public Vendor getVendorbean() {
		return vendorbean;
	}

	public void setVendorbean(Vendor vendorbean) {
		this.vendorbean = vendorbean;
	}

	public Organization getOrgbean() {
		return orgbean;
	}

	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}

	public PurchaseOrganization getPurorgbean() {
		return purorgbean;
	}

	public void setPurorgbean(PurchaseOrganization purorgbean) {
		this.purorgbean = purorgbean;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getXmlLabel() {
		return xmlLabel;
	}

	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

	public String getBasicSearchId() {
		return basicSearchId;
	}

	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	private List<AgreementLine> agreementline;

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public List<AgreementLine> getAgreementline() {
		return agreementline;
	}

	public void setAgreementline(List<AgreementLine> agreementline) {
		this.agreementline = agreementline;
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public String getAgreementtypeid() {
		return agreementtypeid;
	}

	public void setAgreementtypeid(String agreementtypeid) {
		this.agreementtypeid = agreementtypeid;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getPurOrgId() {
		return purOrgId;
	}

	public void setPurOrgId(String purOrgId) {
		this.purOrgId = purOrgId;
	}

	public String getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(String agreementDate) {
		this.agreementDate = agreementDate;
	}

	public String getStdt() {
		return stdt;
	}

	public void setStdt(String stdt) {
		this.stdt = stdt;
	}

	public String getEtdt() {
		return etdt;
	}

	public void setEtdt(String etdt) {
		this.etdt = etdt;
	}

	public int[] getAgreementlineId() {
		return agreementlineId;
	}

	public void setAgreementlineId(int[] agreementlineId) {
		this.agreementlineId = agreementlineId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String[] getTargetqty() {
		return targetqty;
	}

	public void setTargetqty(String[] targetqty) {
		this.targetqty = targetqty;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String[] getNetprice() {
		return netprice;
	}

	public void setNetprice(String[] netprice) {
		this.netprice = netprice;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public String getSecondLabel() {
		return secondLabel;
	}

	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	public String getOperations1() {
		return operations1;
	}

	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

}
