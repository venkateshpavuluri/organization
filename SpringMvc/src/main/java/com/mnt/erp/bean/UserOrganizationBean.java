package com.mnt.erp.bean;

public class UserOrganizationBean {
	private int userorgid;
	private String orgid;
	private String userid;
	private Organization orgbean;
	
	public Organization getOrgbean() {
		return orgbean;
	}
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}
	private Users userbean;
	
	public Users getUserbean() {
		return userbean;
	}
	public void setUserbean(Users userbean) {
		this.userbean = userbean;
	}
	public int getUserorgid() {
		return userorgid;
	}
	public void setUserorgid(int userorgid) {
		this.userorgid = userorgid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	

}
