/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author A Nikesh
 *
 */
public class Privilege {
	//================== variables for Add==========================//
	
	private String privilegeid;
	private String privilege;
	private String privilegeSearch;
	private int aid;
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	//================== variables for edit==========================//
	private String privilegeidEdit;
	private String privilegeEdit;
	//============== getters and setters=======================//
	public String getPrivilegeid() {
		return privilegeid;
	}
	public void setPrivilegeid(String privilegeid) {
		this.privilegeid = privilegeid;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	public String getPrivilegeSearch() {
		return privilegeSearch;
	}
	public void setPrivilegeSearch(String privilegeSearch) {
		this.privilegeSearch = privilegeSearch;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}

	
	//============== getters and setters for edit=======================//

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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getPrivilegeidEdit() {
		return privilegeidEdit;
	}
	public void setPrivilegeidEdit(String privilegeidEdit) {
		this.privilegeidEdit = privilegeidEdit;
	}
	public String getPrivilegeEdit() {
		return privilegeEdit;
	}
	
	public void setPrivilegeEdit(String privilegeEdit) {
		this.privilegeEdit = privilegeEdit;
	}

}
