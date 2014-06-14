package com.mnt.erp.bean;

public class VendorInvoiceLine {
	private int vendorinvoicelineid;
	private String materialid;
	private int qty;
	private String uomid;
	private String price;
	private String tax;
	
	private int editvendorinvoicelineid;
	private String editmaterialid;
	private int editqty;
	private String edituomid;
	private String editprice;
	private String edittax;
	
	private Material materialdetail;
	private Uom uomdetail;
	
	private String materialidName;
	private String uomidName;
	
	
	public String getUomidName() {
		return uomidName;
	}
	public void setUomidName(String uomidName) {
		this.uomidName = uomidName;
	}
	public String getMaterialidName() {
		return materialidName;
	}
	public void setMaterialidName(String materialidName) {
		this.materialidName = materialidName;
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
	public int getVendorinvoicelineid() {
		return vendorinvoicelineid;
	}
	public void setVendorinvoicelineid(int vendorinvoicelineid) {
		this.vendorinvoicelineid = vendorinvoicelineid;
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
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public int getEditvendorinvoicelineid() {
		return editvendorinvoicelineid;
	}
	public void setEditvendorinvoicelineid(int editvendorinvoicelineid) {
		this.editvendorinvoicelineid = editvendorinvoicelineid;
	}
	
	public String getEditmaterialid() {
		return editmaterialid;
	}
	public void setEditmaterialid(String editmaterialid) {
		this.editmaterialid = editmaterialid;
	}
	public int getEditqty() {
		return editqty;
	}
	public void setEditqty(int editqty) {
		this.editqty = editqty;
	}
	public String getEdituomid() {
		return edituomid;
	}
	public void setEdituomid(String edituomid) {
		this.edituomid = edituomid;
	}
	public String getEditprice() {
		return editprice;
	}
	public void setEditprice(String editprice) {
		this.editprice = editprice;
	}
	public String getEdittax() {
		return edittax;
	}
	public void setEdittax(String edittax) {
		this.edittax = edittax;
	}
	
	

}
