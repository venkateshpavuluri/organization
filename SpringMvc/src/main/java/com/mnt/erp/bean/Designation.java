/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class Designation {
	private int designationId;
	private String designation;
	private String designationSearch;
	private int aid;
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	private int designationIdEdit;
	private String designationEdit;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignationSearch() {
		return designationSearch;
	}
	public void setDesignationSearch(String designationSearch) {
		this.designationSearch = designationSearch;
	}
	public int getDesignationIdEdit() {
		return designationIdEdit;
	}
	public void setDesignationIdEdit(int designationIdEdit) {
		this.designationIdEdit = designationIdEdit;
	}
	public String getDesignationEdit() {
		return designationEdit;
	}
	public void setDesignationEdit(String designationEdit) {
		this.designationEdit = designationEdit;
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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	
	

}
