/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * This is VendGroup pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class VendGroup {

private int vendorGroup_Id;	
private String vendorGroup;
private String vendorGroupCode;
private int aid; 
private int eid;
private String xmlLabel;
private String operations;
private String basicSearchId;
/*Edit Properties*/

private int editVendorGroup_Id;
private String editVendorGroup;
private String editVendorGroupCode;

    /*getter methods of VendGroup*/

	public int getEid() {
	return eid;
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
	public int getAid() {
	return aid;
	}  
    public int getEditVendorGroup_Id() {
		return editVendorGroup_Id;
	}
    public String getEditVendorGroup() {
		return editVendorGroup;
	}
    public int getVendorGroup_Id() {
		return vendorGroup_Id;
	}
    public String getEditVendorGroupCode() {
		return editVendorGroupCode;
	}
    public String getVendorGroup() {
		return vendorGroup;
	}
    public String getVendorGroupCode() {
		return vendorGroupCode;
	}
    
    /*setter methods of VendGroup*/ 
    
    public void setEid(int eid) {
    	this.eid = eid;
    }

    public void setAid(int aid) {
    	this.aid = aid;
    }
	public void setEditVendorGroup_Id(int editVendorGroup_Id) {
		this.editVendorGroup_Id = editVendorGroup_Id;
	}
	
	public void setEditVendorGroup(String editVendorGroup) {
		this.editVendorGroup = editVendorGroup;
	}
	
	public void setEditVendorGroupCode(String editVendorGroupCode) {
		this.editVendorGroupCode = editVendorGroupCode;
	}
	
	public void setVendorGroup_Id(int vendorGroup_Id) {
		this.vendorGroup_Id = vendorGroup_Id;
	}
	
	public void setVendorGroup(String vendorGroup) {
		this.vendorGroup = vendorGroup;
	}
	
	public void setVendorGroupCode(String vendorGroupCode) {
		this.vendorGroupCode = vendorGroupCode;
	}
	

}
