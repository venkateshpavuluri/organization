package com.mnt.erp.bean;

/**
 * @author parvathi
 *
 */
public class PurOrgCompany {
	
private	int purOrgCompany_Id;
private int purOrg_Id;
private int org_Id;
private PurchaseOrganization orgbean;



public PurchaseOrganization getOrgbean() {
	return orgbean;
}
public void setOrgbean(PurchaseOrganization orgbean) {
	this.orgbean = orgbean;
}
public int getPurOrgCompany_Id() {
	return purOrgCompany_Id;
}
public void setPurOrgCompany_Id(int purOrgCompany_Id) {
	this.purOrgCompany_Id = purOrgCompany_Id;
}
public int getPurOrg_Id() {
	return purOrg_Id;
}
public void setPurOrg_Id(int purOrg_Id) {
	this.purOrg_Id = purOrg_Id;
}
public int getOrg_Id(){
	return org_Id;
}
public void setOrg_Id(int org_Id) {
	this.org_Id = org_Id;
}

}
