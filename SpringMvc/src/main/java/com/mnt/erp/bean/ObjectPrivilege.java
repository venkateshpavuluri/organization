/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author venkateshp
 *
 */
public class ObjectPrivilege {
private int objectPrivilegeId;
private String menuId; 
private String privilegeId;

/*Relationship Properties*/
private MenuItems menuDetails;
private Privilege  privilegeDetails;


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
 * @return the objectPrivilegeId
 */
public int getObjectPrivilegeId() {
	return objectPrivilegeId;
}
/**
 * @param objectPrivilegeId the objectPrivilegeId to set
 */
public void setObjectPrivilegeId(int objectPrivilegeId) {
	this.objectPrivilegeId = objectPrivilegeId;
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
