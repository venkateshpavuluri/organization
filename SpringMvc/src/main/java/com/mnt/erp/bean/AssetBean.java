package com.mnt.erp.bean;

import java.util.List;

public class AssetBean {
	private int assetid;
	private String assettypeId;
	private String assetgroupId;
	private String model;
	private String serialNumber;
	private String status;
	private String weon;

	private int[] assetasgmntId;
	private String employeeId;
	private String[] assignedon;
	private String[] returnedon;
	private int[] assetasgmntIdedit;
	private String employeeIdedit;
	private String[] assignedonedit;
	private String[] returnedonedit;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	private String valueForSubData;
	private String employeename;
	private String employeenameedit;
	private AssertTypeBean assetTypeBean;
	private AssetGroup assetGroupBean;
	
	
	
public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeenameedit() {
		return employeenameedit;
	}

	public void setEmployeenameedit(String employeenameedit) {
		this.employeenameedit = employeenameedit;
	}

private List<AssetAssignmentBean> assetasgnmentbean;	

	public List<AssetAssignmentBean> getAssetasgnmentbean() {
	return assetasgnmentbean;
}

public void setAssetasgnmentbean(List<AssetAssignmentBean> assetasgnmentbean) {
	this.assetasgnmentbean = assetasgnmentbean;
}

	public AssertTypeBean getAssetTypeBean() {
		return assetTypeBean;
	}

	public void setAssetTypeBean(AssertTypeBean assetTypeBean) {
		this.assetTypeBean = assetTypeBean;
	}

	public AssetGroup getAssetGroupBean() {
		return assetGroupBean;
	}

	public void setAssetGroupBean(AssetGroup assetGroupBean) {
		this.assetGroupBean = assetGroupBean;
	}

	public int[] getAssetasgmntId() {
		return assetasgmntId;
	}

	public void setAssetasgmntId(int[] assetasgmntId) {
		this.assetasgmntId = assetasgmntId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String[] getAssignedon() {
		return assignedon;
	}

	public void setAssignedon(String[] assignedon) {
		this.assignedon = assignedon;
	}

	public String[] getReturnedon() {
		return returnedon;
	}

	public void setReturnedon(String[] returnedon) {
		this.returnedon = returnedon;
	}

	public int[] getAssetasgmntIdedit() {
		return assetasgmntIdedit;
	}

	public void setAssetasgmntIdedit(int[] assetasgmntIdedit) {
		this.assetasgmntIdedit = assetasgmntIdedit;
	}

	public String getEmployeeIdedit() {
		return employeeIdedit;
	}

	public void setEmployeeIdedit(String employeeIdedit) {
		this.employeeIdedit = employeeIdedit;
	}

	public String[] getAssignedonedit() {
		return assignedonedit;
	}

	public void setAssignedonedit(String[] assignedonedit) {
		this.assignedonedit = assignedonedit;
	}

	public String[] getReturnedonedit() {
		return returnedonedit;
	}

	public void setReturnedonedit(String[] returnedonedit) {
		this.returnedonedit = returnedonedit;
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

	public String getValueForSubData() {
		return valueForSubData;
	}

	public void setValueForSubData(String valueForSubData) {
		this.valueForSubData = valueForSubData;
	}

	

	public int getAssetid() {
		return assetid;
	}

	public void setAssetid(int assetid) {
		this.assetid = assetid;
	}

	public String getAssettypeId() {
		return assettypeId;
	}

	public void setAssettypeId(String assettypeId) {
		this.assettypeId = assettypeId;
	}

	public String getAssetgroupId() {
		return assetgroupId;
	}

	public void setAssetgroupId(String assetgroupId) {
		this.assetgroupId = assetgroupId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWeon() {
		return weon;
	}

	public void setWeon(String weon) {
		this.weon = weon;
	}

}
