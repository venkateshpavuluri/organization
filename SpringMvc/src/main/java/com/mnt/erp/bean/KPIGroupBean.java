/**
 *@Copyright MNTSOFT  
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 *
 */
public class KPIGroupBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kgId;
	private int KPIGroupId;
	private String KPIGroup;
	private int eKPIGroupId;
	private String eKPIGroup;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	public int getKPIGroupId() {
		return KPIGroupId;
	}
	public String getKPIGroup() {
		return KPIGroup;
	}
	public int geteKPIGroupId() {
		return eKPIGroupId;
	}
	public String geteKPIGroup() {
		return eKPIGroup;
	}
	public int getKgId() {
		return kgId;
	}
	public void setKgId(int kgId) {
		this.kgId = kgId;
	}
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setKPIGroupId(int kPIGroupId) {
		KPIGroupId = kPIGroupId;
	}
	public void setKPIGroup(String kPIGroup) {
		KPIGroup = kPIGroup;
	}
	public void seteKPIGroupId(int eKPIGroupId) {
		this.eKPIGroupId = eKPIGroupId;
	}
	public void seteKPIGroup(String eKPIGroup) {
		this.eKPIGroup = eKPIGroup;
	}
	
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

}
