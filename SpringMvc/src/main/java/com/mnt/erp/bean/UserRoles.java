/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class UserRoles {
private int userRoleId;
	private String userId;
	private String roleId;
	//private Users userset;
	private Role roleset;
	
	/*RelationShip properties*/
	private Users usersDetails;
	
	
	
	
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
	public String getUserId() {
		return userId;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	/*public Users getUserset() {
		return userset;
	}
	public void setUserset(Users userset) {
		this.userset = userset;
	}*/
	public Role getRoleset() {
		return roleset;
	}
	public void setRoleset(Role roleset) {
		this.roleset = roleset;
	}

	

	
}
