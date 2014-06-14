/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author pvenkateswarlu
 * @version 1.0 24-09-2013
 */
public class StorageLocOrg {
	private int storageLocationOrgId;
	private int orgId;
	private int storageLocationId;

	/**
	 * @return the storageLocationId
	 */
	public int getStorageLocationId() {
		return storageLocationId;
	}

	/**
	 * @param storageLocationId
	 *            the storageLocationId to set
	 */
	public void setStorageLocationId(int storageLocationId) {
		this.storageLocationId = storageLocationId;
	}

	/**
	 * @return the storageLocationOrgId
	 */
	public int getStorageLocationOrgId() {
		return storageLocationOrgId;
	}

	/**
	 * @param storageLocationOrgId
	 *            the storageLocationOrgId to set
	 */
	public void setStorageLocationOrgId(int storageLocationOrgId) {
		this.storageLocationOrgId = storageLocationOrgId;
	}

	/**
	 * @return the orgId
	 */
	public int getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}
