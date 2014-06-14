/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

import java.util.List;


/**
 * This is PurchaseOrganization pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class PurchaseOrganization {

/* Pojo for PurchageOrganization*/
	
private int purOrg_Id; 
private String purOrg;
private Integer[] plantId;
private Integer[] orgId;
private String plantName;
private String orgName;
private List<PurOrgPlant> purOrgPlants;
private List<PurOrgCompany> purOrgCompany;
private int aid;
private int eid;
private String xmlLabel;
private String operations;
private String basicSearchId;

/*EditProperties*/
private String editpurOrg;
private Integer[] editplantId; 
private Integer[] editorgId;


/*getter methods of PurchaseOrganization*/

public int getEid() {
	return eid;
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
public int getAid() {
	return aid;
}
public String getEditpurOrg() {
	return editpurOrg;
}
public Integer[] getEditplantId() {
	return editplantId;
}
public Integer[] getEditorgId() {
	return editorgId;
}
public int getPurOrg_Id() {
	return purOrg_Id;
}
public String getPurOrg() {
	return purOrg;
}
public Integer[] getPlantId() {
	return plantId;
}
public String getPlantName() {
	return plantName;
}
public Integer[] getOrgId() {
	return orgId;
}
public String getOrgName() {
	return orgName;
}
public List<PurOrgPlant> getPurOrgPlants() {
	return purOrgPlants;
}
public List<PurOrgCompany> getPurOrgCompany() {
	return purOrgCompany;
}



/*setter methods of purchageOrganization*/

public void setEid(int eid) {
	this.eid = eid;
}

public void setEditpurOrg(String editpurOrg) {
	this.editpurOrg = editpurOrg;
}

public void setEditplantId(Integer[] editplantId) {
	this.editplantId = editplantId;
}
public void setEditorgId(Integer[] editorgId) {
	this.editorgId = editorgId;
}

public void setPurOrg_Id(int purOrg_Id) {
	this.purOrg_Id = purOrg_Id;
}

public void setPurOrg(String purOrg) {
	this.purOrg = purOrg;
}

public void setPlantId(Integer[] plantId) {
	this.plantId = plantId;
}

public void setPlantName(String plantName) {
	this.plantName = plantName;
}

public void setOrgId(Integer[] orgId) {
	this.orgId = orgId;
}

public void setOrgName(String orgName) {
	this.orgName = orgName;
}
public void setPurOrgPlants(List<PurOrgPlant> purOrgPlants) {
	this.purOrgPlants = purOrgPlants;
}

public void setPurOrgCompany(List<PurOrgCompany> purOrgCompany) {
	this.purOrgCompany = purOrgCompany;
}

public void setAid(int aid) {
	this.aid = aid;
}

}
