package com.mnt.erp.bean;

public class BonusTypeBean {
    private int bonusTypeId;
    private String bonusType;
    private String basicSearchId;
    private String xmlLabel;
    private String operations;
    private int aid;
    public int getBonusTypeId() {
        return bonusTypeId;
    }
    public void setBonusTypeId(int bonusTypeId) {
        this.bonusTypeId = bonusTypeId;
    }
    public String getBonusType() {
        return bonusType;
    }
    public void setBonusType(String bonusType) {
        this.bonusType = bonusType;
    }
    public String getBasicSearchId() {
        return basicSearchId;
    }
    public void setBasicSearchId(String basicSearchId) {
        this.basicSearchId = basicSearchId;
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
    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
}
