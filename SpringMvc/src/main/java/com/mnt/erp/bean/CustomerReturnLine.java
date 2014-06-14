package com.mnt.erp.bean;

public class CustomerReturnLine {
private int customerReturnLineId;
private int customerReturnId;
private String materialId;
private int qty;
private String uOMId;
private String price;
private String reasonForRejectionId;
private String storageLocationId;
private float stockEdit;
private int salesquantity;
/*Edit properties*/
private int customerReturnLineIdEdit;
private int customerReturnIdEdit;
private int materialIdEdit;
private int qtyEdit;
private int uOMIdEdit;
private String priceEdit;
private int reasonForRejectionIdEdit;
private int storageLocationIdEdit;

/*Edit names properties*/

private String materiaName;
private String uomName;
private String storageLocName;
private String reasonForRejectionName;


/*Edit names pojos*/

private Material material;
private Uom uomDetails;
private ReasonForRejection reasonForRejectionDetails;
private StorageLocation storageLocationDetails;

/*getter methods*/
		
public int getCustomerReturnLineId() {
	return customerReturnLineId;
}
public int getSalesquantity() {
	return salesquantity;
}
public void setSalesquantity(int salesquantity) {
	this.salesquantity = salesquantity;
}
public int getCustomerReturnId() {
	return customerReturnId;
}
public String getMaterialId() {
	return materialId;
}
public int getQty() {
	return qty;
}
public String getuOMId() {
	return uOMId;
}
public String getPrice() {
	return price;
}
public String getReasonForRejectionId() {
	return reasonForRejectionId;
}
public String getStorageLocationId() {
	return storageLocationId;
}
public int getCustomerReturnLineIdEdit() {
	return customerReturnLineIdEdit;
}
public int getCustomerReturnIdEdit() {
	return customerReturnIdEdit;
}
public int getMaterialIdEdit() {
	return materialIdEdit;
}
public int getQtyEdit() {
	return qtyEdit;
}
public int getuOMIdEdit() {
	return uOMIdEdit;
}


public String getUomName() {
	return uomName;
}
public String getStorageLocName() {
	return storageLocName;
}

public String getMateriaName() {
	return materiaName;
}
public String getReasonForRejectionName() {
	return reasonForRejectionName;
}
public Material getMaterial() {
	return material;
}
public Uom getUomDetails() {
	return uomDetails;
}
public ReasonForRejection getReasonForRejectionDetails() {
	return reasonForRejectionDetails;
}
public StorageLocation getStorageLocationDetails() {
	return storageLocationDetails;
}
public String getPriceEdit() {
	return priceEdit;
}
public int getReasonForRejectionIdEdit() {
	return reasonForRejectionIdEdit;
}
public int getStorageLocationIdEdit() {
	return storageLocationIdEdit;
}



/*setter methods*/
public void setCustomerReturnLineId(int customerReturnLineId) {
	this.customerReturnLineId = customerReturnLineId;
}
public void setCustomerReturnId(int customerReturnId) {
	this.customerReturnId = customerReturnId;
}
public void setMaterialId(String materialId) {
	this.materialId = materialId;
}
public void setQty(int qty) {
	this.qty = qty;
}
public void setuOMId(String uOMId) {
	this.uOMId = uOMId;
}
public void setPrice(String price) {
	this.price = price;
}
public void setReasonForRejectionId(String reasonForRejectionId) {
	this.reasonForRejectionId = reasonForRejectionId;
}
public void setStorageLocationId(String storageLocationId) {
	this.storageLocationId = storageLocationId;
}
public void setCustomerReturnLineIdEdit(int customerReturnLineIdEdit) {
	this.customerReturnLineIdEdit = customerReturnLineIdEdit;
}
public void setCustomerReturnIdEdit(int customerReturnIdEdit) {
	this.customerReturnIdEdit = customerReturnIdEdit;
}
public void setMaterialIdEdit(int materialIdEdit) {
	this.materialIdEdit = materialIdEdit;
}
public void setQtyEdit(int qtyEdit) {
	this.qtyEdit = qtyEdit;
}
public void setuOMIdEdit(int uOMIdEdit) {
	this.uOMIdEdit = uOMIdEdit;
}
public void setPriceEdit(String priceEdit) {
	this.priceEdit = priceEdit;
}
public void setReasonForRejectionIdEdit(int reasonForRejectionIdEdit) {
	this.reasonForRejectionIdEdit = reasonForRejectionIdEdit;
}
public void setStorageLocationIdEdit(int storageLocationIdEdit) {
	this.storageLocationIdEdit = storageLocationIdEdit;
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
public void setMaterial(Material material) {
	this.material = material;
}
public void setUomDetails(Uom uomDetails) {
	this.uomDetails = uomDetails;
}
public void setReasonForRejectionDetails(
		ReasonForRejection reasonForRejectionDetails) {
	this.reasonForRejectionDetails = reasonForRejectionDetails;
}
public void setStorageLocationDetails(StorageLocation storageLocationDetails) {
	this.storageLocationDetails = storageLocationDetails;
}
public void setMateriaName(String materiaName) {
	this.materiaName = materiaName;
}
public float getStockEdit() {
	return stockEdit;
}
public void setStockEdit(float stockEdit) {
	this.stockEdit = stockEdit;
}

}
