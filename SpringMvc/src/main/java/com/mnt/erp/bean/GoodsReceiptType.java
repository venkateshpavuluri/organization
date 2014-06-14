package com.mnt.erp.bean;

import java.io.Serializable;

public class GoodsReceiptType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int aid;
	private int goodsReceiptTypeId;
	private String goodsReceiptType;
	private int goodsReceiptTypeIdEdit;
	private String goodsReceiptTypeEdit;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
		
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
	public int getGoodsReceiptTypeId() {
		return goodsReceiptTypeId;
	}

	public void setGoodsReceiptTypeId(int goodsReceiptTypeId) {
		this.goodsReceiptTypeId = goodsReceiptTypeId;
	}

	public String getGoodsReceiptType() {
		return goodsReceiptType;
	}

	public void setGoodsReceiptType(String goodsReceiptType) {
		this.goodsReceiptType = goodsReceiptType;
	}

	public int getGoodsReceiptTypeIdEdit() {
		return goodsReceiptTypeIdEdit;
	}

	public void setGoodsReceiptTypeIdEdit(int goodsReceiptTypeIdEdit) {
		this.goodsReceiptTypeIdEdit = goodsReceiptTypeIdEdit;
	}

	public String getGoodsReceiptTypeEdit() {
		return goodsReceiptTypeEdit;
	}

	public void setGoodsReceiptTypeEdit(String goodsReceiptTypeEdit) {
		this.goodsReceiptTypeEdit = goodsReceiptTypeEdit;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
