package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author ybusireddy
 * @version 20-09-2013
 */
public class AssetGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int assetGroupId;
	private String assetGroupType;
	private int assetGroupIdEdit;
	private String assetGroupTypeEdit;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	// Setter And Getter Methods

	
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
	public int getAssetGroupId() {
		return assetGroupId;
	}

	public void setAssetGroupId(int assetGroupId) {
		this.assetGroupId = assetGroupId;
	}

	public String getAssetGroupType() {
		return assetGroupType;
	}

	public void setAssetGroupType(String assetGroupType) {
		this.assetGroupType = assetGroupType;
	}

	public int getAssetGroupIdEdit() {
		return assetGroupIdEdit;
	}

	public void setAssetGroupIdEdit(int assetGroupIdEdit) {
		this.assetGroupIdEdit = assetGroupIdEdit;
	}

	public String getAssetGroupTypeEdit() {
		return assetGroupTypeEdit;
	}

	public void setAssetGroupTypeEdit(String assetGroupTypeEdit) {
		this.assetGroupTypeEdit = assetGroupTypeEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
