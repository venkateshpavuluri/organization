package com.mnt.erp.bean;

public class Warehousebin {
	private int warehousebinId;
	private String storagetypeId;
	private String whbtypeid;
	private String whbno;
	private String whbname;
	private String storagesectionId;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private StorageType storagebean;
	private WarehouseBinType whbtypebean;
	private StorageSectionBean storagesectionbean;
	
	
	public StorageType getStoragebean() {
		return storagebean;
	}
	public void setStoragebean(StorageType storagebean) {
		this.storagebean = storagebean;
	}
	public WarehouseBinType getWhbtypebean() {
		return whbtypebean;
	}
	public void setWhbtypebean(WarehouseBinType whbtypebean) {
		this.whbtypebean = whbtypebean;
	}
	public StorageSectionBean getStoragesectionbean() {
		return storagesectionbean;
	}
	public void setStoragesectionbean(StorageSectionBean storagesectionbean) {
		this.storagesectionbean = storagesectionbean;
	}
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
	public int getWarehousebinId() {
		return warehousebinId;
	}
	public void setWarehousebinId(int warehousebinId) {
		this.warehousebinId = warehousebinId;
	}
	public String getStoragetypeId() {
		return storagetypeId;
	}
	public void setStoragetypeId(String storagetypeId) {
		this.storagetypeId = storagetypeId;
	}
	public String getWhbtypeid() {
		return whbtypeid;
	}
	public void setWhbtypeid(String whbtypeid) {
		this.whbtypeid = whbtypeid;
	}
	public String getWhbno() {
		return whbno;
	}
	public void setWhbno(String whbno) {
		this.whbno = whbno;
	}
	public String getWhbname() {
		return whbname;
	}
	public void setWhbname(String whbname) {
		this.whbname = whbname;
	}
	public String getStoragesectionId() {
		return storagesectionId;
	}
	public void setStoragesectionId(String storagesectionId) {
		this.storagesectionId = storagesectionId;
	}
	
	
	

}
