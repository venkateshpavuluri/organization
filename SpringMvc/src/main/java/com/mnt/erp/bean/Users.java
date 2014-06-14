package com.mnt.erp.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;




public class Users {
	
	private String user_Id;
	private String userName;
	private String userNameSearch;
	private String user;
	private String password;
	private String pass;
	private String IsActive;
	private String theme;
	private ArrayList<String> roleName;
	private String roleDisplay;
	public String getRoleDisplay() {
		return roleDisplay;
	}
	public void setRoleDisplay(String roleDisplay) {
		this.roleDisplay = roleDisplay;
	}
	private String usergroupId;
	private String functionId;
	private ArrayList<String> organizationId;
	private String validFrom;
	private String validTo;
	private UserGroup usergroupBean;
	private String usergroupName;
	private Function functionBean;
	private String functionName;
	private Organization organizationBean;
	private String organizationName;
	private UserOrganizationBean userogbean;
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	private List<UserRoles> userRolesset;
	
	private Set<UserOrganizationBean> userorgbean;
	private List<UserOrganizationBean> uorgbean;
	private ThemeBean tbean;
	public List<UserOrganizationBean> getUorgbean() {
		return uorgbean;
	}
	public void setUorgbean(List<UserOrganizationBean> uorgbean) {
		this.uorgbean = uorgbean;
	}
	private int aid;
	private String role;
	
	private String user_IdEdit;
	private String userNameEdit;
	private String passwordEdit;
	private String IsActiveEdit;
	private ArrayList<String> roleNameEdit;
	private List<UserRoles> userRolessetEdit;
	private String usergroupIdEdit;
	private String functionIdEdit;
	private ArrayList<String> organizationIdEdit;
	private String validFromEdit;
	private String validToEdit;
	private String themeEdit;
	
	
	
	public Set<UserOrganizationBean> getUserorgbean() {
		return userorgbean;
	}
	public void setUserorgbean(Set<UserOrganizationBean> userorgbean) {
		this.userorgbean = userorgbean;
	}
	public UserOrganizationBean getUserogbean() {
		return userogbean;
	}
	public void setUserogbean(UserOrganizationBean userogbean) {
		this.userogbean = userogbean;
	}
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
		
		
	public String getUserNameSearch() {
		return userNameSearch;
	}
	public void setUserNameSearch(String userNameSearch) {
		this.userNameSearch = userNameSearch;
	}
	
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getRoleName() {
		return roleName;
	}
	public void setRoleName(ArrayList<String> roleName) {
		this.roleName = roleName;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
	

	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public List<UserRoles> getUserRolesset() {
		return userRolesset;
	}
	public void setUserRolesset(List<UserRoles> userRolesset) {
		this.userRolesset = userRolesset;
	}
	
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	public String getUsergroupId() {
		return usergroupId;
	}
	public void setUsergroupId(String usergroupId) {
		this.usergroupId = usergroupId;
	}
	
	
	
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	public ArrayList<String> getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(ArrayList<String> organizationId) {
		this.organizationId = organizationId;
	}
	public String getUser_IdEdit() {
		return user_IdEdit;
	}
	public void setUser_IdEdit(String user_IdEdit) {
		this.user_IdEdit = user_IdEdit;
	}
	public String getUserNameEdit() {
		return userNameEdit;
	}
	public void setUserNameEdit(String userNameEdit) {
		this.userNameEdit = userNameEdit;
	}
	public String getPasswordEdit() {
		return passwordEdit;
	}
	public void setPasswordEdit(String passwordEdit) {
		this.passwordEdit = passwordEdit;
	}
	
	public String getIsActiveEdit() {
		return IsActiveEdit;
	}
	public void setIsActiveEdit(String isActiveEdit) {
		IsActiveEdit = isActiveEdit;
	}
	public ArrayList<String> getRoleNameEdit() {
		return roleNameEdit;
	}
	public void setRoleNameEdit(ArrayList<String> roleNameEdit) {
		this.roleNameEdit = roleNameEdit;
	}
	public List<UserRoles> getUserRolessetEdit() {
		return userRolessetEdit;
	}
	public void setUserRolessetEdit(List<UserRoles> userRolessetEdit) {
		this.userRolessetEdit = userRolessetEdit;
	}

	
	
	public String getValidFromEdit() {
		return validFromEdit;
	}
	public void setValidFromEdit(String validFromEdit) {
		this.validFromEdit = validFromEdit;
	}
	public String getValidToEdit() {
		return validToEdit;
	}
	public void setValidToEdit(String validToEdit) {
		this.validToEdit = validToEdit;
	}
	public String getUsergroupIdEdit() {
		return usergroupIdEdit;
	}
	public void setUsergroupIdEdit(String usergroupIdEdit) {
		this.usergroupIdEdit = usergroupIdEdit;
	}
	public String getFunctionIdEdit() {
		return functionIdEdit;
	}
	public void setFunctionIdEdit(String functionIdEdit) {
		this.functionIdEdit = functionIdEdit;
	}
	
	public ArrayList<String> getOrganizationIdEdit() {
		return organizationIdEdit;
	}
	public void setOrganizationIdEdit(ArrayList<String> organizationIdEdit) {
		this.organizationIdEdit = organizationIdEdit;
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
	public UserGroup getUsergroupBean() {
		return usergroupBean;
	}
	public void setUsergroupBean(UserGroup usergroupBean) {
		this.usergroupBean = usergroupBean;
	}
	public String getUsergroupName() {
		return usergroupName;
	}
	public void setUsergroupName(String usergroupName) {
		this.usergroupName = usergroupName;
	}
	public Function getFunctionBean() {
		return functionBean;
	}
	public void setFunctionBean(Function functionBean) {
		this.functionBean = functionBean;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public Organization getOrganizationBean() {
		return organizationBean;
	}
	public void setOrganizationBean(Organization organizationBean) {
		this.organizationBean = organizationBean;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public ThemeBean getTbean() {
		return tbean;
	}
	public void setTbean(ThemeBean tbean) {
		this.tbean = tbean;
	}
	public String getThemeEdit() {
		return themeEdit;
	}
	public void setThemeEdit(String themeEdit) {
		this.themeEdit = themeEdit;
	}
	

	
	
	
	
}
