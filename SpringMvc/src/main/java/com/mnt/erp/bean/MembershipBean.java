/**
 * @Copyright MNTSOFT  
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
public class MembershipBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int msId;
	private int membershipId;
	private String membership;
	private int emembershipId;
	private String emembership;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	public int getMsId() {
		return msId;
	}
	public int getMembershipId() {
		return membershipId;
	}
	public String getMembership() {
		return membership;
	}
	public int getEmembershipId() {
		return emembershipId;
	}
	public String getEmembership() {
		return emembership;
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
	public void setMsId(int msId) {
		this.msId = msId;
	}
	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}
	public void setMembership(String membership) {
		this.membership = membership;
	}
	public void setEmembershipId(int emembershipId) {
		this.emembershipId = emembershipId;
	}
	public void setEmembership(String emembership) {
		this.emembership = emembership;
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
