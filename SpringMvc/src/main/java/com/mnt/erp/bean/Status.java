package com.mnt.erp.bean;

import java.io.Serializable;

public class Status implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int statusId;
	private String status;
	private int statusIdEdit;
	private String statusEdit;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusEdit() {
		return statusEdit;
	}

	public void setStatusEdit(String statusEdit) {
		this.statusEdit = statusEdit;
	}

	public int getStatusIdEdit() {
		return statusIdEdit;
	}

	public void setStatusIdEdit(int statusIdEdit) {
		this.statusIdEdit = statusIdEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
