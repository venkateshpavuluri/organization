package com.mnt.erp.bean;

/**
 * @author Parvathi
 * @version 1.0 04-1-2014
 */
public class CodeGroup {
private int codeGroup_Id;
private String codeGroup;
private int aid;

/*Basic Search Properties*/
private String xmlLabel;
private String operations;
private String basicSearchId;


/*Edit Properties*/
private int codeGroup_IdEdit;
private String codeGroupEdit;

/*get properties*/
public int getCodeGroup_Id() {
	return codeGroup_Id;
}
public String getCodeGroup() {
	return codeGroup;
}
public String getXmlLabel() {
	return xmlLabel;
}

public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getOperations() {
	return operations;
}
public String getBasicSearchId() {
	return basicSearchId;
}
public int getCodeGroup_IdEdit() {
	return codeGroup_IdEdit;
}
public String getCodeGroupEdit() {
	return codeGroupEdit;
}
public void setCodeGroup_Id(int codeGroup_Id) {
	this.codeGroup_Id = codeGroup_Id;
}
public void setCodeGroup(String codeGroup) {
	this.codeGroup = codeGroup;
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
public void setCodeGroup_IdEdit(int codeGroup_IdEdit) {
	this.codeGroup_IdEdit = codeGroup_IdEdit;
}
public void setCodeGroupEdit(String codeGroupEdit) {
	this.codeGroupEdit = codeGroupEdit;
}



}
