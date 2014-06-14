/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author yogi
 * 
 */
public class AssetConditionBean {
    private int assetConditionId;
    private String assetConditionCode;
    private String assetCondition;
    private int aid;
    private String xmlLabel;
    private String basicSearchId;
    private String operations;

    public int getAssetConditionId() {
	return assetConditionId;
    }

    public void setAssetConditionId(int assetConditionId) {
	this.assetConditionId = assetConditionId;
    }

    public String getAssetConditionCode() {
	return assetConditionCode;
    }

    public void setAssetConditionCode(String assetConditionCode) {
	this.assetConditionCode = assetConditionCode;
    }

    public String getAssetCondition() {
	return assetCondition;
    }

    public void setAssetCondition(String assetCondition) {
	this.assetCondition = assetCondition;
    }

    public int getAid() {
	return aid;
    }

    public void setAid(int aid) {
	this.aid = aid;
    }

    public String getXmlLabel() {
	return xmlLabel;
    }

    public void setXmlLabel(String xmlLabel) {
	this.xmlLabel = xmlLabel;
    }

    public String getBasicSearchId() {
	return basicSearchId;
    }

    public void setBasicSearchId(String basicSearchId) {
	this.basicSearchId = basicSearchId;
    }

    public String getOperations() {
	return operations;
    }

    public void setOperations(String operations) {
	this.operations = operations;
    }
}
