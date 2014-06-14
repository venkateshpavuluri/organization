/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class ChartofAccount {
	/*Variable for ChartofAccount Bean */
	private int coaId;
	private String coa;
	private String orgId;
	
	/* Variable For Basic Search And Advanced Search*/
	private String operations;
	private String basicSearchId;
	private String xmlLabelBasic;
	
	
	/* Duplicate Check */
	private int coaDuplicate;
	private int cnId;
	
	private Organization orgDetails;
	
	/* Setters and getters for Code Bean	 */
	public int getCoaId() {
		return coaId;
	}
	public void setCoaId(int coaId) {
		this.coaId = coaId;
	}
	public String getCoa() {
		return coa;
	}
	public void setCoa(String coa) {
		this.coa = coa;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
	}
	public int getCoaDuplicate() {
		return coaDuplicate;
	}
	public void setCoaDuplicate(int coaDuplicate) {
		this.coaDuplicate = coaDuplicate;
	}
	public int getCnId() {
		return cnId;
	}
	public void setCnId(int cnId) {
		this.cnId = cnId;
	}
	public Organization getOrgDetails() {
		return orgDetails;
	}
	public void setOrgDetails(Organization orgDetails) {
		this.orgDetails = orgDetails;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
