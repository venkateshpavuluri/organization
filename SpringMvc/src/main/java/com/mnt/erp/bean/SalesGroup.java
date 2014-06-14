package com.mnt.erp.bean;

public class SalesGroup {
	
	private int salesGroup_Id;
	private String salesOfficeId;
	
	private String salesGroup;
	private String salesOffice;
	private SalesOffice soffice;
	private int aid;
	
	/*Edit properties*/
	
	private int salesGroup_IdEdit;
	private String salesOfficeIdEdit;
	private String salesGroupEdit;
	
	
	

    /*Basic search field*/
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	/*getter methods*/
	
	
	
	
	
	public int getSalesGroup_Id() {
		return salesGroup_Id;
	}
	public int getAid() {
		return aid;
	}
	
	public SalesOffice getSoffice() {
		return soffice;
	}
	public String getSalesOffice() {
		return salesOffice;
	}
	public int getSalesGroup_IdEdit() {
		return salesGroup_IdEdit;
	}
	public String getSalesOfficeIdEdit() {
		return salesOfficeIdEdit;
	}
	public String getSalesGroupEdit() {
		return salesGroupEdit;
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
	public String getSalesOfficeId() {
		return salesOfficeId;
	}
	public String getSalesGroup() {
		return salesGroup;
	}
	
	/*setter methods*/
	public void setSalesGroup_Id(int salesGroup_Id) {
		this.salesGroup_Id = salesGroup_Id;
	}
	public void setSalesOfficeId(String salesOfficeId) {
		this.salesOfficeId = salesOfficeId;
	}
	
	
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	public void setSalesGroup(String salesGroup) {
		this.salesGroup = salesGroup;
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
	public void setSalesGroup_IdEdit(int salesGroup_IdEdit) {
		this.salesGroup_IdEdit = salesGroup_IdEdit;
	}
	public void setSalesOfficeIdEdit(String salesOfficeIdEdit) {
		this.salesOfficeIdEdit = salesOfficeIdEdit;
	}
	public void setSalesGroupEdit(String salesGroupEdit) {
		this.salesGroupEdit = salesGroupEdit;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setSoffice(SalesOffice soffice) {
		this.soffice = soffice;
	}
	
	
	
	

}
