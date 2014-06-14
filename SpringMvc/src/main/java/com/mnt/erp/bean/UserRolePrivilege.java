/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class UserRolePrivilege {
	private int userRolePrivilegeId;
	private String roleId;
	private String userId;
	private String menuId;
	private String privilegeId;
	
	private String roleIdEdit;
	private String userIdEdit;
	
	private String roleName;
	private String userName;
	private String menuName;
	private String privilegeName;
	
	
	
	private int aid;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	/*RelationShip Properties*/
	private Users usersDetails;
	private Role roleDetails;
private MenuItems	menuDetails;
private Privilege privilegeDetails;

	
	
	
	
	
	
	/**
 * @return the roleIdEdit
 */
public String getRoleIdEdit() {
	return roleIdEdit;
}
/**
 * @param roleIdEdit the roleIdEdit to set
 */
public void setRoleIdEdit(String roleIdEdit) {
	this.roleIdEdit = roleIdEdit;
}
/**
 * @return the userIdEdit
 */
public String getUserIdEdit() {
	return userIdEdit;
}
/**
 * @param userIdEdit the userIdEdit to set
 */
public void setUserIdEdit(String userIdEdit) {
	this.userIdEdit = userIdEdit;
}
	/**
 * @return the menuDetails
 */
public MenuItems getMenuDetails() {
	return menuDetails;
}
/**
 * @param menuDetails the menuDetails to set
 */
public void setMenuDetails(MenuItems menuDetails) {
	this.menuDetails = menuDetails;
}
/**
 * @return the privilegeDetails
 */
public Privilege getPrivilegeDetails() {
	return privilegeDetails;
}
/**
 * @param privilegeDetails the privilegeDetails to set
 */
public void setPrivilegeDetails(Privilege privilegeDetails) {
	this.privilegeDetails = privilegeDetails;
}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * @return the privilegeName
	 */
	public String getPrivilegeName() {
		return privilegeName;
	}
	/**
	 * @param privilegeName the privilegeName to set
	 */
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	/**
	 * @return the usersDetails
	 */
	public Users getUsersDetails() {
		return usersDetails;
	}
	/**
	 * @param usersDetails the usersDetails to set
	 */
	public void setUsersDetails(Users usersDetails) {
		this.usersDetails = usersDetails;
	}
	/**
	 * @return the roleDetails
	 */
	public Role getRoleDetails() {
		return roleDetails;
	}
	/**
	 * @param roleDetails the roleDetails to set
	 */
	public void setRoleDetails(Role roleDetails) {
		this.roleDetails = roleDetails;
	}
	/**
	 * @return the userRolePrivilegeId
	 */
	public int getUserRolePrivilegeId() {
		return userRolePrivilegeId;
	}
	/**
	 * @param userRolePrivilegeId the userRolePrivilegeId to set
	 */
	public void setUserRolePrivilegeId(int userRolePrivilegeId) {
		this.userRolePrivilegeId = userRolePrivilegeId;
	}
	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}
	/**
	 * @param xmlLabel the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}
	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}
	/**
	 * @param basicSearchId the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the privilegeId
	 */
	public String getPrivilegeId() {
		return privilegeId;
	}
	/**
	 * @param privilegeId the privilegeId to set
	 */
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	
	

}
