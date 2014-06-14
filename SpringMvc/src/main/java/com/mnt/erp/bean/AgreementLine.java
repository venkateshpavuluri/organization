package com.mnt.erp.bean;

public class AgreementLine {

	private int agreementlineid;
	private int agreementId;
	private String materialId;
	private String targetqty;
	private String uomId;
	private String netprice;
	private Material materialdetail;
	private Uom uomdetail;
	private String materialidName;;
	private String uomidName;
	private int agreementlineidedit;
	private String materialIdedit;
	private String targetqtyedit;
	private String uomIdedit;
	private String netpriceedit;

	public int getAgreementlineidedit() {
		return agreementlineidedit;
	}

	public void setAgreementlineidedit(int agreementlineidedit) {
		this.agreementlineidedit = agreementlineidedit;
	}

	public String getMaterialIdedit() {
		return materialIdedit;
	}

	public void setMaterialIdedit(String materialIdedit) {
		this.materialIdedit = materialIdedit;
	}


	public String getTargetqtyedit() {
		return targetqtyedit;
	}

	public void setTargetqtyedit(String targetqtyedit) {
		this.targetqtyedit = targetqtyedit;
	}

	public String getUomIdedit() {
		return uomIdedit;
	}

	public void setUomIdedit(String uomIdedit) {
		this.uomIdedit = uomIdedit;
	}

	public String getNetpriceedit() {
		return netpriceedit;
	}

	public void setNetpriceedit(String netpriceedit) {
		this.netpriceedit = netpriceedit;
	}

	public String getMaterialidName() {
		return materialidName;
	}

	public void setMaterialidName(String materialidName) {
		this.materialidName = materialidName;
	}

	public String getUomidName() {
		return uomidName;
	}

	public void setUomidName(String uomidName) {
		this.uomidName = uomidName;
	}

	public Material getMaterialdetail() {
		return materialdetail;
	}

	public void setMaterialdetail(Material materialdetail) {
		this.materialdetail = materialdetail;
	}

	public Uom getUomdetail() {
		return uomdetail;
	}

	public void setUomdetail(Uom uomdetail) {
		this.uomdetail = uomdetail;
	}

	public int getAgreementlineid() {
		return agreementlineid;
	}

	public void setAgreementlineid(int agreementlineid) {
		this.agreementlineid = agreementlineid;
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getTargetqty() {
		return targetqty;
	}

	public void setTargetqty(String targetqty) {
		this.targetqty = targetqty;
	}

	public String getUomId() {
		return uomId;
	}

	public void setUomId(String uomId) {
		this.uomId = uomId;
	}

	public String getNetprice() {
		return netprice;
	}

	public void setNetprice(String netprice) {
		this.netprice = netprice;
	}

}
