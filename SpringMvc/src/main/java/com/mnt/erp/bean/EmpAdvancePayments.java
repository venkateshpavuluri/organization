package com.mnt.erp.bean;

public class EmpAdvancePayments {
	private int eapId;
	private String empadvId;
	private String paidamount;
	private String paiddate;
	private int month;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private EmpAdvance empadvbean;

	public EmpAdvance getEmpadvbean() {
		return empadvbean;
	}

	public void setEmpadvbean(EmpAdvance empadvbean) {
		this.empadvbean = empadvbean;
	}

	public int getEapId() {
		return eapId;
	}

	public void setEapId(int eapId) {
		this.eapId = eapId;
	}

	public String getEmpadvId() {
		return empadvId;
	}

	public void setEmpadvId(String empadvId) {
		this.empadvId = empadvId;
	}

	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}

	public String getPaiddate() {
		return paiddate;
	}

	public void setPaiddate(String paiddate) {
		this.paiddate = paiddate;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
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
