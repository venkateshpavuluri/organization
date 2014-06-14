package com.mnt.erp.bean;

public class LoanTypeBean {
    private int loanTypeId;
    private String loanType;
    private String basicSearchId;
    private String xmlLabel;
    private String operations;
    private int aid;
    public int getLoanTypeId() {
        return loanTypeId;
    }
    public void setLoanTypeId(int loanTypeId) {
        this.loanTypeId = loanTypeId;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
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
