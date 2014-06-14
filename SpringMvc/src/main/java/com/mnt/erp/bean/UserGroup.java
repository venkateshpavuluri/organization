/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class UserGroup {
	private int usergroupId;
	private String usergroup;
	private String usergroupSearch;
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	private int aid;
	private Users userbean;
	
	private int usergroupIdEdit;
	private String usergroupEdit;
	
	
	
	public Users getUserbean() {
		return userbean;
	}
	public void setUserbean(Users userbean) {
		this.userbean = userbean;
	}
	public int getUsergroupId() {
		return usergroupId;
	}
	public void setUsergroupId(int usergroupId) {
		this.usergroupId = usergroupId;
	}
	public String getUsergroup() {
		return usergroup;
	}
	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}
	public String getUsergroupSearch() {
		return usergroupSearch;
	}
	public void setUsergroupSearch(String usergroupSearch) {
		this.usergroupSearch = usergroupSearch;
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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUsergroupIdEdit() {
		return usergroupIdEdit;
	}
	public void setUsergroupIdEdit(int usergroupIdEdit) {
		this.usergroupIdEdit = usergroupIdEdit;
	}
	public String getUsergroupEdit() {
		return usergroupEdit;
	}
	public void setUsergroupEdit(String usergroupEdit) {
		this.usergroupEdit = usergroupEdit;
	}
	
	

}
