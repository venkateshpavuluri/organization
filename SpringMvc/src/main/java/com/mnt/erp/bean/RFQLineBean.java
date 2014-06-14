package com.mnt.erp.bean;

import org.springframework.stereotype.Component;

@Component
public class RFQLineBean {
private int rfqlineid;
private String rfqlinetypeid;
private String materialid;
private int qty;
private String uomid;
private String deliverydate;
private int rfqlineidedit;
private String rfqlinetypeidedit;
private String materialidedit;
private String materialidName;
private int qtyedit;
private String uomidedit;
private String uomidName;
private String deliverydateedit;
private Material materialdetail;
private Uom uomdetail;


public String getMaterialidName() {
	return materialidName;
}
public void setMaterialidName(String materialidName) {
	this.materialidName = materialidName;
}
public String getUomidName() {
	return uomidName;
}
public void setUomidName(String uomidName) {
	this.uomidName = uomidName;
}
public Material getMaterialdetail() {
	return materialdetail;
}
public void setMaterialdetail(Material materialdetail) {
	this.materialdetail = materialdetail;
}
public Uom getUomdetail() {
	return uomdetail;
}
public void setUomdetail(Uom uomdetail) {
	this.uomdetail = uomdetail;
}
public int getRfqlineid() {
	return rfqlineid;
}
public void setRfqlineid(int rfqlineid) {
	this.rfqlineid = rfqlineid;
}

public String getRfqlinetypeid() {
	return rfqlinetypeid;
}
public void setRfqlinetypeid(String rfqlinetypeid) {
	this.rfqlinetypeid = rfqlinetypeid;
}

public String getMaterialid() {
	return materialid;
}
public void setMaterialid(String materialid) {
	this.materialid = materialid;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public String getUomid() {
	return uomid;
}
public void setUomid(String uomid) {
	this.uomid = uomid;
}
public String getDeliverydate() {
	return deliverydate;
}
public void setDeliverydate(String deliverydate) {
	this.deliverydate = deliverydate;
}
public int getRfqlineidedit() {
	return rfqlineidedit;
}
public void setRfqlineidedit(int rfqlineidedit) {
	this.rfqlineidedit = rfqlineidedit;
}

public String getRfqlinetypeidedit() {
	return rfqlinetypeidedit;
}
public void setRfqlinetypeidedit(String rfqlinetypeidedit) {
	this.rfqlinetypeidedit = rfqlinetypeidedit;
}
public String getMaterialidedit() {
	return materialidedit;
}
public void setMaterialidedit(String materialidedit) {
	this.materialidedit = materialidedit;
}
public int getQtyedit() {
	return qtyedit;
}
public void setQtyedit(int qtyedit) {
	this.qtyedit = qtyedit;
}
public String getUomidedit() {
	return uomidedit;
}
public void setUomidedit(String uomidedit) {
	this.uomidedit = uomidedit;
}
public String getDeliverydateedit() {
	return deliverydateedit;
}
public void setDeliverydateedit(String deliverydateedit) {
	this.deliverydateedit = deliverydateedit;
}

}
