package com.mnt.erp.bean;

public class StorageSectionBean {

    private int storageSectionId;
    private String storageSection;
    private String storageSectionEdit;
    private String storageSectionIdEdit;

    private int aid;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    public int getStorageSectionId() {
	return storageSectionId;
    }

    public void setStorageSectionId(int storageSectionId) {
	this.storageSectionId = storageSectionId;
    }

    public String getStorageSection() {
	return storageSection;
    }

    public void setStorageSection(String storageSection) {
	this.storageSection = storageSection;
    }

    public String getStorageSectionEdit() {
	return storageSectionEdit;
    }

    public void setStorageSectionEdit(String storageSectionEdit) {
	this.storageSectionEdit = storageSectionEdit;
    }

    public String getStorageSectionIdEdit() {
	return storageSectionIdEdit;
    }

    public void setStorageSectionIdEdit(String storageSectionIdEdit) {
	this.storageSectionIdEdit = storageSectionIdEdit;
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
