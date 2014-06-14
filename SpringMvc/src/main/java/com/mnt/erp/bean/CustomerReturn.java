package com.mnt.erp.bean;

import java.util.List;

public class CustomerReturn {

private int customerReturnId;
private String customerReturnNo;
private String customerReturnDate;
private String reference;
private String description;
private String salesOrderId;
private int aid;
private SalesOrderBean salesOrderBean;
private float stockEdit;

/*Basic search properties*/

private String xmlLabel;
private String operations;
private String basicSearchId;

/*Advandced search properties*/

private String firstLabel;
private String secondLabel;
private String operations1;
private String advanceSearchText;
private int advanceSearchHidden;

private List<CustomerReturnLine> customerReturnLine;

/*Edit properties*/

private int customerReturnIdEdit;
private String customerReturnNoEdit;
private String customerReturnDateEdit;
private String referenceEdit;
private String descriptionEdit;
private String salesOrderIdEdit;

/*customer Return line properties*/
private int customerReturnLineId;
private int materialId;
private Integer[] qty;
private int uOMId;
private String[] price;
private int reasonForRejectionId;
private int storageLocationId;
//private Integer[] quantity;
private Integer[] prices;

/*Edit names properties*/

private String materiaName;
private String uomName;
private String storageLocName;
private String reasonForRejectionName;


/*drop down properties*/

private String materialids;
private String uoms;
private String reasonForRejection;
private String storageLocation;


/*drop down Edit properties*/
private int[] customerReturnLineIdEdit;
private String materialidsEdit;
private String uomsEdit;
private String reasonForRejectionEdit;
private String storageLocationEdit;
private Integer[] qtyEdit;
private String[] priceEdit;
private int reasonForRejectionIdEdit;
private int storageLocationIdEdit;

private int salesquantity;
private int salesquantityEdit;
/*getter methods*/

public int getCustomerReturnId() {
	return customerReturnId;
}
public int getSalesquantityEdit() {
	return salesquantityEdit;
}
public void setSalesquantityEdit(int salesquantityEdit) {
	this.salesquantityEdit = salesquantityEdit;
}
public int getSalesquantity() {
	return salesquantity;
}
public void setSalesquantity(int salesquantity) {
	this.salesquantity = salesquantity;
}
public String getCustomerReturnNo() {
	return customerReturnNo;
}

public String getMaterialids() {
	return materialids;
}
public String getUoms() {
	return uoms;
}
public String getReasonForRejection() {
	return reasonForRejection;
}
public String getStorageLocation() {
	return storageLocation;
}
public String getCustomerReturnDate() {
	return customerReturnDate;
}
public String getReference() {
	return reference;
}
public String getDescription() {
	return description;
}
public String getSalesOrderId() {
	return salesOrderId;
}

public int[] getCustomerReturnLineIdEdit() {
	return customerReturnLineIdEdit;
}

public String getUomName() {
	return uomName;
}

public String getMaterialidsEdit() {
	return materialidsEdit;
}
public String getUomsEdit() {
	return uomsEdit;
}
public String getReasonForRejectionEdit() {
	return reasonForRejectionEdit;
}
public String getStorageLocationEdit() {
	return storageLocationEdit;
}
public Integer[] getQtyEdit() {
	return qtyEdit;
}
public String[] getPriceEdit() {
	return priceEdit;
}
public String getStorageLocName() {
	return storageLocName;
}
public String getReasonForRejectionName() {
	return reasonForRejectionName;
}
public int getCustomerReturnIdEdit() {
	return customerReturnIdEdit;
}
public String getCustomerReturnNoEdit() {
	return customerReturnNoEdit;
}
public String getCustomerReturnDateEdit() {
	return customerReturnDateEdit;
}
public String getReferenceEdit() {
	return referenceEdit;
}
public String getDescriptionEdit() {
	return descriptionEdit;
}

public String getMateriaName() {
	return materiaName;
}
public String getXmlLabel() {
	return xmlLabel;
}
public String getOperations() {
	return operations;
}
public String getBasicSearchId() {
	return basicSearchId;
}
public String getFirstLabel() {
	return firstLabel;
}
public String getSecondLabel() {
	return secondLabel;
}
public String getOperations1() {
	return operations1;
}
public String getAdvanceSearchText() {
	return advanceSearchText;
}
public int getAdvanceSearchHidden() {
	return advanceSearchHidden;
}
/*public Integer[] getQuantity() {
	return quantity;
}*/
public Integer[] getPrices() {
	return prices;
}
public int getAid() {
	return aid;
}

public int getReasonForRejectionIdEdit() {
	return reasonForRejectionIdEdit;
}
public int getStorageLocationIdEdit() {
	return storageLocationIdEdit;
}
public List<CustomerReturnLine> getCustomerReturnLine() {
	return customerReturnLine;
}
public int getCustomerReturnLineId() {
	return customerReturnLineId;
}
public int getMaterialId() {
	return materialId;
}

public SalesOrderBean getSalesOrderBean() {
	return salesOrderBean;
}
public Integer[] getQty() {
	return qty;
}
public int getuOMId() {
	return uOMId;
}
public String[] getPrice() {
	return price;
}
public int getReasonForRejectionId() {
	return reasonForRejectionId;
}
public int getStorageLocationId() {
	return storageLocationId;
}
public String getSalesOrderIdEdit() {
	return salesOrderIdEdit;
}

/*setter methods*/


public void setCustomerReturnId(int customerReturnId) {
	this.customerReturnId = customerReturnId;
}
public void setCustomerReturnNo(String customerReturnNo) {
	this.customerReturnNo = customerReturnNo;
}
public void setCustomerReturnDate(String customerReturnDate) {
	this.customerReturnDate = customerReturnDate;
}
public void setReference(String reference) {
	this.reference = reference;
}
public void setDescription(String description) {
	this.description = description;
}
public void setSalesOrderId(String salesOrderId) {
	this.salesOrderId = salesOrderId;
}
public void setCustomerReturnIdEdit(int customerReturnIdEdit) {
	this.customerReturnIdEdit = customerReturnIdEdit;
}
public void setCustomerReturnNoEdit(String customerReturnNoEdit) {
	this.customerReturnNoEdit = customerReturnNoEdit;
}
public void setCustomerReturnDateEdit(String customerReturnDateEdit) {
	this.customerReturnDateEdit = customerReturnDateEdit;
}
public void setReferenceEdit(String referenceEdit) {
	this.referenceEdit = referenceEdit;
}
public void setDescriptionEdit(String descriptionEdit) {
	this.descriptionEdit = descriptionEdit;
}

public void setAid(int aid) {
	this.aid = aid;
}
public void setSalesOrderIdEdit(String salesOrderIdEdit) {
	this.salesOrderIdEdit = salesOrderIdEdit;
}
public void setMaterialids(String materialids) {
	this.materialids = materialids;
}
public void setUoms(String uoms) {
	this.uoms = uoms;
}
public void setReasonForRejection(String reasonForRejection) {
	this.reasonForRejection = reasonForRejection;
}
public void setStorageLocation(String storageLocation) {
	this.storageLocation = storageLocation;
}
public void setCustomerReturnLineId(int customerReturnLineId) {
	this.customerReturnLineId = customerReturnLineId;
}
public void setMaterialId(int materialId) {
	this.materialId = materialId;
}
public void setQty(Integer[] qty) {
	this.qty = qty;
}
public void setuOMId(int uOMId) {
	this.uOMId = uOMId;
}
public void setPrice(String[] price) {
	this.price = price;
}
public void setReasonForRejectionId(int reasonForRejectionId) {
	this.reasonForRejectionId = reasonForRejectionId;
}
public void setStorageLocationId(int storageLocationId) {
	this.storageLocationId = storageLocationId;
}
public void setCustomerReturnLine(List<CustomerReturnLine> customerReturnLine) {
	this.customerReturnLine = customerReturnLine;
}

public void setPrices(Integer[] prices) {
	this.prices = prices;
}
public void setXmlLabel(String xmlLabel) {
	this.xmlLabel = xmlLabel;
}
public void setOperations(String operations) {
	this.operations = operations;
}
public void setBasicSearchId(String basicSearchId) {
	this.basicSearchId = basicSearchId;
}
public void setFirstLabel(String firstLabel) {
	this.firstLabel = firstLabel;
}
public void setSecondLabel(String secondLabel) {
	this.secondLabel = secondLabel;
}
public void setOperations1(String operations1) {
	this.operations1 = operations1;
}
public void setAdvanceSearchText(String advanceSearchText) {
	this.advanceSearchText = advanceSearchText;
}
public void setAdvanceSearchHidden(int advanceSearchHidden) {
	this.advanceSearchHidden = advanceSearchHidden;
}
public void setSalesOrderBean(SalesOrderBean salesOrderBean) {
	this.salesOrderBean = salesOrderBean;
}

public void setUomName(String uomName) {
	this.uomName = uomName;
}
public void setStorageLocName(String storageLocName) {
	this.storageLocName = storageLocName;
}
public void setReasonForRejectionName(String reasonForRejectionName) {
	this.reasonForRejectionName = reasonForRejectionName;
}
public void setMaterialidsEdit(String materialidsEdit) {
	this.materialidsEdit = materialidsEdit;
}
public void setUomsEdit(String uomsEdit) {
	this.uomsEdit = uomsEdit;
}
public void setReasonForRejectionEdit(String reasonForRejectionEdit) {
	this.reasonForRejectionEdit = reasonForRejectionEdit;
}
public void setStorageLocationEdit(String storageLocationEdit) {
	this.storageLocationEdit = storageLocationEdit;
}
public void setQtyEdit(Integer[] qtyEdit) {
	this.qtyEdit = qtyEdit;
}
public void setPriceEdit(String[] priceEdit) {
	this.priceEdit = priceEdit;
}
public void setCustomerReturnLineIdEdit(int[] customerReturnLineIdEdit) {
	this.customerReturnLineIdEdit = customerReturnLineIdEdit;
}
public void setMateriaName(String materiaName) {
	this.materiaName = materiaName;
}
public void setReasonForRejectionIdEdit(int reasonForRejectionIdEdit) {
	this.reasonForRejectionIdEdit = reasonForRejectionIdEdit;
}
public void setStorageLocationIdEdit(int storageLocationIdEdit) {
	this.storageLocationIdEdit = storageLocationIdEdit;
}
public float getStockEdit() {
	return stockEdit;
}
public void setStockEdit(float stockEdit) {
	this.stockEdit = stockEdit;
}


}
