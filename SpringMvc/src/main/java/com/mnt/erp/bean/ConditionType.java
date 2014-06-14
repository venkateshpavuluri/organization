/**
 * 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author madhav
 *
 */
public class ConditionType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//variable for adding 
	private int conditionTypeId;
	private String conditionType;
	private int ctId;
	
	//variables for searching
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//variables for Editing
	private int conditionTypeIdEdit;
	private String conditionTypeEdit;
	private int ctIdEdit;
	
	
	
	
	//Getters and setter methods
	/**
	 * @return the conditionTypeId
	 */
	public int getConditionTypeId() {
		return conditionTypeId;
	}
	/**
	 * @param conditionTypeId the conditionTypeId to set
	 */
	public void setConditionTypeId(int conditionTypeId) {
		this.conditionTypeId = conditionTypeId;
	}
	/**
	 * @return the conditionType
	 */
	public String getConditionType() {
		return conditionType;
	}
	/**
	 * @param conditionType the conditionType to set
	 */
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	/**
	 * @return the ctId
	 */
	public int getCtId() {
		return ctId;
	}
	/**
	 * @param ctId the ctId to set
	 */
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}
	/**
	 * @param xmlLabel the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}
	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}
	/**
	 * @param basicSearchId the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	/**
	 * @return the conditionTypeIdEdit
	 */
	public int getConditionTypeIdEdit() {
		return conditionTypeIdEdit;
	}
	/**
	 * @param conditionTypeIdEdit the conditionTypeIdEdit to set
	 */
	public void setConditionTypeIdEdit(int conditionTypeIdEdit) {
		this.conditionTypeIdEdit = conditionTypeIdEdit;
	}
	/**
	 * @return the conditionTypeEdit
	 */
	public String getConditionTypeEdit() {
		return conditionTypeEdit;
	}
	/**
	 * @param conditionTypeEdit the conditionTypeEdit to set
	 */
	public void setConditionTypeEdit(String conditionTypeEdit) {
		this.conditionTypeEdit = conditionTypeEdit;
	}
	/**
	 * @return the ctIdEdit
	 */
	public int getCtIdEdit() {
		return ctIdEdit;
	}
	/**
	 * @param ctIdEdit the ctIdEdit to set
	 */
	public void setCtIdEdit(int ctIdEdit) {
		this.ctIdEdit = ctIdEdit;
	}
	
	


}
