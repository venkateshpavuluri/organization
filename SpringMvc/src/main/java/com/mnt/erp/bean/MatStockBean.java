/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

/**
 * @author Naresh
 * @version 1.0 13-03-2014
 */
public class MatStockBean implements Serializable,JSONStreamAware{

	private static final long serialVersionUID = 1L;
	private int matStockId;
	private int materialId;
	private int storLocId;
	private String batchNo;
	private float qtyAval;
	private String materialName;
	private String storageLocName;
	
	
	/*Realtion properties*/
	
	private StorageLocation storageLocDetails;
	private Material materialsDetails;
	
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getStorageLocName() {
		return storageLocName;
	}
	public void setStorageLocName(String storageLocName) {
		this.storageLocName = storageLocName;
	}
	public StorageLocation getStorageLocDetails() {
		return storageLocDetails;
	}
	public void setStorageLocDetails(StorageLocation storageLocDetails) {
		this.storageLocDetails = storageLocDetails;
	}
	public Material getMaterialsDetails() {
		return materialsDetails;
	}
	public void setMaterialsDetails(Material materialsDetails) {
		this.materialsDetails = materialsDetails;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getMatStockId() {
		return matStockId;
	}
	public int getMaterialId() {
		return materialId;
	}
	public int getStorLocId() {
		return storLocId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public float getQtyAval() {
		return qtyAval;
	}
	public void setMatStockId(int matStockId) {
		this.matStockId = matStockId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}
	public void setStorLocId(int storLocId) {
		this.storLocId = storLocId;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public void setQtyAval(float qtyAval) {
		this.qtyAval = qtyAval;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void writeJSONString(Writer out) throws IOException {
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("materialName", materialName);
        obj.put("storageLocName", storageLocName);
        obj.put("batchNo", batchNo);
        obj.put("qtyAval", qtyAval);
        JSONValue.writeJSONString(obj, out);
		
	}
	
	

}
