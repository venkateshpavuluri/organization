

/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class WorkCenter {

	private int workCenter_Id;
	private String workCenterName;
	private String plant_Id;
	private String shop_Id;
	private String capacityCategory_Id;
	private String workCeterCategory_Id;
	private String plantName;
	private String workCeterCategory;
	private String capcategory;
	private int aid;
	private Plant plant;
	private Shop shop;
	private String shopName;
	
	private CapacityCategory capacityCategory;
	private WorkCenterCategory workCenterCategory;
	
	
	/*Edit properties*/
	
	private int workCenter_IdEdit;
	private String workCenterNameEdit;
	private String plant_IdEdit;
	private String shop_IdEdit;
	private String capacityCategory_IdEdit;
	private String workCeterCategory_IdEdit;
	
	 /*Basic search field*/
		private String xmlLabel;
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

		private String operations;
		private String basicSearchId;
		
	/*getter methods */
	
	
	public int getWorkCenter_Id() {
		return workCenter_Id;
	}
	
	public int getAid() {
		return aid;
	}

	public String getPlantName() {
		return plantName;
	}

	public String getWorkCeterCategory() {
		return workCeterCategory;
	}

	public String getCapcategory() {
		return capcategory;
	}

	public int getWorkCenter_IdEdit() {
		return workCenter_IdEdit;
	}
	public void setWorkCenter_IdEdit(int workCenter_IdEdit) {
		this.workCenter_IdEdit = workCenter_IdEdit;
	}
	public String getWorkCenterNameEdit() {
		return workCenterNameEdit;
	}
	public void setWorkCenterNameEdit(String workCenterNameEdit) {
		this.workCenterNameEdit = workCenterNameEdit;
	}
	public String getPlant_IdEdit() {
		return plant_IdEdit;
	}
	
	

	public String getShop_Id() {
		return shop_Id;
	}

	public String getShop_IdEdit() {
		return shop_IdEdit;
	}

	public void setPlant_IdEdit(String plant_IdEdit) {
		this.plant_IdEdit = plant_IdEdit;
	}
	public String getCapacityCategory_IdEdit() {
		return capacityCategory_IdEdit;
	}
	public void setCapacityCategory_IdEdit(String capacityCategory_IdEdit) {
		this.capacityCategory_IdEdit = capacityCategory_IdEdit;
	}
	public String getWorkCeterCategory_IdEdit() {
		return workCeterCategory_IdEdit;
	}
	public void setWorkCeterCategory_IdEdit(String workCeterCategory_IdEdit) {
		this.workCeterCategory_IdEdit = workCeterCategory_IdEdit;
	}
	public String getWorkCenterName() {
		return workCenterName;
	}
	
	public WorkCenterCategory getWorkCenterCategory() {
		return workCenterCategory;
	}

	public String getPlant_Id() {
		return plant_Id;
	}
	public String getCapacityCategory_Id() {
		return capacityCategory_Id;
	}
	public String getWorkCeterCategory_Id() {
		return workCeterCategory_Id;
	}

	
	/*setter methods*/
	
	public CapacityCategory getCapacityCategory() {
		return capacityCategory;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setWorkCenter_Id(int workCenter_Id) {
		this.workCenter_Id = workCenter_Id;
	}
	
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public void setWorkCeterCategory(String workCeterCategory) {
		this.workCeterCategory = workCeterCategory;
	}

	public void setCapcategory(String capcategory) {
		this.capcategory = capcategory;
	}

	public void setWorkCenterName(String workCenterName) {
		this.workCenterName = workCenterName;
	}
	public void setPlant_Id(String plant_Id) {
		this.plant_Id = plant_Id;
	}
	public void setCapacityCategory(CapacityCategory capacityCategory) {
		this.capacityCategory = capacityCategory;
	}

	public void setCapacityCategory_Id(String capacityCategory_Id) {
		this.capacityCategory_Id = capacityCategory_Id;
	}
	public void setWorkCeterCategory_Id(String workCeterCategory_Id) {
		this.workCeterCategory_Id = workCeterCategory_Id;
	}

	

	public void setWorkCenterCategory(WorkCenterCategory workCenterCategory) {
		this.workCenterCategory = workCenterCategory;
	}

	public void setAid(int aid) {
		this.aid = aid;
		
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public void setShop_Id(String shop_Id) {
		this.shop_Id = shop_Id;
	}

	public void setShop_IdEdit(String shop_IdEdit) {
		this.shop_IdEdit = shop_IdEdit;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}
