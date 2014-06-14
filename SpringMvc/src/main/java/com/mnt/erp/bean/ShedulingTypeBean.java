/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class ShedulingTypeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shedulingTypeId;
	private String shedulingType;
	private int shdId;
	private int shdEditId;
	private int shedulingTypeEditId;
	private String shedulingEditType;
	
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


	public int getShedulingTypeEditId() {
		return shedulingTypeEditId;
	}

	public void setShedulingTypeEditId(int shedulingTypeEditId) {
		this.shedulingTypeEditId = shedulingTypeEditId;
	}

	public String getShedulingEditType() {
		return shedulingEditType;
	}

	public void setShedulingEditType(String shedulingEditType) {
		this.shedulingEditType = shedulingEditType;
	}

	public int getShedulingTypeId() {
		return shedulingTypeId;
	}

	public void setShedulingTypeId(int shedulingTypeId) {
		this.shedulingTypeId = shedulingTypeId;
	}

	public String getShedulingType() {
		return shedulingType;
	}

	public void setShedulingType(String shedulingType) {
		this.shedulingType = shedulingType;
	}

	public int getShdId() {
		return shdId;
	}

	public void setShdId(int shdId) {
		this.shdId = shdId;
	}

	public int getShdEditId() {
		return shdEditId;
	}

	public void setShdEditId(int shdEditId) {
		this.shdEditId = shdEditId;
	}

}
