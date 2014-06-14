/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class Code {
	/*Variable for Code Bean */
	private int codeId;
	private String code;
	private String codeGroupId;
	
	private int codeIdEdit;
	private String codeEdit;
	private String codeGroupIdEdit;
	private int aid;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	/* Variable For Basic Search And Advanced Search*/
	private String operations;
	private String basicSearchId;
	private String xmlLabelBasic;
	
	
	/* Duplicate Check */
	private int codeDuplicate;
	private int cnId;
	
	
	/*For Group Name*/
	
	private CodeGroup codeGroupDetails;
	
	
	
	
	
	/* Setters and getters for Code Bean	 */
	
	/**
	 * @return the codeId
	 */
	public int getCodeId() {
		return codeId;
	}
	/**
	 * @param codeId the codeId to set
	 */
	public void setCodeId(int codeId) {
		this.codeId = codeId;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the codeGroup
	 */
	public String getCodeGroupId() {
		return codeGroupId;
	}
	/**
	 * @param codeGroup the codeGroup to set
	 */
	public void setCodeGroupId(String codeGroup) {
		this.codeGroupId = codeGroup;
	}
	
	
	
	/*Setters and getters methods for Duplicate Check */
	/**
	 * @return the codeDuplicate
	 */
	public int getCodeDuplicate() {
		return codeDuplicate;
	}
	/**
	 * @param codeDuplicate the codeDuplicate to set
	 */
	public void setCodeDuplicate(int codeDuplicate) {
		this.codeDuplicate = codeDuplicate;
	}
	/**
	 * @return the cnId
	 */
	public int getCnId() {
		return cnId;
	}
	/**
	 * @param cnId the cnId to set
	 */
	public void setCnId(int cnId) {
		this.cnId = cnId;
	}
	
	/*For Basic Search Setter and Getter Methods*/
	
	
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
	 * @return the xmlLabelBasic
	 */
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}
	/**
	 * @param xmlLabelBasic the xmlLabelBasic to set
	 */
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
	}
	
	
	
	/*Setters and Getter Methods for Code Group Name  */
	

	/**
	 * @return the codeGroupDetails
	 */
	public CodeGroup getCodeGroupDetails() {
		return codeGroupDetails;
	}
	/**
	 * @param codeGroupDetails the codeGroupDetails to set
	 */
	public void setCodeGroupDetails(CodeGroup codeGroupDetails) {
		this.codeGroupDetails = codeGroupDetails;
	}
	public String getCodeEdit() {
		return codeEdit;
	}
	public void setCodeEdit(String codeEdit) {
		this.codeEdit = codeEdit;
	}
	public String getCodeGroupIdEdit() {
		return codeGroupIdEdit;
	}
	public void setCodeGroupIdEdit(String codeGroupIdEdit) {
		this.codeGroupIdEdit = codeGroupIdEdit;
	}
	public int getCodeIdEdit() {
		return codeIdEdit;
	}
	public void setCodeIdEdit(int codeIdEdit) {
		this.codeIdEdit = codeIdEdit;
	}
	
	

}
