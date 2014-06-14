/*
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 19-09-2013
 */
public class ShippingConditionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shippingConditionId;
	private String shippingCondition;
	private int scId;
	private int scEditId;
	private int shippingConditionEditId;
	private String shippingConditionEdit;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;


	// Setter And Getter Methods
	
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


	public int getScEditId() {
		return scEditId;
	}

	public void setScEditId(int scEditId) {
		this.scEditId = scEditId;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getShippingConditionEditId() {
		return shippingConditionEditId;
	}

	public void setShippingConditionEditId(int shippingConditionEditId) {
		this.shippingConditionEditId = shippingConditionEditId;
	}

	public String getShippingConditionEdit() {
		return shippingConditionEdit;
	}

	public void setShippingConditionEdit(String shippingConditionEdit) {
		this.shippingConditionEdit = shippingConditionEdit;
	}

	public int getShippingConditionId() {
		return shippingConditionId;
	}

	public void setShippingConditionId(int shippingConditionId) {
		this.shippingConditionId = shippingConditionId;
	}

	public String getShippingCondition() {
		return shippingCondition;
	}

	public void setShippingCondition(String shippingCondition) {
		this.shippingCondition = shippingCondition;
	}

}
