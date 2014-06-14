package com.mnt.erp.bean;

/*
@author Srinivas
@version 1.0   
*/
public class AccountGroupBean {
	private int accountgroupid;
	private String accountgroup;
	private String accountgroupedit;
	private int accountgroupidedit;
	private int accountgrouphide;
	private int accountgrouphideedit;
	private String coaid;
	private String coaidedit;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
    private ChartofAccount coabean;

	public ChartofAccount getCoabean() {
	return coabean;
}

public void setCoabean(ChartofAccount coabean) {
	this.coabean = coabean;
}

	public String getCoaid() {
		return coaid;
	}

	public void setCoaid(String coaid) {
		this.coaid = coaid;
	}

	public String getCoaidedit() {
		return coaidedit;
	}

	public void setCoaidedit(String coaidedit) {
		this.coaidedit = coaidedit;
	}

	public int getAccountgroupidedit() {
		return accountgroupidedit;
	}

	public void setAccountgroupidedit(int accountgroupidedit) {
		this.accountgroupidedit = accountgroupidedit;
	}

	public String getAccountgroupedit() {
		return accountgroupedit;
	}

	public void setAccountgroupedit(String accountgroupedit) {
		this.accountgroupedit = accountgroupedit;
	}

	public int getAccountgroupid() {
		return accountgroupid;
	}

	public void setAccountgroupid(int accountgroupid) {
		this.accountgroupid = accountgroupid;
	}

	public String getAccountgroup() {
		return accountgroup;
	}

	public void setAccountgroup(String accountgroup) {
		this.accountgroup = accountgroup;
	}

	public int getAccountgrouphide() {
		return accountgrouphide;
	}

	public void setAccountgrouphide(int accountgrouphide) {
		this.accountgrouphide = accountgrouphide;
	}

	public int getAccountgrouphideedit() {
		return accountgrouphideedit;
	}

	public void setAccountgrouphideedit(int accountgrouphideedit) {
		this.accountgrouphideedit = accountgrouphideedit;
	}
	
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


}
