/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author yogi
 * 
 */
public class ClaimTypeBean {

    private int claimTypeId;
    private String claimType;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;
    private int eId;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public int getClaimTypeId() {
	return claimTypeId;
    }

    public void setClaimTypeId(int claimTypeId) {
	this.claimTypeId = claimTypeId;
    }

    public String getClaimType() {
	return claimType;
    }

    public void setClaimType(String claimType) {
	this.claimType = claimType;
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

}
