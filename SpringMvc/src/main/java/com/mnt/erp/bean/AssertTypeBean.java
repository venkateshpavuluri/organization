/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

import java.io.Serializable;


/*
 * @author Naresh
 * @version 1.0  18-09-2013
 */
public class AssertTypeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int assertTypeId;
	private String assertTypeName;
	private int atId;
	private int ateditId;
	private int assertTypeEditId;
	private String assertTypeEditName;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	//Setter And Getter Methods
	
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
	
	public String getXmlLabel() {
		return xmlLabel;
	}

	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	public int getAssertTypeEditId() {
		return assertTypeEditId;
	}

	public void setAssertTypeEditId(int assertTypeEditId) {
		this.assertTypeEditId = assertTypeEditId;
	}

	public String getAssertTypeEditName() {
		return assertTypeEditName;
	}

	public void setAssertTypeEditName(String assertTypeEditName) {
		this.assertTypeEditName = assertTypeEditName;
	}

	public int getAssertTypeId() {
		return assertTypeId;
	}

	public void setAssertTypeId(int assertTypeId) {
		this.assertTypeId = assertTypeId;
	}

	public String getAssertTypeName() {
		return assertTypeName;
	}

	public void setAssertTypeName(String assertTypeName) {
		this.assertTypeName = assertTypeName;
	}

	public int getAtId() {
		return atId;
	}

	public void setAtId(int atId) {
		this.atId = atId;
	}

	public int getAteditId() {
		return ateditId;
	}

	public void setAteditId(int ateditId) {
		this.ateditId = ateditId;
	}

}
