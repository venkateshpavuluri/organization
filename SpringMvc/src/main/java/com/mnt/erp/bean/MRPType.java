/**
  
 */
package com.mnt.erp.bean;

/**
 * @author sailajach
 * @version 1.0 25-01-2014
   @build 0.0
 *
 */
public class MRPType {
	/*==========================Bean Properties===========================*/
	private int mrpTypeId;
	private String mrpType;
	private int aid;

/*==========================Edit Properties===========================*/
	private int mrpTypeIdEditt;
	private String mrpTypeEditt;
	

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	/*==========================Getter & Setters=========================*/
	
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
	public int getMrpTypeId() {
		return mrpTypeId;
	}
	public void setMrpTypeId(int mrpTypeId) {
		this.mrpTypeId = mrpTypeId;
	}
	public String getMrpType() {
		return mrpType;
	}
	public void setMrpType(String mrpType) {
		this.mrpType = mrpType;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getMrpTypeIdEditt() {
		return mrpTypeIdEditt;
	}
	public void setMrpTypeIdEditt(int mrpTypeIdEditt) {
		this.mrpTypeIdEditt = mrpTypeIdEditt;
	}
	public String getMrpTypeEditt() {
		return mrpTypeEditt;
	}
	public void setMrpTypeEditt(String mrpTypeEditt) {
		this.mrpTypeEditt = mrpTypeEditt;
	}
	
}
